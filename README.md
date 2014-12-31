## 说明
SpringMVC+hibernate搭建的基础框架。

### 主要包含
* 系统
	* 用户管理
	* 菜单管理
	* 角色管理（目前是基于菜单的权限管理）
	* 数据字典管理
	* 部门管理
	
## 技术选择
- JDK1.7.0_67
- 基于servlet3.0.1 使用tomcat7
- SpringMVC
- Hibernate，数据库连接池使用Druid
- SiteMesh （前端装饰）
- Shiro （apache的权限框架）
- 前端使用ACE前端框架（基于Bootstarp）

## 不足
- 必须使用tomcat7 或者 查看此文章 [http://hibernate.org/validator/faq/](http://hibernate.org/validator/faq/)