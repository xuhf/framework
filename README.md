# BaseFramework后台管理系统基础框架
## 简介
本系统由`SpringMVC`，`hibernate`主要搭建。
主要用来解决在一些中小型项目中重复搭建框架的低效率。
本系统不包含任何业务逻辑，只考虑最通用的部分。
由于技术能力不足，程序中可能包含N多Bug以及未完成功能，欢迎您随时修改源代码。
在完成这个系统的过程中，从[jeesite](https://github.com/thinkgem/jeesite)项目中参考/copy很多，灰常感谢。

欢迎访问 [http://www.isharec.com](http://www.isharec.com)

## 主要功能
* 系统
	* 用户管理
	* 菜单管理
	* 角色管理 （目前是基于菜单的权限管理）
	* 字典管理
	* 部门管理 （未完成）

## 技术选择
#### 后台技术选择
* JDK `1.7.0_67`
* Servlet3.0.1
* SpringMVC `3.2.5.RELEASE`
* hibernate `4.2.0.Final`
* Druid [https://github.com/alibaba/druid/](https://github.com/alibaba/druid/)
* SiteMesh `3.0` 
* Apache-Shiro
* ehcache `2.6.6`

#### 前端技术选择
* ace `前端基础框架`
* jquery-2.1.1 javascript库
* jquery.validate 表单验证插件
* jquery.ztree 树插件
* jBox 消息提示插件