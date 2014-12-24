### 后台编码规范
- Service定义接口 ServiceImpl实现
- 一些工具类采用extends的方式扩展现有库
- 严格使用MVC模式，多用一些设计模式
- @Autowired DI统一使用此注解

### 前端编码规范
- 本项目js只写在application.js中，最大程度的减少JS文件冗余
- 后期将会使用require.js对JS进行模块化管理
- 尽量少的使用全局变量