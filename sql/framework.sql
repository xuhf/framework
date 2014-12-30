DROP TABLE
IF EXISTS `f_menu`;

CREATE TABLE `f_menu` (
	`id` BIGINT (20) NOT NULL AUTO_INCREMENT,
	`create_at` datetime DEFAULT NULL,
	`update_at` datetime DEFAULT NULL,
	`href` VARCHAR (255) DEFAULT NULL,
	`icon` VARCHAR (100) DEFAULT NULL,
	`is_show` VARCHAR (1) DEFAULT NULL,
	`name` VARCHAR (100) DEFAULT NULL,
	`padding_num` INT (11) NOT NULL,
	`parent_ids` VARCHAR (255) DEFAULT NULL,
	`permission` VARCHAR (200) DEFAULT NULL,
	`sort` INT (11) NOT NULL,
	`target` VARCHAR (20) DEFAULT NULL,
	`parent_id` BIGINT (20) NOT NULL,
	PRIMARY KEY (`id`),
	KEY `sys_menu_parent_id` (`parent_id`)
) ENGINE = INNODB DEFAULT CHARSET = utf8 COMMENT='菜单表';

INSERT INTO f_user (id,login_name,password,name,email,phone,mobile,login_ip,login_date,enabled) VALUES (1,'system','3826d1c4ab0a01fb32018ca4015b2b092eb3ff7d793b18b5091744df','系统管理员','xuhf_1988',	'','','127.0.0.1',now(),1);

show create table f_menu;
alter table f_menu drop foreign key `FKB37C1D98DBE56CBC`