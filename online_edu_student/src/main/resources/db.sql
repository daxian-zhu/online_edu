drop index user_id on student_info;

drop table if exists student_info;

/*==============================================================*/
/* Table: student_info                                          */
/*==============================================================*/
create table student_info
(
   DR  tinyint(2) NULL DEFAULT 1 COMMENT '是否删除 1:正常 -1:删除' ,
   CREATE_DATE  datetime NULL DEFAULT NULL COMMENT '创建时间' ,
   CREATE_USER  varchar(128) NULL DEFAULT NULL COMMENT '创建人' ,
   UPDATE_DATE datetime NULL DEFAULT NULL COMMENT '修改时间' ,
   UPDATE_USER  varchar(128) NULL DEFAULT NULL COMMENT '修改人' ,
   ID                   char(36) not null comment '主键',
   NAME                 varchar(20) comment '姓名',
   CONTACT_MOBILE       varchar(20) comment '联系电话',
   SEX                  tinyint comment '客户性别  1:男 0:女',
   AGE                  tinyint comment '客户年龄',
   NCEE_TIME            smallint comment '高考时间',
   PICTURE_URL          varchar(150) comment '头像地址',
   USER_ID              char(36) comment '关联用户',
   BIND_WEIXIN          tinyint comment '是否绑定微信  1:绑定 0:未绑定',
   CUSTOMER_ID          char(36) comment '关联客户ID',
   primary key (ID)
);

alter table student_info comment '学生--学生信息表';

/*==============================================================*/
/* Index: user_id                                               */
/*==============================================================*/
create index user_id on student_info
(
   USER_ID
);

/*==============================================================*/
/* Index: cutsomer_id                                           */
/*==============================================================*/
create index cutsomer_id on student_info
(
   CUSTOMER_ID
);
