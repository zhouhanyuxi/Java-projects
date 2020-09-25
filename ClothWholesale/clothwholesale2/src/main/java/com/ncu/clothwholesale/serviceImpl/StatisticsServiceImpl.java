package com.ncu.clothwholesale.serviceImpl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.ncu.clothwholesale.mapper.OrderDayRecMapper;
import com.ncu.clothwholesale.mapper.OrderMonRecMapper;
import com.ncu.clothwholesale.mapper.OrderYearRecMapper;
import com.ncu.clothwholesale.mapper.PurchaseOrderMapper;
import com.ncu.clothwholesale.mapper.WholesaleOrderMapper;
import com.ncu.clothwholesale.pojo.OrderDayRec;
import com.ncu.clothwholesale.pojo.OrderDayRecExample;
import com.ncu.clothwholesale.pojo.OrderMonRec;
import com.ncu.clothwholesale.pojo.OrderMonRecExample;
import com.ncu.clothwholesale.pojo.OrderYearRec;
import com.ncu.clothwholesale.pojo.PurchaseOrder;
import com.ncu.clothwholesale.pojo.PurchaseOrderExample;
import com.ncu.clothwholesale.pojo.WholesaleOrder;
import com.ncu.clothwholesale.pojo.WholesaleOrderExample;
import com.ncu.clothwholesale.service.StatisticsService;
import com.ncu.clothwholesale.tool.BaseConstrant;
import com.ncu.clothwholesale.tool.BusinessException;
import com.ncu.clothwholesale.tool.MyDataFormatUtil;
import com.ncu.clothwholesale.tool.ValidateUtils;
import com.ncu.clothwholesale.tool.ValidateUtils.DefaultPageInfoName;

@Service
public class StatisticsServiceImpl implements StatisticsService {
	@Autowired
	private OrderDayRecMapper ordDayRecMapper;
	@Autowired
	private OrderMonRecMapper ordMonRecMapper;
	@Autowired
	private OrderYearRecMapper ordYearRecMapper;
	@Autowired
	private PurchaseOrderMapper pOrderMapper;
	@Autowired
	private WholesaleOrderMapper wOrderMapper;

	/**
	 * 生成订单销售日记录
	 */
	@Transactional(rollbackFor=Exception.class)
	@Override
	public OrderDayRec createOrderDayRecord(int year, int mon, int day, String type)
			throws BusinessException {
		if("CG".equals(type)){
			//查找当日采购订单
			PurchaseOrderExample example = new PurchaseOrderExample();
			PurchaseOrderExample.Criteria criteria = example.createCriteria();
			criteria.andPurchaseOrdCodeLike("%CG"+year+MyDataFormatUtil.unitFormatTen(mon)
					+MyDataFormatUtil.unitFormatTen(day)+"%");
			List<PurchaseOrder> pList = pOrderMapper.selectByExample(example);
			System.out.println("pList size:"+pList.size());
			//计算已付款总金额
			double sum = 0;
			for(int i=0;i<pList.size();i++){
				sum+=pList.get(i).getPaidPrice();
				System.out.println(pList.get(i).toString());
			}
			//判断当日记录是否已存在
			OrderDayRec dayRec = ordDayRecMapper.selectByPrimaryKey("CD"+year+
					MyDataFormatUtil.unitFormatTen(mon)+MyDataFormatUtil.unitFormatTen(day));
			if(dayRec==null){
				System.out.println("当日记录不存在");
				dayRec = new OrderDayRec();
				//设置信息
				dayRec.setDay(MyDataFormatUtil.unitFormatTen(day));
				dayRec.setMonth(MyDataFormatUtil.unitFormatTen(mon));
				dayRec.setYear(Integer.toString(year));
				dayRec.setOrdDayRecCode("CD"+year+MyDataFormatUtil.unitFormatTen(mon)+
						MyDataFormatUtil.unitFormatTen(day));
				dayRec.setOrderNum(pList.size());
				dayRec.setMoneyNum(sum);
				//添加到数据库
				if(ordDayRecMapper.insert(dayRec)==1){
					System.out.println(dayRec.toString());
					return dayRec;
				}
			}else{
				dayRec.setOrderNum(pList.size());
				dayRec.setMoneyNum(sum);
				if(ordDayRecMapper.updateByPrimaryKey(dayRec)==1){
					System.out.println(dayRec.toString());
					return dayRec;
				}
			}
		}else if("PF".equals(type)){
			//查找当日已付款批发订单
			WholesaleOrderExample example1 = new WholesaleOrderExample();
			WholesaleOrderExample.Criteria criteria1 = example1.createCriteria();
			criteria1.andWholesaleOrdCodeLike("%PF"+year+MyDataFormatUtil.unitFormatTen(mon)+
					MyDataFormatUtil.unitFormatTen(day)+"%");
			criteria1.andOrderStateEqualTo(BaseConstrant.WHOLESALE_ORDER_STATE_PAID);
			
			List<WholesaleOrder> wList = wOrderMapper.selectByExample(example1);
			double sum = 0;
			//计算总金额
			for(int i=0;i<wList.size();i++){
				sum+=wList.get(i).getSumPrice();
			}
			//判断当日记录是否已存在
			OrderDayRec dayRec = ordDayRecMapper.selectByPrimaryKey("PD"+year
					+MyDataFormatUtil.unitFormatTen(mon)+
					MyDataFormatUtil.unitFormatTen(day));
			if(dayRec==null){
				dayRec = new OrderDayRec();
				//设置信息
				dayRec.setDay(MyDataFormatUtil.unitFormatTen(day));
				dayRec.setMonth(MyDataFormatUtil.unitFormatTen(mon));
				dayRec.setYear(Integer.toString(year));
				dayRec.setOrdDayRecCode("PD"+year+MyDataFormatUtil.unitFormatTen(mon)+
						MyDataFormatUtil.unitFormatTen(day));
				dayRec.setOrderNum(wList.size());
				dayRec.setMoneyNum(sum);
				//添加到数据库
				if(ordDayRecMapper.insert(dayRec)==1)
					return dayRec;
			}else{
				dayRec.setOrderNum(wList.size());
				dayRec.setMoneyNum(sum);
				if(ordDayRecMapper.updateByPrimaryKey(dayRec)==1)
					return dayRec;
			}
		}
		return null;
	}

	@Transactional(rollbackFor=Exception.class)
	@Override
	public List<OrderMonRec> createOrderMonRecords(int year, int mon)
			throws BusinessException {
		List<OrderMonRec> oList = new ArrayList<OrderMonRec>();
		//采购订单月记录
		OrderMonRec pOrderMonRec = createOrderMonRecord(year, mon, 'C');
		if(pOrderMonRec != null)
			oList.add(pOrderMonRec);
		//批发订单月记录
		OrderMonRec wOrderMonRec = createOrderMonRecord(year, mon, 'P');
		if(wOrderMonRec != null)
			oList.add(wOrderMonRec);
		
		return oList;
	}
	
	/**
	 * 生成订单月记录
	 * @param year
	 * @param mon
	 * @param type 订单种类，采购订单为'C'，批发订单为'P'
	 * @return
	 */
	public OrderMonRec createOrderMonRecord(int year, int mon,char type){
		//查找当月订单日记录
		OrderDayRecExample example = new OrderDayRecExample();
		OrderDayRecExample.Criteria criteria = example.createCriteria();
		criteria.andOrdDayRecCodeLike("%"+type+"D"+year+MyDataFormatUtil.unitFormatTen(mon)+"%");
		List<OrderDayRec> dList = ordDayRecMapper.selectByExample(example);
		//计算总金额
		double money = 0;
		int num = 0;
		for(int i=0;i<dList.size();i++){
			money+=dList.get(i).getMoneyNum();
			num+=dList.get(i).getOrderNum();
		}
		//判断当月采购月记录是否存在
		OrderMonRec monRec = ordMonRecMapper.selectByPrimaryKey(""+type+"M"+
				year+MyDataFormatUtil.unitFormatTen(mon));
		if(monRec != null){
			monRec.setMoneyNum(money);
			monRec.setOrderNum(num);
			if(ordMonRecMapper.updateByPrimaryKey(monRec)==1)
				return monRec;
		}else{
			//设置信息
			monRec = new OrderMonRec();
			monRec.setMonth(MyDataFormatUtil.unitFormatTen(mon));
			monRec.setYear(Integer.toString(year));
			monRec.setOrdMonRecCode(""+type+"M"+year+MyDataFormatUtil.unitFormatTen(mon));
			monRec.setMoneyNum(money);
			monRec.setOrderNum(num);
			//添加到数据库
			if(ordMonRecMapper.insert(monRec)==1)
				return monRec;
		}
		return null;
	}

	@Transactional(rollbackFor=Exception.class)
	@Override
	public List<OrderYearRec> createOrderYearRecords(int year) throws BusinessException {
		List<OrderYearRec> oList = new ArrayList<OrderYearRec>();
		//采购订单年记录
		OrderYearRec pOrderYearRec = createOrderYearRecord(year, 'C');
		if(pOrderYearRec != null)
			oList.add(pOrderYearRec);
		//批发订单年记录
		OrderYearRec wOrderYearRec = createOrderYearRecord(year, 'P');
		if(wOrderYearRec != null)
			oList.add(wOrderYearRec);
		
		return oList;
	}
	
	public OrderYearRec createOrderYearRecord(int year,char type){
		//查找当年订单月记录
		OrderMonRecExample example = new OrderMonRecExample();
		OrderMonRecExample.Criteria criteria = example.createCriteria();
		criteria.andOrdMonRecCodeLike("%"+type+"M"+year+"%");
		List<OrderMonRec> mList = ordMonRecMapper.selectByExample(example);
		//计算总金额
		double money = 0;
		int num = 0;
		for(int i=0;i<mList.size();i++){
			money+=mList.get(i).getMoneyNum();
			num+=mList.get(i).getOrderNum();
		}
		//判断当年采购月记录是否存在
		OrderYearRec yearRec = ordYearRecMapper.selectByPrimaryKey(""+type+"Y"+year);
		if(yearRec != null){
			yearRec.setMoneyNum(money);
			yearRec.setOrderNum(num);
			if(ordYearRecMapper.updateByPrimaryKey(yearRec)==1)
				return yearRec;
		}else{
			//设置信息
			yearRec = new OrderYearRec();
			yearRec.setYear(Integer.toString(year));
			yearRec.setOrdYearRecCode(""+type+"Y"+year);
			yearRec.setMoneyNum(money);
			yearRec.setOrderNum(num);
			//添加到数据库
			if(ordYearRecMapper.insert(yearRec)==1)
				return yearRec;
		}
		return null;
	}

	/**
	 * 更新全部订单销售记录
	 */
	@Transactional(rollbackFor=Exception.class)
	@Override
	public List<OrderYearRec> updateRecords()
			throws BusinessException {
		//获取全部采购订单
		PurchaseOrderExample example = new PurchaseOrderExample();
		PurchaseOrderExample.Criteria criteria = example.createCriteria();
		example.setOrderByClause("time");//按日期顺序排列
		List<PurchaseOrder> pList = pOrderMapper.selectByExample(example);
		
		List<OrderDayRec> dList = new ArrayList<OrderDayRec>();
		int purchaseDayRecNum =0;
		//计算全部采购订单日记录
		if(pList!=null&&pList.size()>0){
			Date d = pList.get(0).getTime();
			OrderDayRec dayRec = createOrderDayRecord(Integer.parseInt(MyDataFormatUtil.getYear(d)),
					Integer.parseInt(MyDataFormatUtil.getMonth(d)), 
					Integer.parseInt(MyDataFormatUtil.getDay(d)),"CG");
			if(dayRec!=null)dList.add(dayRec);
			for(int i=0;i<pList.size();i++){
				Date dtemp = pList.get(i).getTime();
				//若日期相同则不重复计算
				if(!MyDataFormatUtil.DateToStrYMD(d).equals(MyDataFormatUtil.DateToStrYMD(dtemp))){
					d = dtemp;
					dayRec = createOrderDayRecord(Integer.parseInt(MyDataFormatUtil.getYear(d)),
							Integer.parseInt(MyDataFormatUtil.getMonth(d)), 
							Integer.parseInt(MyDataFormatUtil.getDay(d)),"CG");
					if(dayRec!=null)dList.add(dayRec);
				}
			}
			purchaseDayRecNum = dList.size();
		}
		
		//获取全部已付款批发订单
		WholesaleOrderExample example2 = new WholesaleOrderExample();
		WholesaleOrderExample.Criteria criteria2 = example2.createCriteria();
		example2.setOrderByClause("time");
		criteria2.andOrderStateEqualTo(BaseConstrant.WHOLESALE_ORDER_STATE_PAID);
		List<WholesaleOrder> wList = wOrderMapper.selectByExample(example2);
		if(wList!=null &&wList.size()>0){
			//计算全部批发订单日记录
			Date d = wList.get(0).getTime();
			OrderDayRec dayRec = createOrderDayRecord(Integer.parseInt(MyDataFormatUtil.getYear(d)),
					Integer.parseInt(MyDataFormatUtil.getMonth(d)), 
					Integer.parseInt(MyDataFormatUtil.getDay(d)),"PF");
			if(dayRec!=null)dList.add(dayRec);
			for(int i=0;i<wList.size();i++){
				Date dtemp = wList.get(i).getTime();
				if(!MyDataFormatUtil.DateToStrYMD(d).equals(MyDataFormatUtil.DateToStrYMD(dtemp))){
					d = dtemp;
					dayRec = createOrderDayRecord(Integer.parseInt(MyDataFormatUtil.getYear(d)),
							Integer.parseInt(MyDataFormatUtil.getMonth(d)), 
							Integer.parseInt(MyDataFormatUtil.getDay(d)),"PF");
					if(dayRec!=null)dList.add(dayRec);
				}
			}
		}
		
		//计算全部采购订单月记录
		int year = 0;
		int month = 0;
		List<OrderMonRec> mList = new ArrayList<OrderMonRec>();
		int i=0;
		if(dList.size()>=purchaseDayRecNum){
			for(;i<purchaseDayRecNum;i++){
				int tYear = Integer.parseInt(dList.get(i).getYear());
				int tMonth = Integer.parseInt(dList.get(i).getMonth());
				if(year != tYear || month != tMonth){
					year = tYear;
					month = tMonth;
					OrderMonRec monRec = createOrderMonRecord(year, month, 'C');
					if(monRec!=null)mList.add(monRec);
				}
			}
		}
		int purchaseMonRecNum = mList.size();
		//计算全部批发订单月记录
		year = 0;
		month = 0;
		if(dList.size()>=purchaseDayRecNum){
			for(;i<dList.size();i++){
				int tYear = Integer.parseInt(dList.get(i).getYear());
				int tMonth = Integer.parseInt(dList.get(i).getMonth());
				if(year != tYear || month != tMonth){
					year = tYear;
					month = tMonth;
					OrderMonRec monRec = createOrderMonRecord(year, month, 'P');
					if(monRec!=null)mList.add(monRec);
				}
			}
		}
		
		//计算全部采购订单年记录
		year = 0;
		List<OrderYearRec> yList = new ArrayList<OrderYearRec>();
		i=0;
		if(mList.size()>=purchaseMonRecNum){
			for(;i<purchaseMonRecNum;i++){
				int tYear = Integer.parseInt(mList.get(i).getYear());
				if(year != tYear){
					year = tYear;
					OrderYearRec yearRec = createOrderYearRecord(year, 'C');
					if(yearRec!=null)yList.add(yearRec);
				}
			}
		}
		//计算全部批发订单年记录
		year = 0;
		if(mList.size()>=purchaseMonRecNum){
			for(;i<mList.size();i++){
				int tYear = Integer.parseInt(mList.get(i).getYear());
				if(year != tYear ){
					year = tYear;
					OrderYearRec yearRec = createOrderYearRecord(year, 'P');
					if(yearRec!=null)yList.add(yearRec);
				}
			}
		}
		
		return yList;
	}

	@Override
	public Object listByCondition(Map<String, Object> args) {
		ValidateUtils.ValidatePageInfo(args);
		PageHelper.startPage((Integer)args.get(DefaultPageInfoName.PAGE_NAME.toString()), 
							(Integer)args.get(DefaultPageInfoName.SIZE_NAME.toString()));
		PageInfo<Map<String, Object>> pageInfo = null;
		if(args.containsKey("month")){
			List<Map<String,Object>> lists = ordDayRecMapper.listByCondition(args);
			pageInfo = new PageInfo<>(lists);
		}else if(args.containsKey("year")){
			List<Map<String,Object>> lists = ordMonRecMapper.listByCondition(args);
			pageInfo = new PageInfo<>(lists);
		}else{
			List<Map<String,Object>> lists = ordYearRecMapper.listByCondition(args);
			pageInfo = new PageInfo<>(lists);
		}
			
		return pageInfo;
	}

	@Override
	public Object listYearByCondition(Map<String, Object> args) {
		ValidateUtils.ValidatePageInfo(args);
		PageHelper.startPage((Integer)args.get(DefaultPageInfoName.PAGE_NAME.toString()), 
							(Integer)args.get(DefaultPageInfoName.SIZE_NAME.toString()));
		PageInfo<Map<String, Object>> pageInfo = null;
		List<Map<String,Object>> lists = ordYearRecMapper.listByCondition(args);
		pageInfo = new PageInfo<>(lists);
		return pageInfo;
	}

	@Override
	public Object listMonthByCondition(Map<String, Object> args) {
		ValidateUtils.ValidatePageInfo(args);
		PageHelper.startPage((Integer)args.get(DefaultPageInfoName.PAGE_NAME.toString()), 
							(Integer)args.get(DefaultPageInfoName.SIZE_NAME.toString()));
		PageInfo<Map<String, Object>> pageInfo = null;
		List<Map<String,Object>> lists = ordMonRecMapper.listByCondition(args);
		pageInfo = new PageInfo<>(lists);
		return pageInfo;
	}

	@Override
	public Object listDayByCondition(Map<String, Object> args) {
		ValidateUtils.ValidatePageInfo(args);
		PageHelper.startPage((Integer)args.get(DefaultPageInfoName.PAGE_NAME.toString()), 
							(Integer)args.get(DefaultPageInfoName.SIZE_NAME.toString()));
		PageInfo<Map<String, Object>> pageInfo = null;
		List<Map<String,Object>> lists = ordDayRecMapper.listByCondition(args);
		pageInfo = new PageInfo<>(lists);
		return pageInfo;
	}

}
