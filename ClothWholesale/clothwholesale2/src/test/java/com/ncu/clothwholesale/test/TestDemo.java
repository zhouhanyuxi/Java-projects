package com.ncu.clothwholesale.test;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.experimental.theories.FromDataPoints;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ncu.clothwholesale.mapper.AdminMapper;
import com.ncu.clothwholesale.mapper.PurchaseOrderMapper;
import com.ncu.clothwholesale.mapper.WarehouseIORecordMapper;
import com.ncu.clothwholesale.pojo.OrderDayRec;
import com.ncu.clothwholesale.pojo.OrderYearRec;
import com.ncu.clothwholesale.pojo.PurchaseItem;
import com.ncu.clothwholesale.pojo.PurchaseOrder;
import com.ncu.clothwholesale.pojo.PurchaseOrderExample;
import com.ncu.clothwholesale.pojo.WarehouseIORecord;
import com.ncu.clothwholesale.pojo.WholesaleItem;
import com.ncu.clothwholesale.pojo.WholesaleOrder;
import com.ncu.clothwholesale.service.WholesaleService;
import com.ncu.clothwholesale.serviceImpl.AdminServiceImpl;
import com.ncu.clothwholesale.serviceImpl.InventoryServiceImpl;
import com.ncu.clothwholesale.serviceImpl.PurchaseServiceImpl;
import com.ncu.clothwholesale.serviceImpl.StatisticsServiceImpl;
import com.ncu.clothwholesale.serviceImpl.WholesaleServiceImpl;
import com.ncu.clothwholesale.tool.BaseConstrant;
import com.ncu.clothwholesale.tool.BusinessException;
import com.ncu.clothwholesale.tool.MyDataFormatUtil;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations="classpath:config/spring/applicationContext.xml")
public class TestDemo {
	@Autowired
	private AdminMapper adminMapper;
	@Autowired
	private AdminServiceImpl adminService;
	@Autowired
	private PurchaseServiceImpl purchaseService;
	@Autowired
	private InventoryServiceImpl invenService;
	@Autowired
	private StatisticsServiceImpl statisticService;
	@Autowired
	private PurchaseOrderMapper pOrderMapper;
	@Autowired
	private WholesaleServiceImpl saleService;
	
	@Test
	public void test(){
		
		//登录
//		try {
//			adminService.login("GJ001", "123456");
//		} catch (BusinessException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
			
		
		//新增采购订单
//		PurchaseOrder pOrder = new PurchaseOrder();
//		pOrder.setAdminCode("CG001");
//		pOrder.setSupplierCode("GYS01");
//		pOrder.setRemark("测试");
//		purchaseService.createPurchaseOrder(pOrder);
//		ArrayList<PurchaseItem> list = new ArrayList<PurchaseItem>();
//		
//		PurchaseItem pItem = new PurchaseItem();
//		pItem.setModelCode("GYS0100001001");
//		pItem.setPurchaseOrdCode(pOrder.getPurchaseOrdCode());
//		pItem.setOrignalPrice((float) 21);
//		pItem.setTotalNum(300);
//		list.add(pItem);
//		
//		pItem = new PurchaseItem();
//		pItem.setModelCode("GYS0100001001");
//		//pItem.setPurchaseOrdCode(pOrder.getPurchaseOrdCode());
//		pItem.setTotalNum(300);
//		pItem.setOrignalPrice((float) 20);
//		list.add(pItem);
//		try {
//			System.out.println(pItem.toString());
//			purchaseService.createPurchaseItems(list);
//		} catch (BusinessException e) {
//			// TODO Auto-generated catch block
//			System.out.println(e.getMessage());
//		}

		//新增批发订单
//		WholesaleOrder order = new WholesaleOrder();
//		order.setShippingAddrNum((long)2);
//		order.setUsername("zhouhan");
//		try {
//			WholesaleOrder wholesaleOrder = saleService.createWholesaleOrder(order);
//			System.out.println(wholesaleOrder.toString());
//		} catch (BusinessException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}

		
		
//		//新增入库记录
//		WarehouseIORecord warehouseIORecord = new WarehouseIORecord();
//		warehouseIORecord.setAdminCode("CK001");
//		warehouseIORecord.setIOMark("I");
//		warehouseIORecord.setModelCode("GYS0100001001");
//		warehouseIORecord.setNumberChange(3000);
//		warehouseIORecord.setReason(BaseConstrant.WAREHOUSE_IO_REASON_PURCHASE);
//		warehouseIORecord.setRemark("测试");
//		warehouseIORecord.setWarehouseCode("CK01");
//		warehouseIORecord.setOrdCode("CG20190412100700002");
//		try {
//			invenService.createPurcItemWarehouseIORec(warehouseIORecord);
//		} catch (BusinessException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		//更新订单日记录
//		try {
//			OrderDayRec o = statisticService.createOrderDayRecord(2019, 4, 12, "CG");
//			System.out.println(o.toString());
//		} catch (BusinessException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}
//		
		try {
			List<OrderYearRec> yList = statisticService.updateRecords();
			for(int i=0;i<yList.size();i++){
				System.out.println(yList.get(i).toString());
			}
		} catch (BusinessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		

	}

}
