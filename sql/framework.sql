INSERT INTO f_user (id,login_name,password,name,email,phone,mobile,login_ip,login_date,enabled) VALUES (1,'system','3826d1c4ab0a01fb32018ca4015b2b092eb3ff7d793b18b5091744df','系统管理员','xuhf_1988',	'','','127.0.0.1',now(),1);
show create table f_menu;
alter table f_menu drop foreign key `FKB37C1D98DBE56CBC`;
show create table f_department;
alter table f_menu drop foreign key `FKB37C1D98DBE56CBC`;