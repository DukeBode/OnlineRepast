-- source init.sql

/*==============================================================*/
/* Database: online                                                 */
/*==============================================================*/
drop database if exists online;
create database online;
use online;

/*==============================================================*/
/* Table: user                                                  */
/*==============================================================*/
create table Tuser
(
   userid               varchar(20) not null,
   name                 varchar(50),
   pwd                  varchar(20),
   mail                 varchar(50),
   phone                varchar(20),
   address              varchar(20),
   date                 date,
   status               tinyint,
   level                int,
   role                 tinyint,
   primary key (userid)
);

/*==============================================================*/
/* Table: shop                                                  */
/*==============================================================*/
create table Tshop
(
   shopid               int not null auto_increment,
   userid               varchar(20),
   name                 varchar(20),
   keeper               varchar(20),
   phone                varchar(20),
   address              varchar(20),
   date                 date,
   status               tinyint,
   primary key (shopid)
);

/*==============================================================*/
/* Table: Category                                              */
/*==============================================================*/
create table TCategory
(
   categoryid           int not null auto_increment,
   shopid               int,
   type                 varchar(50),
   primary key (categoryid)
);

/*==============================================================*/
/* Table: Repast                                                */
/*==============================================================*/
create table TRepast
(
   repastid             int not null auto_increment,
   categoryid           int,
   shopid               int,
   name                 varchar(50),
   pic                  varchar(100),
   info                 varchar(200),
   price                decimal(10,2),
   unit                 varchar(10),
   time                 timestamp,
   status               tinyint,
   primary key (repastid)
);

/*==============================================================*/
/* Table: Delivery                                              */
/*==============================================================*/
create table TDelivery
(
   deliveryid           varchar(20) not null,
   delivery             varchar(20),
   datetime             datetime,
   time                 time,
   inquiry              varchar(20),
   staff                varchar(20),
   primary key (deliveryid)
);

/*==============================================================*/
/* Table: "order"                                               */
/*==============================================================*/
create table torder
(
   orderid              varchar(50) not null,
   userid               varchar(20),
   deliveryid           varchar(20),
   bugtime              datetime,
   address              varchar(20),
   contact              varchar(20),
   time                 datetime,
   number               int,
   allpay               decimal(10,2),
   pay                  tinyint,
   paycode              varchar(20),
   other                varchar(20),
   status               tinyint,
   primary key (orderid)
);

/*==============================================================*/
/* Table: Record                                                */
/*==============================================================*/
create table tRecord
(
   repastid             int not null,
   orderid              varchar(50) not null,
   number               int unsigned,
   piece                double,
   primary key (repastid, orderid)
);

\! cls
show tables;
