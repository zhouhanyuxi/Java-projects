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
   adminCode            char(5) not null comment 'ǰ��λ�ַ�Ϊ���ͣ���3λΪ����',
   adminName            varchar(10) not null,
   mobile               varchar(15) not null,
   email                varchar(30) not null,
   password             varchar(32) not null comment '�ɴ�Сд��ĸ���ּ�������',
   adminType            char(2) not null comment 'GJ���߼�����ԱCK���ֿ����ԱCG���ɹ�����ԱPF����������ԱXT��ϵͳ�Զ�',
   state                char not null default 'T' comment 'T������F��������',
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
   comIORecCode         char(19) not null comment 'C���ɹ���/P��������+I���տ/O�����+yyyyMMddhhmmss+SSS',
   adminCode            char(5) not null comment '����������Ĺ���Ա',
   reason               char(2) not null comment 'CG���ɹ�PF������QX����������ȡ��TH���˻�QT�����������ڱ�ע��ע����',
   IOmark               char not null comment 'I���տ�O������',
   time                 timestamp not null,
   amount               double not null comment '�տ�Ϊ��������Ϊ��',
   ordCode              char(19) comment '�������ˮ��صĶ�����ţ�����ˮ�붩���޹ؿ�Ϊ��',
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
   password             varchar(32) not null comment '�ɴ�Сд��ĸ���ּ�������',
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
   shippingAddrNum      bigint not null auto_increment comment '����',
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
   wholesaleOrdCode     char(19) not null comment 'PF��������+yyyyMMddhhmmss+SSS',
   shippingAddrNum      bigint not null,
   username             varchar(15) not null,
   orderState           char(2) not null default 'WF' comment 'WF��δ����YF���Ѹ���QX����ȡ��FH���ѷ���TH���˻�HH������',
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
   cusMonIORecCode      char(19) not null comment 'K���ͻ���+I���տ/O�����+yyyyMMddhhmmss+SSS',
   wholesaleOrdCode     char(19) not null,
   username             varchar(15) not null,
   reason               char(2) not null comment 'PF������QX��ȡ������TH���˻�QT������',
   IOmark               char not null comment 'I���տ�O������',
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
   capacity             integer not null comment '��λΪ�ף����ϳ��ȣ�',
   state                char not null default 'T' comment 'T������F��������',
   inventory            integer not null default 0 comment '��λΪ�ף����ϳ��ȣ�',
   primary key (warehouseCode)
);

/*==============================================================*/
/* Table: product                                               */
/*==============================================================*/
create table product
(
   productCode          char(10) not null comment 'ǰ5λΪ��Ӧ�̱�ţ�����λΪ��Ʒ���ֱ��',
   productName          varchar(100) not null comment '��ʼʱ���Դ������ͬ���ϼ�֮ǰһ��������޸�',
   originalName         varchar(50) not null comment '��Ӧ�̶Բ�Ʒ�Ľз���������ʽ���Ʋ�ͬ',
   originalPrice        double not null comment 'ÿ�ײ��ϵļ۸�',
   typeTotal            smallint not null comment '�ò�Ʒ���ͺ�����һ��Ϊ��ɫ������',
   width                integer not null comment '��λΪ����',
   weight               integer not null comment '��λΪ��ÿƽ����',
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
   state                char not null default 'F' comment 'T���ϼ�F���¼�',
   primary key (productCode)
);

/*==============================================================*/
/* Table: productModel                                          */
/*==============================================================*/
create table productModel
(
   modelCode            char(13) not null comment '��Ʒ���-XXX��XXXΪ��ţ�ÿ����Ʒ��001��ʼ������000���ڱ�ʾͨ����Ϣ��',
   productCode          char(10) not null,
   modelName            varchar(15) not null,
   totalNum             integer not null default 0,
   primary key (modelCode),
   constraint FK_product_model foreign key (productCode)
      references product (productCode) on delete restrict on update restrict
);

alter table productModel comment 'ͬһ��Ʒ�Ĳ�ͬ�ͺţ��粻ͬ��ɫ';

/*==============================================================*/
/* Table: inventoryContent                                      */
/*==============================================================*/
create table inventoryContent
(
   inventoryContInd     bigint not null auto_increment comment '����',
   warehouseCode        char(4) not null,
   modelCode            char(13) not null,
   ContentSum           integer not null comment '��λΪ�ף����ϳ��ȣ�',
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
   listItemCode         varchar(17) not null comment '�ͻ��û���+XX��XXΪ��ţ�ÿ����������1��ʼ��',
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
   menuNum              int not null auto_increment comment '��������',
   Amenu                varchar(20) not null,
   Bmenu                varchar(20) not null,
   state                char not null default 'T' comment 'T������F��������',
   primary key (menuNum)
);

/*==============================================================*/
/* Table: orderDayRec                                           */
/*==============================================================*/
create table orderDayRec
(
   ordDayRecCode        char(10) not null comment 'C���ɹ���D���ռ�¼��+yyyyMMdd',
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
   OrdMonRecCode        char(8) not null comment 'C���ɹ���/P��������+M���¼�¼��+yyyyMM',
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
   ordYearRecCode       char(6) not null comment 'C���ɹ���/P��������+Y�����¼��+yyyy',
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
   permissionNum        integer not null auto_increment comment '��������',
   menuNum              int not null,
   role                 char(2) not null comment 'GJ���߼�����ԱCK���ֿ����ԱCG���ɹ�����ԱPF����������Ա',
   primary key (permissionNum),
   constraint FK_menu_permission foreign key (menuNum)
      references menu (menuNum) on delete restrict on update restrict
);

/*==============================================================*/
/* Table: picture                                               */
/*==============================================================*/
create table picture
(
   filename             varchar(25) not null comment '��Ʒ����-��Ʒ�ͺ����-ͼƬ���',
   pictureIndex         smallint not null comment 'ÿ����Ʒ�ͺŴ�1��ʼ',
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
   productPropNum       bigint not null auto_increment comment '��������',
   productPropType      varchar(10) not null comment '��Ʒ������������������֯���ա�Ⱦ������',
   productProp          varchar(10) not null comment '��Ʒ�ľ������ԣ�����֯����֯���յ�һ�֣�',
   primary key (productPropNum)
);

alter table productProperty comment '��Ʒ�ĸ������ԣ��ñ����ṩ�洢�����������гɷ֡���֯���ա�Ⱦ�����ա�֯����֯��ͼ������Ҫ��;����Щ�������;�Ϊ��Ʒ���е�';

/*==============================================================*/
/* Table: supplier                                              */
/*==============================================================*/
create table supplier
(
   supplierCode         char(5) not null comment 'ǰ3λΪ��Ӧ��������д�����2λΪ��д��ͬʱ�������������֣���01��ʼ',
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

alter table supplier comment '���ϲ�Ʒ��Ӧ�̣�������˾�ӹ�Ӧ�̴��ɹ�';

/*==============================================================*/
/* Table: purchaseOrder                                         */
/*==============================================================*/
create table purchaseOrder
(
   purchaseOrdCode      char(19) not null comment 'CG���ɹ���+yyyyMMddhhmmss+SSS',
   supplierCode         char(5) not null,
   adminCode            char(5) not null,
   time                 timestamp not null,
   sumPrice             double not null comment '���ж�������ܽ��',
   paidPrice            double not null default 0,
   remark               varchar(100),
   primary key (purchaseOrdCode),
   constraint FK_customer_purchaseOrd foreign key (supplierCode)
      references supplier (supplierCode) on delete restrict on update restrict,
   constraint FK_admin_purchaseOrd foreign key (adminCode)
      references admin (adminCode) on delete restrict on update restrict
);

alter table purchaseOrder comment '������˾�ӹ�Ӧ�̴��ɹ����ϵĶ�����¼������״̬��';

/*==============================================================*/
/* Table: purchaseItem                                          */
/*==============================================================*/
create table purchaseItem
(
   purchaseItemCode     char(21) not null comment '�ɹ��������+XX��XXΪ��ţ���1��ʼ��',
   purchaseOrdCode      char(19) not null,
   modelCode            char(13) not null,
   totalNum             integer not null,
   orignalPrice         float not null,
   totalPrice           double not null comment '�ö�������ܽ��',
   state                char(2) not null default 'DF' comment 'DF��������YF���Ѹ���DR�������YR�������',
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
   sellPriceCode        char(11) not null comment '��Ʒ����-X��XΪ��ţ�ÿ����Ʒ��1��ʼ��',
   productCode          char(10) not null,
   lowerLimit           integer not null,
   price                float not null,
   primary key (sellPriceCode),
   constraint FK_product_price foreign key (productCode)
      references product (productCode) on delete restrict on update restrict
);

alter table sellPrice comment '��¼ͬһ��Ʒ�ڲ�ͬ�����εĲ�ͬ�۸�';

/*==============================================================*/
/* Table: warehouseIORecord                                     */
/*==============================================================*/
create table warehouseIORecord
(
   warehouseIORecCode   char(19) not null comment 'CK�����⣩/RK����⣩yyyyMMddhhmmss+SSS',
   warehouseCode        char(4) not null,
   modelCode            char(13) not null,
   adminCode            char(5) not null,
   numberChange         integer not null,
   reason               char(2) not null comment 'CG���ɹ�PF������TH���˻�HH������QT���������ڱ�ע��ע����',
   IOMark               char not null comment 'I�����O������',
   time                 timestamp not null,
   ordCode              char(19) comment '�������ˮ��صĶ�����ţ�����ˮ�붩���޹ؿ�Ϊ��',
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
   wholesaleItemCode    char(21) not null comment '�����������-XX��XXΪ��ţ�ÿ��������1��ʼ��',
   wholesaleOrdCode     char(19) not null,
   modelCode            char(13) not null,
   totalNum             integer not null,
   price                float not null,
   totalPrice           double not null,
   state                char(2) not null default 'ZC' comment 'ZC������FH���ѷ���TH���˻�HH������',
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
   cancelRecNum         bigint not null auto_increment comment '��������',
   adminCode            char(5),
   wholesaleOrdCode     char(19) not null,
   reason               varchar(100) not null,
   recordState          char(2) not null default 'DQ' comment 'DQ����ȷ��YQ����ȷ��JJ���Ѿܾ�QX����ȡ��',
   moneyState           char not null default 'F' comment 'T�����˿�F��δ�˿�',
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
   exchangeRecNum       bigint not null auto_increment comment '��������',
   adminCode            char(5) not null,
   wholesaleItemCode    char(21) not null,
   exchangeNum          integer not null,
   reason               varchar(100) not null,
   backShipCode         varchar(20),
   resendShipCode       varchar(20),
   recordState          char(2) not null default 'DQ' comment 'DQ����ȷ��YQ����ȷ��JJ���Ѿܾ�QX����ȡ��',
   state                char not null default 'W' comment 'W��δ�˻�B�����˻�S�����ط�',
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
   returnRecNum         bigint not null auto_increment comment '��������',
   adminCode            char(5) not null,
   wholesaleItemCode    char(21) not null,
   returnNum            integer not null,
   reason               varchar(100) not null,
   shippingCode         varchar(20),
   recordState          char(2) not null default 'DQ' comment 'DQ����ȷ��YQ����ȷ��JJ���Ѿܾ�QX����ȡ��',
   productState         char not null default 'F' comment 'T���ѷ���F��δ����',
   moneystate           char not null default 'F' comment 'T�����˿�F��δ�˿�',
   remark               varchar(100),
   primary key (returnRecNum),
   constraint FK_admin_returnRec foreign key (adminCode)
      references admin (adminCode) on delete restrict on update restrict,
   constraint FK_wholesaleOrd_returnRec foreign key (wholesaleItemCode)
      references wholeSaleItem (wholesaleItemCode) on delete restrict on update restrict
);