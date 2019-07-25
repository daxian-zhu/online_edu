drop table if exists customer_info;

/*==============================================================*/
/* Table: customer_info                                         */
/*==============================================================*/
create table customer_info
(
   DR  tinyint(2) NULL DEFAULT 1 COMMENT '是否删除 1:正常 -1:删除' ,
   CREATE_DATE  datetime NULL DEFAULT NULL COMMENT '创建时间' ,
   CREATE_USER  varchar(128) NULL DEFAULT NULL COMMENT '创建人' ,
   UPDATE_DATE datetime NULL DEFAULT NULL COMMENT '修改时间' ,
   UPDATE_USER  varchar(128) NULL DEFAULT NULL COMMENT '修改人' ,
   ID                   char(36) not null comment '主键',
   NAME                 varchar(50) comment '姓名',
   CONTACT_MOBILE       varchar(20) comment '联系电话',
   SEX                  tinyint comment '客户性别  1:男 0:女',
   AGE                  tinyint comment '客户年龄',
   STATUS               tinyint comment '当前状态 0:待分配 1:TMK 持有 2：CC持有 3:TMK放弃 4：CC放弃',
   COMMENT              varchar(1000) comment '备注',
   primary key (ID)
);

alter table customer_info comment '客户--客户信息表';
