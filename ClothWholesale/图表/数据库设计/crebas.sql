/*==============================================================*/
/* DBMS name:      MySQL 5.0                                    */
/* Created on:     2019/4/21 17:10:00                           */
/*==============================================================*/

drop database if EXISTS clothwholesale;
create database clothwholesale;
use clothwholesale;


drop table if exists wholesaleReturnRec;

drop table if exists wholesaleExchangeRec;

drop table if exists wholesaleCancelRec;

drop table if exists wholeSaleItem;

drop table if exists warehouseIORecord;

drop table if exists sellPrice;

drop table if exists saleDayRec;

drop table if exists purchaseItem;

drop table if exists purchaseOrder;

drop table if exists supplier;

drop table if exists productProperty;

drop table if exists picture;

drop table if exists permission;

drop table if exists orderYearRec;

drop table if exists orderMonRec;

drop table if exists orderDayRec;

drop table if exists menu;

drop table if exists listItem;

drop table if exists inventoryContent;

drop table if exists productModel;

drop table if exists product;

drop table if exists warehouse;

drop table if exists cusMonIORec;

drop table if exists wholesaleOrder;

drop table if exists shippingAddress;

drop table if exists customer;

drop table if exists comMonIORecord;

drop table if exists city;

drop table if exists province;

drop table if exists admin;

/*==============================================================*/
/* Table: admin                                                 */
/*==============================================================*/
create table admin
(
   adminCode            char(5) not null comment '前两位字符为类型，后3位为数字',
   adminName            varchar(10) not null,
   mobile               varchar(15) not null,
   email                varchar(30) not null,
   password             varchar(32) not null comment '由大小写字母数字及标点组成',
   adminType            char(2) not null comment 'GJ：高级管理员CK：仓库管理员CG：采购管理员PF：批发管理员XT：系统自动',
   state                char not null default 'T' comment 'T：启用F：不启用',
   primary key (adminCode)
);

/*==============================================================*/
/* Table: province                                              */
/*==============================================================*/
create table province
(
   provinceNum          integer not null,
   province             varchar(10) not null,
   primary key (provinceNum)
);

/*==============================================================*/
/* Table: city                                                  */
/*==============================================================*/
create table city
(
   cityNum              int not null,
   provinceNum          integer not null,
   city                 varchar(20) not null,
   primary key (cityNum),
   constraint FK_province_city foreign key (provinceNum)
      references province (provinceNum) on delete restrict on update restrict
);

/*==============================================================*/
/* Table: comMonIORecord                                        */
/*==============================================================*/
create table comMonIORecord
(
   comIORecCode         char(19) not null comment 'C（采购）/P（批发）+I（收款）/O（付款）+yyyyMMddhhmmss+SSS',
   adminCode            char(5) not null comment '处理该项款项的管理员',
   reason               char(2) not null comment 'CG：采购PF：批发QX：批发订单取消TH：退货QT：其他（需在备注中注明）',
   IOmark               char not null comment 'I：收款O：付款',
   time                 timestamp not null,
   amount               double not null comment '收款为正，付款为负',
   ordCode              char(19) comment '与该项流水相关的订单编号，若流水与订单无关可为空',
   remark               varchar(100),
   primary key (comIORecCode),
   constraint FK_admin_comMonIORec foreign key (adminCode)
      references admin (adminCode) on delete restrict on update restrict
);

/*==============================================================*/
/* Table: customer                                              */
/*==============================================================*/
create table customer
(
   username             varchar(15) not null,
   customerName         varchar(10) not null,
   password             varchar(32) not null comment '由大小写字母数字及标点组成',
   customerCompany      varchar(50),
   mobile               varchar(15) not null,
   email                varchar(30) not null,
   contactAddr          varchar(100) not null,
   postcode             char(6) not null,
   phone                varchar(16),
   fax                  varchar(16),
   primary key (username)
);

/*==============================================================*/
/* Table: shippingAddress                                       */
/*==============================================================*/
create table shippingAddress
(
   shippingAddrNum      bigint not null auto_increment comment '自增',
   username             varchar(15) not null,
   shippingAddr         varchar(100) not null,
   postcode             char(6) not null,
   contactName          varchar(10) not null,
   mobile               varchar(15) not null,
   email                varchar(30),
   primary key (shippingAddrNum),
   constraint FK_customer_shippingAddr foreign key (username)
      references customer (username) on delete restrict on update restrict
);

/*==============================================================*/
/* Table: wholesaleOrder                                        */
/*==============================================================*/
create table wholesaleOrder
(
   wholesaleOrdCode     char(19) not null comment 'PF（批发）+yyyyMMddhhmmss+SSS',
   shippingAddrNum      bigint not null,
   username             varchar(15) not null,
   orderState           char(2) not null default 'WF' comment 'WF：未付款YF：已付款QX：已取消FH：已发货TH：退货HH：换货',
   shippingCode         varchar(20),
   sumPrice             double not null,
   time                 timestamp not null,
   remark               varchar(100),
   orderRate            char,
   orderComment         varchar(200),
   primary key (wholesaleOrdCode),
   constraint FK_cusAddr_saleOrd foreign key (shippingAddrNum)
      references shippingAddress (shippingAddrNum) on delete restrict on update restrict,
   constraint FK_customer_saleOrder foreign key (username)
      references customer (username) on delete restrict on update restrict
);

/*==============================================================*/
/* Table: cusMonIORec                                           */
/*==============================================================*/
create table cusMonIORec
(
   cusMonIORecCode      char(19) not null comment 'K（客户）+I（收款）/O（付款）+yyyyMMddhhmmss+SSS',
   wholesaleOrdCode     char(19) not null,
   username             varchar(15) not null,
   reason               char(2) not null comment 'PF：批发QX：取消订单TH：退货QT：其他',
   IOmark               char not null comment 'I：收款O：付款',
   time                 timestamp not null,
   money                double not null,
   remark               varchar(100),
   primary key (cusMonIORecCode),
   constraint FK_wholesaleOrd_cusMonIORec foreign key (wholesaleOrdCode)
      references wholesaleOrder (wholesaleOrdCode) on delete restrict on update restrict,
   constraint FK_customer_cusMonIORec foreign key (username)
      references customer (username) on delete restrict on update restrict
);

/*==============================================================*/
/* Table: warehouse                                             */
/*==============================================================*/
create table warehouse
(
   warehouseCode        char(4) not null,
   capacity             integer not null comment '单位为米（布料长度）',
   state                char not null default 'T' comment 'T：启用F：不启用',
   inventory            integer not null default 0 comment '单位为米（布料长度）',
   primary key (warehouseCode)
);

/*==============================================================*/
/* Table: product                                               */
/*==============================================================*/
create table product
(
   productCode          char(10) not null comment '前5位为供应商编号，后五位为产品数字编号',
   productName          varchar(100) not null comment '初始时与货源名称相同，上架之前一般需进行修改',
   originalName         varchar(50) not null comment '供应商对产品的叫法，可与正式名称不同',
   originalPrice        double not null comment '每米布料的价格',
   typeTotal            smallint not null comment '该产品的型号数，一般为颜色种类数',
   width                integer not null comment '单位为厘米',
   weight               integer not null comment '单位为克每平方米',
   thickness            varchar(10),
   composition          varchar(10),
   ingredient           varchar(30),
   density              varchar(10),
   textileProcess       varchar(10),
   dyeProcess           varchar(10),
   fiberOrganization    varchar(10),
   pattern              varchar(20),
   mainUse              varchar(30),
   season               varchar(5),
   shippingFee          float,
   intro                varchar(50),
   state                char not null default 'F' comment 'T：上架F：下架',
   primary key (productCode)
);

/*==============================================================*/
/* Table: productModel                                          */
/*==============================================================*/
create table productModel
(
   modelCode            char(13) not null comment '产品编号-XXX（XXX为序号，每个产品从001开始计数，000用于表示通用信息）',
   productCode          char(10) not null,
   modelName            varchar(15) not null,
   totalNum             integer not null default 0,
   primary key (modelCode),
   constraint FK_product_model foreign key (productCode)
      references product (productCode) on delete restrict on update restrict
);

alter table productModel comment '同一产品的不同型号，如不同颜色';

/*==============================================================*/
/* Table: inventoryContent                                      */
/*==============================================================*/
create table inventoryContent
(
   inventoryContInd     bigint not null auto_increment comment '自增',
   warehouseCode        char(4) not null,
   modelCode            char(13) not null,
   ContentSum           integer not null comment '单位为米（布料长度）',
   primary key (inventoryContInd),
   constraint FK_warehouse_content foreign key (warehouseCode)
      references warehouse (warehouseCode) on delete restrict on update restrict,
   constraint FK_model_inventoryCont foreign key (modelCode)
      references productModel (modelCode) on delete restrict on update restrict
);

/*==============================================================*/
/* Table: listItem                                              */
/*==============================================================*/
create table listItem
(
   listItemCode         varchar(17) not null comment '客户用户名+XX（XX为序号，每个进货单从1开始）',
   modelCode            char(13) not null,
   username             varchar(15),
   totalNum             integer,
   primary key (listItemCode),
   constraint FK_customer_listItem foreign key (username)
      references customer (username) on delete restrict on update restrict,
   constraint FK_model_listItem foreign key (modelCode)
      references productModel (modelCode) on delete restrict on update restrict
);

/*==============================================================*/
/* Table: menu                                                  */
/*==============================================================*/
create table menu
(
   menuNum              int not null auto_increment comment '自增序列',
   Amenu                varchar(20) not null,
   Bmenu                varchar(20) not null,
   state                char not null default 'T' comment 'T：启用F：不启用',
   primary key (menuNum)
);

/*==============================================================*/
/* Table: orderDayRec                                           */
/*==============================================================*/
create table orderDayRec
(
   ordDayRecCode        char(10) not null comment 'C（采购）D（日记录）+yyyyMMdd',
   year                 char(4) not null,
   month                char(2) not null,
   day                  char(2) not null,
   orderNum             integer not null,
   moneyNum             double not null,
   primary key (ordDayRecCode)
);

/*==============================================================*/
/* Table: orderMonRec                                           */
/*==============================================================*/
create table orderMonRec
(
   OrdMonRecCode        char(8) not null comment 'C（采购）/P（批发）+M（月记录）+yyyyMM',
   year                 char(4) not null,
   month                char(2) not null,
   orderNum             integer not null,
   moneyNum             double not null,
   primary key (OrdMonRecCode)
);

/*==============================================================*/
/* Table: orderYearRec                                          */
/*==============================================================*/
create table orderYearRec
(
   ordYearRecCode       char(6) not null comment 'C（采购）/P（批发）+Y（年记录）+yyyy',
   year                 char(4) not null,
   orderNum             integer not null,
   moneyNum             double not null,
   primary key (ordYearRecCode)
);

/*==============================================================*/
/* Table: permission                                            */
/*==============================================================*/
create table permission
(
   permissionNum        integer not null auto_increment comment '自增序列',
   menuNum              int not null,
   role                 char(2) not null comment 'GJ：高级管理员CK：仓库管理员CG：采购管理员PF：批发管理员',
   primary key (permissionNum),
   constraint FK_menu_permission foreign key (menuNum)
      references menu (menuNum) on delete restrict on update restrict
);

/*==============================================================*/
/* Table: picture                                               */
/*==============================================================*/
create table picture
(
   filename             varchar(25) not null comment '产品编码-产品型号序号-图片序号',
   pictureIndex         smallint not null comment '每个产品型号从1开始',
   modelCode            char(13) not null,
   primary key (filename),
   constraint FK_model_picture foreign key (modelCode)
      references productModel (modelCode) on delete restrict on update restrict
);

/*==============================================================*/
/* Table: productProperty                                       */
/*==============================================================*/
create table productProperty
(
   productPropNum       bigint not null auto_increment comment '自增序列',
   productPropType      varchar(10) not null comment '产品该属性所属的类别，如纺织工艺、染整工艺',
   productProp          varchar(10) not null comment '产品的具体属性，如针织（纺织工艺的一种）',
   primary key (productPropNum)
);

alter table productProperty comment '产品的各种属性，该表中提供存储的属性类型有成分、纺织工艺、染整工艺、织物组织、图案及主要用途，这些属性类型均为产品表中的';

/*==============================================================*/
/* Table: supplier                                              */
/*==============================================================*/
create table supplier
(
   supplierCode         char(5) not null comment '前3位为供应商名称缩写，最后2位为缩写雷同时的区分数字数字，从01开始',
   supplierName         varchar(50) not null,
   contactName          varchar(10) not null,
   mobile               varchar(15) not null,
   email                varchar(30) not null,
   contactAddr          varchar(100) not null,
   postcode             char(6) not null,
   phone                varchar(16),
   fax                  varchar(16),
   remark               varchar(200),
   primary key (supplierCode)
);

alter table supplier comment '布料产品供应商，批发公司从供应商处采购';

/*==============================================================*/
/* Table: purchaseOrder                                         */
/*==============================================================*/
create table purchaseOrder
(
   purchaseOrdCode      char(19) not null comment 'CG（采购）+yyyyMMddhhmmss+SSS',
   supplierCode         char(5) not null,
   adminCode            char(5) not null,
   time                 timestamp not null,
   sumPrice             double not null comment '所有订单项的总金额',
   paidPrice            double not null default 0,
   remark               varchar(100),
   primary key (purchaseOrdCode),
   constraint FK_customer_purchaseOrd foreign key (supplierCode)
      references supplier (supplierCode) on delete restrict on update restrict,
   constraint FK_admin_purchaseOrd foreign key (adminCode)
      references admin (adminCode) on delete restrict on update restrict
);

alter table purchaseOrder comment '批发公司从供应商处采购布料的订单记录，订单状态有';

/*==============================================================*/
/* Table: purchaseItem                                          */
/*==============================================================*/
create table purchaseItem
(
   purchaseItemCode     char(21) not null comment '采购订单编号+XX（XX为序号，从1开始）',
   purchaseOrdCode      char(19) not null,
   modelCode            char(13) not null,
   totalNum             integer not null,
   orignalPrice         float not null,
   totalPrice           double not null comment '该订单项的总金额',
   state                char(2) not null default 'DF' comment 'DF：待付款YF：已付款DR：待入库YR：已入库',
   primary key (purchaseItemCode),
   constraint FK_model_purchaseItem foreign key (modelCode)
      references productModel (modelCode) on delete restrict on update restrict,
   constraint FK_purchaseOrd_purchaseItem foreign key (purchaseOrdCode)
      references purchaseOrder (purchaseOrdCode) on delete restrict on update restrict
);

/*==============================================================*/
/* Table: sellPrice                                             */
/*==============================================================*/
create table sellPrice
(
   sellPriceCode        char(11) not null comment '产品编码-X（X为序号，每个产品从1开始）',
   productCode          char(10) not null,
   lowerLimit           integer not null,
   price                float not null,
   primary key (sellPriceCode),
   constraint FK_product_price foreign key (productCode)
      references product (productCode) on delete restrict on update restrict
);

alter table sellPrice comment '记录同一产品在不同数量段的不同价格';

/*==============================================================*/
/* Table: warehouseIORecord                                     */
/*==============================================================*/
create table warehouseIORecord
(
   warehouseIORecCode   char(19) not null comment 'CK（出库）/RK（入库）yyyyMMddhhmmss+SSS',
   warehouseCode        char(4) not null,
   modelCode            char(13) not null,
   adminCode            char(5) not null,
   numberChange         integer not null,
   reason               char(2) not null comment 'CG：采购PF：批发TH：退货HH：换货QT：其他（在备注中注明）',
   IOMark               char not null comment 'I：入库O：出库',
   time                 timestamp not null,
   ordCode              char(19) comment '与该项流水相关的订单编号，若流水与订单无关可为空',
   remark               varchar(100),
   primary key (warehouseIORecCode),
   constraint FK_warehouse_IORecord foreign key (warehouseCode)
      references warehouse (warehouseCode) on delete restrict on update restrict,
   constraint FK_Model_IORecord foreign key (modelCode)
      references productModel (modelCode) on delete restrict on update restrict,
   constraint FK_admin_warehouseIORec foreign key (adminCode)
      references admin (adminCode) on delete restrict on update restrict
);

/*==============================================================*/
/* Table: wholeSaleItem                                         */
/*==============================================================*/
create table wholeSaleItem
(
   wholesaleItemCode    char(21) not null comment '批发订单编号-XX（XX为序号，每个订单从1开始）',
   wholesaleOrdCode     char(19) not null,
   modelCode            char(13) not null,
   totalNum             integer not null,
   price                float not null,
   totalPrice           double not null,
   state                char(2) not null default 'ZC' comment 'ZC：正常FH：已发货TH：退货HH：换货',
   primary key (wholesaleItemCode),
   constraint FK_model_wholesaleItem foreign key (modelCode)
      references productModel (modelCode) on delete restrict on update restrict,
   constraint FK_wholesaleOrd_wholesaleItem foreign key (wholesaleOrdCode)
      references wholesaleOrder (wholesaleOrdCode) on delete restrict on update restrict
);

/*==============================================================*/
/* Table: wholesaleCancelRec                                    */
/*==============================================================*/
create table wholesaleCancelRec
(
   cancelRecNum         bigint not null auto_increment comment '自增序列',
   adminCode            char(5),
   wholesaleOrdCode     char(19) not null,
   reason               varchar(100) not null,
   recordState          char(2) not null default 'DQ' comment 'DQ：待确认YQ：已确认JJ：已拒绝QX：已取消',
   moneyState           char not null default 'F' comment 'T：已退款F：未退款',
   remark               varchar(100),
   primary key (cancelRecNum),
   constraint FK_admin_cancelRec foreign key (adminCode)
      references admin (adminCode) on delete restrict on update restrict,
   constraint FK_wholesaleOrd_cancelRec foreign key (wholesaleOrdCode)
      references wholesaleOrder (wholesaleOrdCode) on delete restrict on update restrict
);

/*==============================================================*/
/* Table: wholesaleExchangeRec                                  */
/*==============================================================*/
create table wholesaleExchangeRec
(
   exchangeRecNum       bigint not null auto_increment comment '自增序列',
   adminCode            char(5) not null,
   wholesaleItemCode    char(21) not null,
   exchangeNum          integer not null,
   reason               varchar(100) not null,
   backShipCode         varchar(20),
   resendShipCode       varchar(20),
   recordState          char(2) not null default 'DQ' comment 'DQ：待确认YQ：已确认JJ：已拒绝QX：已取消',
   state                char not null default 'W' comment 'W：未退还B：已退还S：已重发',
   remark               varchar(100),
   primary key (exchangeRecNum),
   constraint FK_admin_exchangeRec foreign key (adminCode)
      references admin (adminCode) on delete restrict on update restrict,
   constraint FK_listItem_exchangeRec foreign key (wholesaleItemCode)
      references wholeSaleItem (wholesaleItemCode) on delete restrict on update restrict
);

/*==============================================================*/
/* Table: wholesaleReturnRec                                    */
/*==============================================================*/
create table wholesaleReturnRec
(
   returnRecNum         bigint not null auto_increment comment '自增序列',
   adminCode            char(5) not null,
   wholesaleItemCode    char(21) not null,
   returnNum            integer not null,
   reason               varchar(100) not null,
   shippingCode         varchar(20),
   recordState          char(2) not null default 'DQ' comment 'DQ：待确认YQ：已确认JJ：已拒绝QX：已取消',
   productState         char not null default 'F' comment 'T：已返还F：未返还',
   moneystate           char not null default 'F' comment 'T：已退款F：未退款',
   remark               varchar(100),
   primary key (returnRecNum),
   constraint FK_admin_returnRec foreign key (adminCode)
      references admin (adminCode) on delete restrict on update restrict,
   constraint FK_wholesaleOrd_returnRec foreign key (wholesaleItemCode)
      references wholeSaleItem (wholesaleItemCode) on delete restrict on update restrict
);