package com.ncu.clothwholesale.serviceImpl;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ncu.clothwholesale.dto.ComMonIORecSearch;
import com.ncu.clothwholesale.dto.PurchaseOrderSearch;
import com.ncu.clothwholesale.mapper.ComMonIORecordMapper;
import com.ncu.clothwholesale.mapper.PurchaseItemMapper;
import com.ncu.clothwholesale.mapper.PurchaseOrderMapper;
import com.ncu.clothwholesale.pojo.ComMonIORecord;
import com.ncu.clothwholesale.pojo.ComMonIORecordExample;
import com.ncu.clothwholesale.pojo.PurchaseItem;
import com.ncu.clothwholesale.pojo.PurchaseItemExample;
import com.ncu.clothwholesale.pojo.PurchaseOrder;
import com.ncu.clothwholesale.pojo.WarehouseIORecord;
import com.ncu.clothwholesale.pojo.WholesaleOrder;
import com.ncu.clothwholesale.service.PurchaseService;
import com.ncu.clothwholesale.tool.BaseConstrant;
import com.ncu.clothwholesale.tool.BusinessException;
import com.ncu.clothwholesale.tool.MyDataFormatUtil;
import com.ncu.clothwholesale.tool.ValidateUtil;
import com.ncu.clothwholesale.tool.ValidateUtils;
import com.ncu.clothwholesale.tool.ValidateUtils.DefaultPageInfoName;

/**
 * 采购模块
 * @author Dell
 * 
 */
@Service
public class PurchaseServiceImpl implements PurchaseService{
	
	@Autowired
	private PurchaseOrderMapper purcOrdMapper;
	@Autowired
	private PurchaseItemMapper purcItemMapper;
	@Autowired
	private ComMonIORecordMapper ComMonIORecMapper;
	
	/**
	 * 创建新采购订单
	 */
	@Override
	public PurchaseOrder createPurchaseOrder(PurchaseOrder pOrder) {
		//获取时间,设置信息
		Date now = Calendar.getInstance().getTime();
		pOrder.setTime(now);
		pOrder.setPurchaseOrdCode("CG"+MyDataFormatUtil.DateToYMDHMSS(now));
		pOrder.setSumPrice(0.0);
		pOrder.setPaidPrice(0.0);
		System.out.println("serviceImpl"+pOrder.toString());
		if(purcOrdMapper.insertSelective(pOrder) == 1)//插入成功
			return pOrder;
		else//插入失败
			return null;
	}
	
	/**
	 * 插入订单项
	 */
	@Transactional(rollbackFor=Exception.class)
	@Override
	public String createPurchaseItem(PurchaseItem pItem) throws Exception {
		String ret = "";
		
		PurchaseItemExample example = new PurchaseItemExample();
		com.ncu.clothwholesale.pojo.PurchaseItemExample.Criteria criteria = example.createCriteria();
		criteria.andPurchaseOrdCodeEqualTo(pItem.getPurchaseOrdCode());
		int num = purcItemMapper.countByExample(example);
		
		if(num<=99){
			String purcItemCode = pItem.getPurchaseOrdCode()+MyDataFormatUtil.unitFormatTen(num+1);
			pItem.setPurchaseItemCode(purcItemCode);
			pItem.setState(BaseConstrant.PURCHASE_ITEM_STATE_PAYING);
			pItem.setTotalPrice((double)pItem.getOrignalPrice()*pItem.getTotalNum());
			
			if(purcItemMapper.insertSelective(pItem)!=1){
				throw new BusinessException("保存失败，请重新保存！");
			}

			//更新订单总价
			if(purcOrdMapper.updatePurcOrdSumPrice(pItem.getPurchaseOrdCode(), pItem.getTotalPrice())!=1){
				throw new BusinessException("订单总价更新失败，请重新保存！");
			}else{
				ret = purcItemCode;
			}
		}else{
			throw new BusinessException("每个订单最多99个订单项！");
		}
		return ret;
	}

	/**
	 * 依据时间查询采购流水
	 */
	@Override
	public List<ComMonIORecord> findMonOutRecords(ComMonIORecSearch search) throws Exception{
		String recCode = MyDataFormatUtil.dateToSeachCode(search.getYear(), search.getMonth(), search.getDay());
		ComMonIORecordExample example = new ComMonIORecordExample();
		com.ncu.clothwholesale.pojo.ComMonIORecordExample.Criteria criteria = example.createCriteria();
		criteria.andComIORecCodeLike("PO"+recCode+"%");
		criteria.andAdminCodeLike(search.getAdminCode());
		if(!ValidateUtil.JudgeEmpty(search.getiORecCode()))
			criteria.andComIORecCodeLike("%"+search.getiORecCode()+"%");
		criteria.andReasonEqualTo(BaseConstrant.COMPANY_IO_REASON_PURCHASE);
		
		List<ComMonIORecord> list = ComMonIORecMapper.selectByExample(example);
		if(list.size()<=0){
			throw new BusinessException("未找到记录！");
		}else
			return list;
	}

	/**
	 * 采购订单项付款
	 * @param pItemCode
	 * @return
	 * @throws Exception
	 */
	@Transactional(rollbackFor=Exception.class)
	@Override
	public boolean payForPurchaseItem(String pItemCode,Double price,String adminCode)throws Exception {
		PurchaseItem pItem = purcItemMapper.selectByPrimaryKey(pItemCode);
		if(pItem!=null){
			if(pItem.getState().equals(BaseConstrant.PURCHASE_ITEM_STATE_PAYING)){
				pItem.setState(BaseConstrant.PURCHASE_ITEM_STATE_PAID);
				if(purcItemMapper.updateByPrimaryKey(pItem)<1){
					throw new BusinessException("更新订单项状态失败！");
				}else if(purcOrdMapper.updatePurcOrdPaidPrice(pItem.getPurchaseOrdCode(),pItem.getTotalPrice())<1){
					throw new BusinessException("更新订单已支付款项失败！");
				}else{
					ComMonIORecord record = new ComMonIORecord();
					record.setAdminCode(adminCode);
					record.setAmount(-price);
					record.setIOmark("O");
					record.setOrdCode(pItem.getPurchaseOrdCode());
					record.setReason("CG");
					Date now = Calendar.getInstance().getTime();
					record.setTime(now);
					record.setComIORecCode("PO"+MyDataFormatUtil.DateToYMDHMSS(now));
					
					if(ComMonIORecMapper.insertSelective(record)==1){
						return true;
					}else{
						throw new BusinessException("生成支付流水失败！");
					}
				}
			}else{
				throw new BusinessException("订单项非待支付状态！");
			}
		}else{
			throw new  BusinessException("未找到订单项！");
		}
		
	}

	/**
	 * 查询采购订单项
	 */
	@Override
	public Object findPurchaseOrders(PurchaseOrderSearch pOrderSearch,String adminCode)throws Exception{
		String purcOrdCode = MyDataFormatUtil.dateToSeachCode(pOrderSearch.getYear(), pOrderSearch.getMonth(), pOrderSearch.getDay());
		
		String supplierCode = "";
		if(pOrderSearch.getSupplierCode()!=null && !pOrderSearch.getSupplierCode().equals("")){
			supplierCode += pOrderSearch.getSupplierCode();
		}
		
		if(adminCode.contains("GJ"))adminCode = "";
		
		System.out.println(purcOrdCode+adminCode+supplierCode+pOrderSearch.getType());
		
		/*
		ValidateUtil.ValidatePageInfo(arguments);
		PageHelper.startPage((Integer)arguments.get(DefaultPageInfoName.PAGE_NAME.toString()), 
							(Integer)arguments.get(DefaultPageInfoName.SIZE_NAME.toString()));
		List<Map<String,Object>> allTemplate = departmentInfoMapper.queryByCondition(arguments);
		PageInfo<Map<String, Object>> pageInfo = new PageInfo<>(allTemplate);
		
		return pageInfo;
		*/
		return null;
			
	}

	@Override
	public Object listByCondition(Map<String, Object> args) {
		ValidateUtils.ValidatePageInfo(args);
		PageHelper.startPage((Integer)args.get(DefaultPageInfoName.PAGE_NAME.toString()), 
							(Integer)args.get(DefaultPageInfoName.SIZE_NAME.toString()));
		List<Map<String,Object>> lists = purcOrdMapper.listByCondition(args);
		PageInfo<Map<String, Object>> pageInfo = new PageInfo<>(lists);
		return pageInfo;
	}

	@Override
	public Object listPMoneyIOByCondition(Map<String, Object> args) {
		ValidateUtils.ValidatePageInfo(args);
		PageHelper.startPage((Integer)args.get(DefaultPageInfoName.PAGE_NAME.toString()), 
							(Integer)args.get(DefaultPageInfoName.SIZE_NAME.toString()));
		List<Map<String,Object>> lists = ComMonIORecMapper.listByCondition(args);
		PageInfo<Map<String, Object>> pageInfo = new PageInfo<>(lists);
		return pageInfo;
	}
	
	@Override
	public Object listPurcItemByCondition(Map<String, Object> args) {
		ValidateUtils.ValidatePageInfo(args);
		PageHelper.startPage((Integer)args.get(DefaultPageInfoName.PAGE_NAME.toString()), 
							(Integer)args.get(DefaultPageInfoName.SIZE_NAME.toString()));
		List<Map<String,Object>> lists = purcItemMapper.listByCondition(args);
		PageInfo<Map<String, Object>> pageInfo = new PageInfo<>(lists);
		return pageInfo;
	}

	@Override
	public boolean purchaseInApply(String pItemCode) throws Exception {
		PurchaseItem pItem = purcItemMapper.selectByPrimaryKey(pItemCode);
		if(pItem!=null){
			if(pItem.getState().equals(BaseConstrant.PURCHASE_ITEM_STATE_PAID)){
				pItem.setState(BaseConstrant.PURCHASE_ITEM_STATE_STORING);
				if(purcItemMapper.updateByPrimaryKeySelective(pItem)==1)
					return true;
			}else{
				throw new BusinessException("订单状态必须为已支付");
			}
		}
		return false;
	}
	

	

}
