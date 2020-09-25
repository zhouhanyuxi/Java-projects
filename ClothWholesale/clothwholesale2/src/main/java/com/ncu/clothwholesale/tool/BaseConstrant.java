package com.ncu.clothwholesale.tool;


public class BaseConstrant {
	//采购产品状态
	public static final String PURCHASE_PRODUCT_STATE_NORMAL = "ZC";//正常
	public static final String PURCHASE_PRODUCT_STATE_WAIT = "DR";//待入库
	public static final String PURCHASE_PRODUCT_STATE_FINISH = "YR";//已入库
	//采购订单项状态
	public static final String PURCHASE_ITEM_STATE_PAYING = "DF";//待付款
	public static final String PURCHASE_ITEM_STATE_PAID = "YF";//已付款
	public static final String PURCHASE_ITEM_STATE_STORING = "DR";//待入库
	public static final String PURCHASE_ITEM_STATE_STORED = "YR";//已入库
	//批发订单状态
	public static final String WHOLESALE_ORDER_STATE_PAYING = "DF";//待付款
	public static final String WHOLESALE_ORDER_STATE_PAID = "YF";//已付款
	public static final String WHOLESALE_ORDER_STATE_CANCEL = "QX";//已取消
	public static final String WHOLESALE_ORDER_STATE_SHIPPING = "DC";//待出库
	public static final String WHOLESALE_ORDER_STATE_SHIPPED = "YC";//已出库
	//批发订单项状态
	public static final String WHOLESALE_ITEM_STATE_NORMAL = "ZC";//正常
	public static final String WHOLESALE_ITEM_STATE_SHIPPED = "FH";//已发货
	public static final String WHOLESALE_ITEM_STATE_EXCHANGE = "HH";//已换货
	public static final String WHOLESALE_ITEM_STATE_RETURN = "TH";//已退货
	//出入库变动原因
	public static final String WAREHOUSE_IO_REASON_PURCHASE = "CG";//采购
	public static final String WAREHOUSE_IO_REASON_WHOLESALE = "PF";//批发
	public static final String WAREHOUSE_IO_REASON_EXCHANGE = "HH";//换货
	public static final String WAREHOUSE_IO_REASON_RETURN = "TH";//退货
	//客户款项出入原因
	public static final String CUSTOMER_IO_REASON_WHOLESALE = "PF";//批发
	public static final String CUSTOMER_IO_REASON_CANCEL = "QX";//取消
	public static final String CUSTOMER_IO_REASON_RETURN = "TH";//退货
	public static final String CUSTOMER_IO_REASON_OTHER = "QT";//其他
	//批发商款项出入原因
	public static final String COMPANY_IO_REASON_PURCHASE = "CG";//采购
	public static final String COMPANY_IO_REASON_WHOLESALE = "PF";//批发
	public static final String COMPANY_IO_REASON_CANCEL = "QX";//取消
	public static final String COMPANY_IO_REASON_RETURN = "TH";//退货
	public static final String COMPANY_IO_REASON_OTHER = "QT";//其他
}
