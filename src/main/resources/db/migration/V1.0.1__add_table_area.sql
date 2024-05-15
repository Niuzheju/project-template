create table `sys_user`
(
    `id`          bigint           not null auto_increment comment '用户ID',
    `username`    varchar(32)      not null comment '用户名',
    `nickname`    varchar(32)      not null comment '昵称',
    `mobile`      varchar(16) comment '手机号',
    `role`        tinyint unsigned not null comment '角色, 1:SUPER_ADMIN, 2: ADMIN',
    `password`    varchar(128) comment '密码',
    `is_enable`   boolean          not null default true comment '是否启用',
    `modify_time` datetime comment '更新时间',
    `create_time` datetime         not null comment '创建时间',
    primary key (`id`),
    UNIQUE INDEX `username_UNIQUE` (`username` ASC) VISIBLE,
    UNIQUE INDEX `mobile_UNIQUE` (`mobile` ASC) VISIBLE
) ENGINE = InnoDB
  DEFAULT CHARSET = `utf8mb4` comment '系统用户表';

CREATE TABLE `area`
(
    `id`          bigint                                                        NOT NULL AUTO_INCREMENT,
    `name`        varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
    `parent_id`   bigint                                                        NULL     DEFAULT NULL,
    `create_time` datetime                                                      NOT NULL DEFAULT CURRENT_TIMESTAMP,
    PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB
  DEFAULT CHARSET = `utf8mb4` comment '区域表';

CREATE TABLE `sys_role`
(
    `id`           bigint unsigned NOT NULL AUTO_INCREMENT COMMENT '自增ID',
    `role`         varchar(32)     NOT NULL COMMENT '角色',
    `role_zh`      varchar(64)     NOT NULL COMMENT '角色中文名',
    `is_enabled`   boolean         NOT NULL default true COMMENT '是否启用',
    `crt_username` varchar(32)     NOT NULL COMMENT '创建者名称',
    `crt_time`     datetime        NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    `upd_username` varchar(32) COMMENT '更新者名称',
    `upd_time`     datetime COMMENT '更新时间',
    PRIMARY KEY (`id`),
    UNIQUE KEY `uk_role` (`role`),
    UNIQUE KEY `uk_role_zh` (`role_zh`)
) ENGINE = InnoDB
  DEFAULT CHARSET = `utf8mb4` COMMENT ='系统角色表';

CREATE TABLE `sys_permission`
(
    `id`           bigint unsigned NOT NULL AUTO_INCREMENT COMMENT '自增ID',
    `key`          varchar(8)      NOT NULL COMMENT '权限key',
    `method`       varchar(10)     NOT NULL COMMENT '请求方式，如：GET,POST',
    `api`          varchar(64)     NOT NULL COMMENT '请求接口，路径，如遇到占位符{id}之类的，去除',
    `crt_username` varchar(32)     NOT NULL COMMENT '创建者名称',
    `crt_time`     datetime        NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = `utf8mb4` COMMENT ='系统权限与api映射关系表';

CREATE TABLE `sys_user_role`
(
    `id`           bigint unsigned NOT NULL AUTO_INCREMENT COMMENT '自增ID',
    `user_id`      bigint          NOT NULL COMMENT '用户id',
    `role_id`      bigint          NOT NULL COMMENT '角色id',
    `crt_username` varchar(32)     NOT NULL COMMENT '创建者名称',
    `crt_time`     datetime        NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    PRIMARY KEY (`id`),
    UNIQUE KEY `uk_user_role` (`user_id`, `role_id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = `utf8mb4` COMMENT ='用户-角色表';

CREATE TABLE `sys_role_permission`
(
    `id`             bigint unsigned NOT NULL AUTO_INCREMENT COMMENT '自增ID',
    `role_id`        bigint          NOT NULL COMMENT '角色id',
    `permission_key` varchar(8)      NOT NULL COMMENT '权限key',
    `crt_username`   varchar(32)     NOT NULL COMMENT '创建者名称',
    `crt_time`       datetime        NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
    PRIMARY KEY (`id`)
) ENGINE = InnoDB
  DEFAULT CHARSET = `utf8mb4` COMMENT ='角色-权限表';

ALTER TABLE `sys_user`
    ADD COLUMN `modify_username` VARCHAR(32) NULL AFTER `modify_time`,
    ADD COLUMN `create_username` VARCHAR(32) NOT NULL DEFAULT 'admin' AFTER `create_time`;

insert into `sys_role`(`role`, `role_zh`, `crt_username`)
values ('SUPER_ADMIN', '超级管理员', 'admin');

insert into `sys_user_role`(`user_id`, `role_id`, `crt_username`)
values (1, 1, 'admin');

insert into `sys_role_permission`(`role_id`, `permission_key`, `crt_username`)
values (1, 'P001', 'admin'),
       (1, 'P002', 'admin')
;

insert into `sys_permission`(`key`, `method`, `api`, `crt_username`)
VALUES ('P001', 'GET', '/auth/role', 'admin'),
       ('P001', 'POST', '/auth/role', 'admin'),
       ('P001', 'PUT', '/auth/role', 'admin'),
       ('P001', 'PUT', '/auth/role/enable', 'admin'),
       ('P001', 'POST', '/auth/role/permission', 'admin'),
       ('P001', 'GET', '/auth/permission', 'admin'),
       ('P001', 'POST', '/auth/permission', 'admin'),
       ('P001', 'DELETE', '/auth/permission', 'admin'),
       ('P002', 'GET', '/sys/user', 'admin'),
       ('P002', 'POST', '/sys/user', 'admin'),
       ('P002', 'GET', '/sys/user/list', 'admin'),
       ('P002', 'PUT', '/sys/user/role', 'admin'),
       ('P002', 'PUT', '/sys/user', 'admin'),
       ('P002', 'PUT', '/sys/user/enable', 'admin'),
       ('P002', 'POST', '/sys/user/reset_password', 'admin'),
       ('P002', 'PUT', '/sys/user/password', 'admin')
;

INSERT INTO `area`(`name`, `parent_id`)
VALUES ('中国', NULL);
INSERT INTO `area`(`name`, `parent_id`)
VALUES ('浙江', 1);
INSERT INTO `area`(`name`, `parent_id`)
VALUES ('杭州', 2);
INSERT INTO `area`(`name`, `parent_id`)
VALUES ('余杭', 3);

#初始化系统用户 密码: 123qwe=-
insert into `sys_user`(`username`, `nickname`, `role`, `password`, `create_time`)
values ('admin', '超级管理员', 1, '$2a$10$Xc5.aENZjbvb9oiJB5hcnOfxSGCxvCEwd7jM963KTru10qC6TjVwa', now());