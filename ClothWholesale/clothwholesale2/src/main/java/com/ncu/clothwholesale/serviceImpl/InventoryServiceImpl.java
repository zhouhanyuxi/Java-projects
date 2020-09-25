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
import com.ncu.clothwholesale.dto.WarehouseIORecSearch;
import com.ncu.clothwholesale.mapper.InventoryContentMapper;
import com.ncu.clothwholesale.mapper.ProductModelMapper;
import com.ncu.clothwholesale.mapper.PurchaseItemMapper;
import com.ncu.clothwholesale.mapper.WarehouseIORecordMapper;
import com.ncu.clothwholesale.mapper.WarehouseMapper;
import com.ncu.clothwholesale.mapper.WholesaleItemMapper;
import com.ncu.clothwholesale.mapper.WholesaleOrderMapper;
import com.ncu.clothwholesale.pojo.InventoryContent;
import com.ncu.clothwholesale.pojo.InventoryContentExample;
import com.ncu.clothwholesale.pojo.ProductModel;
import com.ncu.clothwholesale.pojo.PurchaseItem;
import com.ncu.clothwholesale.pojo.Warehouse;
import com.ncu.clothwholesale.pojo.WarehouseIORecord;
import com.ncu.clothwholesale.pojo.WarehouseIORecordExample;
import com.ncu.clothwholesale.pojo.WarehouseIORecordExample.Criteria;
import com.ncu.clothwholesale.pojo.WholesaleItem;
import com.ncu.clothwholesale.pojo.WholesaleItemExample;
import com.ncu.clothwholesale.pojo.WholesaleOrder;
import com.ncu.clothwholesale.service.InventoryService;
import com.ncu.clothwholesale.tool.BaseConstrant;
import com.ncu.clothwholesale.tool.BusinessException;
import com.ncu.clothwholesale.tool.MyDataFormatUtil;
import com.ncu.clothwholesale.tool.ValidateUtil;
import com.ncu.clothwholesale.tool.ValidateUtils;
import com.ncu.clothwholesale.tool.ValidateUtils.DefaultPageInfoName;

@Service
public class InventoryServiceImpl implements InventoryService {

	@Autowired
	private WarehouseIORecordMapper warehouseIORecMapper;
	@Autowired
	private InventoryContentMapper invenContMapper;
	@Autowired
	private ProductModelMapper prodModelMapper;
	@Autowired
	private PurchaseItemMapper purcItemMapper;
	@Autowired
	private WholesaleOrderMapper saleOrdMapper;
	@Autowired
	private WholesaleItemMapper saleItemMapper;
	@Autowired
	private WarehouseMapper warehouseMapper;
	
	/**
	 * 新建出入库记录
	 */
	@Transactional(rollbackFor=Exception.class)
	@Override
	public boolean createIORecord(WarehouseIORecord warehouseIORecord)throws BusinessException{
		Date now = Calendar.getInstance().getTime();
		warehouseIORecord.setTime(now);
		//设置记录编号
		String IORecCodeString = "";
		if(!ValidateUtil.JudgeEmpty(warehouseIORecord.getIOMark())){
			if(warehouseIORecord.getIOMark()=="I")
				IORecCodeString += "RK";
			else if(warehouseIORecord.getIOMark()=="O"){
				IORecCodeString += "CK";
			}
			warehouseIORecord.setWarehouseIORecCode(IORecCodeString+MyDataFormatUtil.DateToYMDHMSS(now));
			//库存内容更新
			InventoryContentExample example = new InventoryContentExample();
			InventoryContentExample.Criteria criteria = example.createCriteria();
			criteria.andModelCodeEqualTo(warehouseIORecord.getModelCode());
			criteria.andWarehouseCodeEqualTo(warehouseIORecord.getWarehouseCode());
			List<InventoryContent> list = invenContMapper.selectByExample(example);
			if(list.size()==1){//已有库存，更新库存数量
				InventoryContent invenCont = list.get(0);
				if(warehouseIORecord.getIOMark() == "I")
					invenCont.setContentSum(invenCont.getContentSum()+warehouseIORecord.getNumberChange());
				else if(warehouseIORecord.getIOMark() == "O"){
					if(warehouseIORecord.getNumberChange()<=invenCont.getContentSum())
						invenCont.setContentSum(invenCont.getContentSum()-warehouseIORecord.getNumberChange());
					else{
						throw new BusinessException("库存不足");
					}
				}
				invenContMapper.updateByPrimaryKey(invenCont);
			}else{//新增库存
				InventoryContent invenCont = new InventoryContent();
				invenCont.setContentSum(warehouseIORecord.getNumberChange());
				invenCont.setModelCode(warehouseIORecord.getModelCode());
				invenCont.setWarehouseCode(warehouseIORecord.getWarehouseCode());
				invenContMapper.insert(invenCont);
			}
			//产品型号更新产品数量
			ProductModel pModel = prodModelMapper.selectByPrimaryKey(warehouseIORecord.getModelCode());
			if(pModel!=null){
				if(warehouseIORecord.getIOMark() == "I")
					pModel.setTotalNum(pModel.getTotalNum()+warehouseIORecord.getNumberChange());
				else if(warehouseIORecord.getIOMark() == "O"){
					pModel.setTotalNum(pModel.getTotalNum()-warehouseIORecord.getNumberChange());
				}
				prodModelMapper.updateByPrimaryKey(pModel);
			}
			//插入出入库记录
			if(warehouseIORecMapper.insertSelective(warehouseIORecord) != 1){
				throw new BusinessException("插入出入库记录失败！");
			}else{
				return true;
			}
		}else{
			throw new BusinessException("出入标识为空");
		}
	}

	/**
	 * 采购订单项入库
	 */
//	@Transactional(rollbackFor=Exception.class)
//	@Override
//	public boolean createPurcItemWarehouseIORec(WarehouseIORecord warehouseIORecord)throws BusinessException{
//		//订单相关的出入库记录
//		if(warehouseIORecord.getOrdCode()!=null && warehouseIORecord.getOrdCode().startsWith("CG")){
//			//查找订单项
//			PurchaseItemExample example = new PurchaseItemExample();
//			PurchaseItemExample.Criteria criteria = example.createCriteria();
//			criteria.andPurchaseOrdCodeEqualTo(warehouseIORecord.getOrdCode());
//			criteria.andModelCodeEqualTo(warehouseIORecord.getModelCode());
//			
//			List<PurchaseItem> list = purcItemMapper.selectByExample(example);
//			if(list!= null && list.size()==1){
//				if(list.get(0).getState().equals(BaseConstrant.PURCHASE_ITEM_STATE_STORING)){
//					if(createIORecord(warehouseIORecord)){//生成出入库记录
//						list.get(0).setState(BaseConstrant.PURCHASE_ITEM_STATE_STORED);
//						if(purcItemMapper.updateByPrimaryKey(list.get(0))==1)//更新订单项状态
//							return true;
//						else{
//							throw new BusinessException("订单项状态更新失败！");
//						}
//					}
//				}else{
//					throw new BusinessException("该采购订单非待入库状态！");
//				}
//			}else{
//				throw new BusinessException("未找到订单项！");
//			}
//		}else{
//			throw new BusinessException("该订单非采购订单！");
//		}
//		return false;
//	}

	/**
	 * 批发发货出库
	 */
//	@Transactional(rollbackFor=Exception.class)
//	@Override
//	public boolean createWholesaleOrderIORec(WarehouseIORecord warehouseIORecord)
//			throws BusinessException {
//		//订单相关的出入库记录
//		if(warehouseIORecord.getOrdCode()!=null && warehouseIORecord.getOrdCode().startsWith("PF")){
//			//查找批发订单
//			WholesaleOrder wOrder = saleOrdMapper.selectByPrimaryKey(warehouseIORecord.getOrdCode());
//			if(wOrder!=null && wOrder.getOrderState().equals(BaseConstrant.WHOLESALE_ORDER_STATE_SHIPPING)){
//				//查找订单项
//				WholesaleItemExample example = new WholesaleItemExample();
//				WholesaleItemExample.Criteria criteria = example.createCriteria();
//				criteria.andWholesaleOrdCodeEqualTo(warehouseIORecord.getOrdCode());
//				criteria.andModelCodeEqualTo(warehouseIORecord.getModelCode());
//				
//				List<WholesaleItem> list = saleItemMapper.selectByExample(example);
//				if(list!= null && list.size()>0){
//					if(list.get(0).getModelCode().equals(warehouseIORecord.getModelCode())){
//						createIORecord(warehouseIORecord);//生成出入库记录
//						list.get(0).setState(BaseConstrant.WHOLESALE_ITEM_STATE_SHIPPED);
//						if(saleItemMapper.updateByPrimaryKey(list.get(0))==1)//更新采购订单项状态
//							return true;
//						else{
//							throw new BusinessException("订单项状态更新失败！");
//						}
//					}
//				}else{
//					throw new BusinessException("未找到订单项！");
//				}
//			}else{
//				throw new BusinessException("该批发订单非已付款状态！");
//			}
//		}else{
//			throw new BusinessException("该订单非采购订单！");
//		}
//		return false;
//	}

	@Override
	public List<WarehouseIORecord> findWarehouseIORec(WarehouseIORecSearch search)throws Exception{
		String recCode = MyDataFormatUtil.dateToSeachCode(search.getYear(), search.getMonth(), search.getDay());
		WarehouseIORecordExample example = new WarehouseIORecordExample();
		Criteria criteria = example.createCriteria();
		criteria.andWarehouseIORecCodeLike("%K"+recCode+"%");
		criteria.andAdminCodeEqualTo(search.getAdminCode());
		if(!ValidateUtil.JudgeEmpty(search.getiORecCode()))
			criteria.andWarehouseIORecCodeLike("%"+search.getiORecCode()+"%");
		if(!ValidateUtil.JudgeEmpty(search.getReason()))
			criteria.andReasonEqualTo(search.getReason());
		if(!ValidateUtil.JudgeEmpty(search.getWarehouseCode()))
			criteria.andWarehouseCodeLike("%"+search.getWarehouseCode()+"%");
		if(!ValidateUtil.JudgeEmpty(search.getModelCode()))
			criteria.andModelCodeLike("%"+search.getModelCode()+"%");
		
		List<WarehouseIORecord> list = warehouseIORecMapper.selectByExample(example);
		if(list.size()<1){
			throw new BusinessException("未找到出入记录！");
		}
		return null;
	}

	@Override
	public Object listIOByCondition(Map<String, Object> args) {
		ValidateUtils.ValidatePageInfo(args);
		PageHelper.startPage((Integer)args.get(DefaultPageInfoName.PAGE_NAME.toString()), 
							(Integer)args.get(DefaultPageInfoName.SIZE_NAME.toString()));
		List<Map<String,Object>> lists = warehouseIORecMapper.listByCondition(args);
		PageInfo<Map<String, Object>> pageInfo = new PageInfo<>(lists);
		return pageInfo;
	}

	@Override
	public Object listByCondition(Map<String, Object> args) {
		ValidateUtils.ValidatePageInfo(args);
		PageHelper.startPage((Integer)args.get(DefaultPageInfoName.PAGE_NAME.toString()), 
							(Integer)args.get(DefaultPageInfoName.SIZE_NAME.toString()));
		List<Map<String,Object>> lists = invenContMapper.listByCondition(args);
		PageInfo<Map<String, Object>> pageInfo = new PageInfo<>(lists);
		return pageInfo;
	}

	/**
	 * 采购订单项入库
	 */
	@Transactional(rollbackFor=Exception.class)
	@Override
	public boolean putPurchaseItemIn(String warehouseCode, String purchaseItemCode,String adminCode) throws Exception {
		Warehouse w = warehouseMapper.selectByPrimaryKey(warehouseCode);
		if(w == null)throw new BusinessException("未找到仓库！");
		PurchaseItem p = purcItemMapper.selectByPrimaryKey(purchaseItemCode);
	
		if((w.getCapacity()-w.getInventory())>p.getTotalNum()){
			//出入库记录
			WarehouseIORecord ioRecord = new WarehouseIORecord();
			ioRecord.setAdminCode(adminCode);
			ioRecord.setIOMark("I");
			ioRecord.setModelCode(p.getModelCode());
			ioRecord.setNumberChange(p.getTotalNum());
			ioRecord.setOrdCode(p.getPurchaseOrdCode());
			ioRecord.setReason("CG");
			Date now = Calendar.getInstance().getTime();
			ioRecord.setTime(now);
			ioRecord.setWarehouseCode(warehouseCode);
			ioRecord.setWarehouseIORecCode("RK"+MyDataFormatUtil.DateToYMDHMSS(now));
			warehouseIORecMapper.insert(ioRecord);
			//更新库存容量
			w.setInventory(w.getInventory()+p.getTotalNum());
			warehouseMapper.updateByPrimaryKeySelective(w);
			//更新订单状态
			p.setState(BaseConstrant.PURCHASE_ITEM_STATE_STORED);
			purcItemMapper.updateByPrimaryKeySelective(p);
			//更新产品型号数量
			ProductModel pm = prodModelMapper.selectByPrimaryKey(p.getModelCode());
			pm.setTotalNum(pm.getTotalNum()+p.getTotalNum());
			pm.setModelCode(p.getModelCode());
			prodModelMapper.updateByPrimaryKeySelective(pm);
			//更新库存内容
			InventoryContentExample example = new InventoryContentExample();
			com.ncu.clothwholesale.pojo.InventoryContentExample.Criteria criteria = example.createCriteria();
			criteria.andModelCodeEqualTo(p.getModelCode());
			criteria.andWarehouseCodeEqualTo(warehouseCode);
			List<InventoryContent> list = invenContMapper.selectByExample(example);
			if(list.size()>=1){
				list.get(0).setContentSum(list.get(0).getContentSum()+p.getTotalNum());
				if(invenContMapper.updateByPrimaryKeySelective(list.get(0))==1)
					return true;
			}else{//新建库存内容
				InventoryContent inContent = new InventoryContent();
				inContent.setContentSum(p.getTotalNum());
				inContent.setModelCode(p.getModelCode());
				inContent.setWarehouseCode(warehouseCode);
				
				if(invenContMapper.insertSelective(inContent)==1)
					return true;
			}
		}else{
			throw new BusinessException("该仓库空间不足");
		}
		return false;
	}
	
	/**
	 * 批发订单项出库
	 */
	@Transactional(rollbackFor=Exception.class)
	@Override
	public String putWholesaleItemOut(String wholesaleItemCode,String adminCode) throws Exception {
		
		WholesaleItem w = saleItemMapper.selectByPrimaryKey(wholesaleItemCode);
		System.out.println(w.toString());
		//寻找库存内容
		InventoryContentExample example = new InventoryContentExample();
		com.ncu.clothwholesale.pojo.InventoryContentExample.Criteria criteria = example.createCriteria();
		criteria.andModelCodeEqualTo(w.getModelCode());
		List<InventoryContent> list = invenContMapper.selectByExample(example);
		if(list.size()>=1){
			InventoryContent inContent = null;
			for(int i=0;i<list.size();i++){
				if(list.get(i).getContentSum()>=w.getTotalNum()){
					inContent = list.get(i);
					break;
				}
			}
			if(inContent!=null){
				//出入库记录
				WarehouseIORecord ioRecord = new WarehouseIORecord();
				ioRecord.setAdminCode(adminCode);
				ioRecord.setIOMark("O");
				ioRecord.setModelCode(w.getModelCode());
				ioRecord.setNumberChange(w.getTotalNum());
				ioRecord.setOrdCode(w.getWholesaleOrdCode());
				ioRecord.setReason("PF");
				Date now = Calendar.getInstance().getTime();
				ioRecord.setTime(now);
				ioRecord.setWarehouseCode(inContent.getWarehouseCode());
				ioRecord.setWarehouseIORecCode("CK"+MyDataFormatUtil.DateToYMDHMSS(now));
				warehouseIORecMapper.insert(ioRecord);
				
				//更新库存内容
				inContent.setContentSum(inContent.getContentSum()-w.getTotalNum());
				invenContMapper.updateByPrimaryKeySelective(inContent);
				//更新库存容量
				Warehouse warehouse = warehouseMapper.selectByPrimaryKey(inContent.getWarehouseCode());
				warehouse.setInventory(warehouse.getInventory()-w.getTotalNum());
				warehouseMapper.updateByPrimaryKeySelective(warehouse);
				//更新订单项状态
				w.setState(BaseConstrant.WHOLESALE_ITEM_STATE_SHIPPED);
				saleItemMapper.updateByPrimaryKeySelective(w);
				//更新产品型号数量
				ProductModel pModel = prodModelMapper.selectByPrimaryKey(w.getModelCode());
				pModel.setTotalNum(pModel.getTotalNum()-w.getTotalNum());
				prodModelMapper.updateByPrimaryKeySelective(pModel);
				//更新订单状态
				WholesaleItemExample example2 = new WholesaleItemExample();
				com.ncu.clothwholesale.pojo.WholesaleItemExample.Criteria criteria2 = example2.createCriteria();
				criteria2.andWholesaleOrdCodeEqualTo(w.getWholesaleOrdCode());
				criteria2.andStateEqualTo(BaseConstrant.WHOLESALE_ITEM_STATE_NORMAL);
				List<WholesaleItem> list2 = saleItemMapper.selectByExample(example2);
				if(list2.size()==0){
					WholesaleOrder wOrder = new WholesaleOrder();
					wOrder.setWholesaleOrdCode(w.getWholesaleOrdCode());
					wOrder.setOrderState(BaseConstrant.WHOLESALE_ORDER_STATE_SHIPPED);
					saleOrdMapper.updateByPrimaryKeySelective(wOrder);
				}
				return warehouse.getWarehouseCode();
			}else{
				throw new BusinessException("库存不足");
			}
		}else{
			throw new BusinessException("该产品型号没有库存");
		}
	}
}
