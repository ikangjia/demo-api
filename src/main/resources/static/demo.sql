-- auto-generated definition
create schema db_demo collate utf8_general_ci;


-- auto-generated definition
create table t_user
(
    id          bigint auto_increment
        primary key,
    username    varchar(50)       null,
    password    varchar(50)       null,
    nickname    varchar(20)       null comment '昵称',
    email       varchar(50)       null,
    phone       varchar(20)       null,
    address     varchar(50)       null,
    create_time datetime          null,
    update_time datetime          null,
    operator    varchar(50)       null comment '操作人',
    is_deleted  tinyint default 0 null
)
    comment '用户表' auto_increment = 1532552007980711942;


INSERT INTO db_demo.t_user (id, username, password, nickname, email, phone, address, create_time, update_time, operator, is_deleted) VALUES (1, 'admin', 'admin', '管理员', 'admin@qq.com', '12345678901', '天津市红桥区', '2022-06-01 17:27:38', null, 'admin', 0);
INSERT INTO db_demo.t_user (id, username, password, nickname, email, phone, address, create_time, update_time, operator, is_deleted) VALUES (2, 'kangjia2', 'admin', '康佳', 'kangjia@qq.com', '15345678901', '天津市和平区', '2022-06-01 17:27:38', '2022-06-06 10:30:56', 'admin', 0);
INSERT INTO db_demo.t_user (id, username, password, nickname, email, phone, address, create_time, update_time, operator, is_deleted) VALUES (3, 'admin2', 'admin', '管理员假的', 'admin@qq.com', '12345678901', '天津市红桥区', '2022-06-01 17:27:38', null, 'admin', 1);
INSERT INTO db_demo.t_user (id, username, password, nickname, email, phone, address, create_time, update_time, operator, is_deleted) VALUES (4, 'admin2', 'admin', '管理员假的', 'admin@qq.com', '12345678901', '天津市红桥区', '2022-06-01 17:27:38', null, 'admin', 1);
INSERT INTO db_demo.t_user (id, username, password, nickname, email, phone, address, create_time, update_time, operator, is_deleted) VALUES (5, 'admin2', 'admin', '管理员假的', 'admin@qq.com', '12345678901', '天津市红桥区', '2022-06-01 17:27:38', null, 'admin', 1);
INSERT INTO db_demo.t_user (id, username, password, nickname, email, phone, address, create_time, update_time, operator, is_deleted) VALUES (6, 'admin2', 'admin', '管理员假的', 'admin@qq.com', '12345678901', '天津市红桥区', '2022-06-01 17:27:38', null, 'admin', 1);
INSERT INTO db_demo.t_user (id, username, password, nickname, email, phone, address, create_time, update_time, operator, is_deleted) VALUES (7, 'admin2', 'admin', '管理员假的', 'admin@qq.com', '12345678901', '天津市红桥区', '2022-06-01 17:27:38', null, 'admin', 1);
INSERT INTO db_demo.t_user (id, username, password, nickname, email, phone, address, create_time, update_time, operator, is_deleted) VALUES (8, 'string', 'string', 'string', 'string', 'string', 'string', '2022-06-03 02:37:16', '2022-06-03 02:37:16', 'string', 1);
INSERT INTO db_demo.t_user (id, username, password, nickname, email, phone, address, create_time, update_time, operator, is_deleted) VALUES (9, 'string', 'string', 'baba', 'string', 'string', 'string', '2022-06-03 02:37:16', '2022-06-03 02:37:16', 'string', 1);
INSERT INTO db_demo.t_user (id, username, password, nickname, email, phone, address, create_time, update_time, operator, is_deleted) VALUES (10, null, null, null, null, null, null, null, null, null, 1);
INSERT INTO db_demo.t_user (id, username, password, nickname, email, phone, address, create_time, update_time, operator, is_deleted) VALUES (11, '11', null, '11', '11', '11', '11', null, null, null, 1);
INSERT INTO db_demo.t_user (id, username, password, nickname, email, phone, address, create_time, update_time, operator, is_deleted) VALUES (12, '11', null, '11', '11', '11', '11', '2022-06-05 12:36:49', null, null, 1);
INSERT INTO db_demo.t_user (id, username, password, nickname, email, phone, address, create_time, update_time, operator, is_deleted) VALUES (13, '11', null, '11', '11', '11', '11', '2022-06-05 12:41:20', null, null, 1);
INSERT INTO db_demo.t_user (id, username, password, nickname, email, phone, address, create_time, update_time, operator, is_deleted) VALUES (14, '2', null, '2', '2', '2', '2', '2022-06-05 12:44:16', null, null, 1);
INSERT INTO db_demo.t_user (id, username, password, nickname, email, phone, address, create_time, update_time, operator, is_deleted) VALUES (15, 'as', null, 'asda', 'sda', 'sdas', 'da', '2022-06-05 12:59:12', null, null, 1);
INSERT INTO db_demo.t_user (id, username, password, nickname, email, phone, address, create_time, update_time, operator, is_deleted) VALUES (16, 'yuanfang', null, '李元芳', 'liyuanfang@qq.com', '18332112345', '宇宙银河系太阳系地球', '2022-06-06 10:11:07', null, null, 0);
INSERT INTO db_demo.t_user (id, username, password, nickname, email, phone, address, create_time, update_time, operator, is_deleted) VALUES (17, null, null, null, null, null, null, '2022-06-06 10:25:29', null, null, 1);
INSERT INTO db_demo.t_user (id, username, password, nickname, email, phone, address, create_time, update_time, operator, is_deleted) VALUES (18, 'qq', null, 'qqqq', 'qq@123.cn', null, null, '2022-06-06 10:27:02', '2022-06-06 10:30:36', null, 1);

