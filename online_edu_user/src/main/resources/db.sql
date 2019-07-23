CREATE TABLE `uc_role` (
  `DR` tinyint(2) DEFAULT '1' COMMENT '是否删除 1:正常 -1:删除',
  `CREATE_DATE` datetime DEFAULT NULL COMMENT '创建时间',
  `CREATE_USER` varchar(128) DEFAULT NULL COMMENT '创建人',
  `UPDATE_DATE` datetime DEFAULT NULL COMMENT '修改时间',
  `UPDATE_USER` varchar(128) DEFAULT NULL COMMENT '修改人',
  `ID` char(36) NOT NULL COMMENT '主键',
  `NAME` varchar(50) DEFAULT NULL COMMENT '名称',
  `VALUE` varchar(50) DEFAULT NULL COMMENT '英文名称',
  `STATUS` tinyint(4) DEFAULT NULL COMMENT '状态 1:可用 -1:封存',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户中心-角色表';

CREATE TABLE `uc_user` (
  `DR` tinyint(2) DEFAULT '1' COMMENT '是否删除 1:正常 -1:删除',
  `CREATE_DATE` datetime DEFAULT NULL COMMENT '创建时间',
  `CREATE_USER` varchar(128) DEFAULT NULL COMMENT '创建人',
  `UPDATE_DATE` datetime DEFAULT NULL COMMENT '修改时间',
  `UPDATE_USER` varchar(128) DEFAULT NULL COMMENT '修改人',
  `ID` char(36) NOT NULL COMMENT '主键',
  `NAME` varchar(50) DEFAULT NULL COMMENT '用户名',
  `USERNAME` varchar(50) DEFAULT NULL COMMENT '登录名',
  `PASSWORD` varchar(68) DEFAULT NULL COMMENT '用户密码',
  `STATUS` tinyint(4) DEFAULT NULL COMMENT '当前状态 1:正常 -1:禁用',
  `SEX` tinyint(4) DEFAULT NULL COMMENT '性别 0:未知 1：男 2：女',
  `AGE` tinyint(4) DEFAULT NULL COMMENT '年龄 ',
  `HEADER_PICTURE_URL` varchar(200) DEFAULT NULL COMMENT '头像地址',
  `TELEPHONE` varchar(20) DEFAULT NULL COMMENT '电话',
  PRIMARY KEY (`ID`),
  UNIQUE KEY `AK_Key_2` (`USERNAME`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户中心-用户表';

CREATE TABLE `uc_user_and_role` (
  `DR` tinyint(2) DEFAULT '1' COMMENT '是否删除 1:正常 -1:删除',
  `CREATE_DATE` datetime DEFAULT NULL COMMENT '创建时间',
  `CREATE_USER` varchar(128) DEFAULT NULL COMMENT '创建人',
  `UPDATE_DATE` datetime DEFAULT NULL COMMENT '修改时间',
  `UPDATE_USER` varchar(128) DEFAULT NULL COMMENT '修改人',
  `ID` char(36) NOT NULL COMMENT '主键',
  `USER_ID` char(36) DEFAULT NULL COMMENT '用户主键',
  `ROLE_ID` char(36) DEFAULT NULL COMMENT '角色主键',
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='用户中心--用户关联角色';
