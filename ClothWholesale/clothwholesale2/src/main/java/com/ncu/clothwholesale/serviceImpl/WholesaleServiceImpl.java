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
import com.ncu.clothwholesale.mapper.ComMonIORecordMapper;
import com.ncu.clothwholesale.mapper.CusMonIORecMapper;
import com.ncu.clothwholesale.mapper.WholesaleCancelRecMapper;
import com.ncu.clothwholesale.mapper.WholesaleItemMapper;
import com.ncu.clothwholesale.mapper.WholesaleOrderMapper;
import com.ncu.clothwholesale.pojo.ComMonIORecord;
import com.ncu.clothwholesale.pojo.CusMonIORec;
import com.ncu.clothwholesale.pojo.WholesaleItem;
import com.ncu.clothwholesale.pojo.WholesaleItemExample;
import com.ncu.clothwholesale.pojo.WholesaleItemExample.Criteria;
import com.ncu.clothwholesale.pojo.WholesaleOrder;
import com.ncu.clothwholesale.service.WholesaleService;
import com.ncu.clothwholesale.tool.BaseConstrant;
import com.ncu.clothwholesale.tool.BusinessException;
import com.ncu.clothwholesale.tool.MyDataFormatUtil;
import com.ncu.clothwholesale.tool.ValidateUtils;
import com.ncu.clothwholesale.tool.ValidateUtils.DefaultPageInfoName;

@Service
public class WholesaleServiceImpl implements WholesaleService{
	@Autowired
	private WholesaleOrderMapper saleOrderMapper;
	@Autowired
	private WholesaleItemMapper saleItemMapper;
	@Autowired
	private ComMonIORecordMapper comIORecMapper;
	@Autowired
	private CusMonIORecMapper cusIORecMapper;
	@Autowired
	private WholesaleCancelRecMapper saleCanRecMapper;

	/**
	 * 创建批发订单
	 */
	@Override
	public WholesaleOrder createWholesaleOrder(WholesaleOrder wOrder) throws Exception {
		//获取时间设置信息
			Date now = Calendar.getInstance().getTime();
			wOrder.setTime(now);
			wOrder.setWholesaleOrdCode("PF"+MyDataFormatUtil.DateToYMDHMSS(now));
			wOrder.setOrderState(BaseConstrant.WHOLESALE_ORDER_STATE_PAYING);
			//wOrder.setSumPrice(0.0);

			if(saleOrderMapper.insertSelective(wOrder) == 1)//插入成功
				return wOrder;
			else//插入失败
				return null;
	}
	
	/**
	 * 插入订单项
	 */
	@Transactional(rollbackFor=Exception.class)
	@Override
	public boolean createWholesaleItems(WholesaleItem wItem) throws Exception {
		boolean ret = true;
		
		WholesaleItemExample example = new WholesaleItemExample();
		Criteria criteria = example.createCriteria();
		criteria.andWholesaleOrdCodeEqualTo(wItem.getWholesaleOrdCode());
		int num = saleItemMapper.countByExample(example);
		
		if(num<=99){
			for(int i=0;i<num;i++){
				//设置信息
				String itemCode = wItem.getWholesaleOrdCode()+MyDataFormatUtil.unitFormatTen(i+1);
				wItem.setWholesaleItemCode(itemCode);
				wItem.setState(BaseConstrant.WHOLESALE_ITEM_STATE_NORMAL);
				wItem.setTotalPrice((double)wItem.getPrice()*wItem.getTotalNum());
				
				if(saleItemMapper.insert(wItem)!=1){
					ret = false;
					throw new BusinessException("保存失败，请重新保存！");
				}
			}
			//更新订单总价
			WholesaleOrder wOrder = saleOrderMapper.selectByPrimaryKey(wItem.getWholesaleOrdCode());
			wOrder.setSumPrice(wOrder.getSumPrice()+wItem.getTotalPrice());
			saleOrderMapper.updateByPrimaryKey(wOrder);
		}else{
			throw new BusinessException("每个订单最多99个订单项！");
		}
		return ret;
	}

	/**
	 * 批发订单付款
	 */
	@Transactional(rollbackFor=Exception.class)
	@Override
	public boolean payWholesaleOrder(String wOrderCode, String username)
			throws Exception {
		WholesaleOrder wOrder = saleOrderMapper.selectByPrimaryKey(wOrderCode);
		
		if(wOrder!=null){
			wOrder.setOrderState(BaseConstrant.WHOLESALE_ORDER_STATE_PAID);
			saleOrderMapper.updateByPrimaryKey(wOrder);
			//插入客户款项流水
			CusMonIORec cusIORec = new CusMonIORec();
			Date now = Calendar.getInstance().getTime();
			cusIORec.setCusMonIORecCode("KO"+MyDataFormatUtil.DateToYMDHMSS(now));
			cusIORec.setIOmark("O");
			cusIORec.setMoney(-wOrder.getSumPrice());
			cusIORec.setReason(BaseConstrant.CUSTOMER_IO_REASON_WHOLESALE);
			cusIORec.setTime(now);
			cusIORec.setUsername(username);
			cusIORec.setWholesaleOrdCode(wOrderCode);
			cusIORecMapper.insert(cusIORec);
			//插入批发公司流水
			ComMonIORecord comIoRec = new ComMonIORecord();
			comIoRec.setAdminCode("XT001");
			comIoRec.setAmount(wOrder.getSumPrice());
			comIoRec.setComIORecCode("PI"+MyDataFormatUtil.DateToYMDHMSS(now));
			comIoRec.setIOmark("I");
			comIoRec.setOrdCode(wOrderCode);
			comIoRec.setReason(BaseConstrant.COMPANY_IO_REASON_PURCHASE);
			comIoRec.setTime(now);
			comIORecMapper.insert(comIoRec);
			return true;
		}
		return false;
	}

	@Override
	public Object listByCondition(Map<String, Object> args) {
		ValidateUtils.ValidatePageInfo(args);
		PageHelper.startPage((Integer)args.get(DefaultPageInfoName.PAGE_NAME.toString()), 
							(Integer)args.get(DefaultPageInfoName.SIZE_NAME.toString()));
		List<Map<String,Object>> lists = saleOrderMapper.listByCondition(args);
		PageInfo<Map<String, Object>> pageInfo = new PageInfo<>(lists);
		return pageInfo;
	}

	@Override
	public Object listCancelByCondition(Map<String, Object> args) {
		ValidateUtils.ValidatePageInfo(args);
		PageHelper.startPage((Integer)args.get(DefaultPageInfoName.PAGE_NAME.toString()), 
							(Integer)args.get(DefaultPageInfoName.SIZE_NAME.toString()));
		List<Map<String,Object>> lists = saleCanRecMapper.listByCondition(args);
		PageInfo<Map<String, Object>> pageInfo = new PageInfo<>(lists);
		return pageInfo;
	}

	@Override
	public Object listWMoneyIOByCondition(Map<String, Object> args) {
		ValidateUtils.ValidatePageInfo(args);
		PageHelper.startPage((Integer)args.get(DefaultPageInfoName.PAGE_NAME.toString()), 
							(Integer)args.get(DefaultPageInfoName.SIZE_NAME.toString()));
		List<Map<String,Object>> lists = comIORecMapper.listByCondition(args);
		PageInfo<Map<String, Object>> pageInfo = new PageInfo<>(lists);
		return pageInfo;
	}

	@Override 
	public Object listWholeItemByCondition(Map<String, Object> args) {
		ValidateUtils.ValidatePageInfo(args);
		PageHelper.startPage((Integer)args.get(DefaultPageInfoName.PAGE_NAME.toString()), 
							(Integer)args.get(DefaultPageInfoName.SIZE_NAME.toString()));
		List<Map<String,Object>> lists = saleItemMapper.listByCondition(args);
		PageInfo<Map<String, Object>> pageInfo = new PageInfo<>(lists);
		return pageInfo;
	}

	@Override
	public boolean wholesaleOutApply(String wholesasleOrdCode) throws Exception {
		WholesaleOrder wOrder =  saleOrderMapper.selectByPrimaryKey(wholesasleOrdCode);
		if(wOrder!=null){
			if(wOrder.getOrderState().equals(BaseConstrant.WHOLESALE_ORDER_STATE_PAID)){
				wOrder.setOrderState(BaseConstrant.WHOLESALE_ORDER_STATE_SHIPPING);
				if(saleOrderMapper.updateByPrimaryKeySelective(wOrder)==1)
					return true;
			}else{
				throw new BusinessException("订单状态必须为已支付");
			}
		}
		return false;
	}

	
	
}
