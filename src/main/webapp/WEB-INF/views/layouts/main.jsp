<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<!DOCTYPE html>
<html style="overflow-x: hidden; overflow-y: auto;">
<head>
<title><sitemesh:write property='title' /></title>
<%@include file="/WEB-INF/views/include/header.jsp"%>
<sitemesh:write property='head' />
</head>
<body>
	<div class="navbar navbar-default" id="navbar">
		<script type="text/javascript">
			try {
				ace.settings.check('navbar', 'fixed')
			} catch (e) {
			}
		</script>
		<div class="navbar-container" id="navbar-container">
			<div class="navbar-header pull-left">
				<a href="${ctx }" class="navbar-brand"> <small> <i
						class="icon-leaf"></i> Framework|isharec.com -- 使用ACE后台管理系统模版
				</small>
				</a>
			</div>
			<div class="navbar-header pull-right" role="navigation">
				<ul class="nav ace-nav">
					<li class="light-blue"><a data-toggle="dropdown" href="#"
						class="dropdown-toggle"> <img class="nav-user-photo"
							src="${ctx }/assets/avatars/user.jpg" alt="Jason's Photo" /> <span
							class="user-info"> <small>欢迎光临,</small> Jason
						</span> <i class="icon-caret-down"></i>
					</a>
						<ul
							class="user-menu pull-right dropdown-menu dropdown-yellow dropdown-caret dropdown-close">
							<li><a href="#"> <i class="icon-cog"></i> 设置
							</a></li>
							<li><a href="#"> <i class="icon-user"></i> 个人资料
							</a></li>
							<li class="divider"></li>
							<li><a href="#"> <i class="icon-off"></i> 退出
							</a></li>
						</ul></li>
				</ul>
			</div>
		</div>
	</div>
	<div class="main-container" id="main-container">
		<script type="text/javascript">
			try {
				ace.settings.check('main-container', 'fixed')
			} catch (e) {
			}
		</script>
		<div class="main-container-inner">
			<a class="menu-toggler" id="menu-toggler" href="#"> <span
				class="menu-text"></span>
			</a>
			<div class="sidebar" id="sidebar">
				<script type="text/javascript">
					try {
						ace.settings.check('sidebar', 'fixed')
					} catch (e) {
					}
				</script>

				<div class="sidebar-shortcuts" id="sidebar-shortcuts">
					<div class="sidebar-shortcuts-large" id="sidebar-shortcuts-large">
						<button class="btn btn-success">
							<i class="icon-signal"></i>
						</button>

						<button class="btn btn-info">
							<i class="icon-pencil"></i>
						</button>

						<button class="btn btn-warning">
							<i class="icon-group"></i>
						</button>

						<button class="btn btn-danger">
							<i class="icon-cogs"></i>
						</button>
					</div>

					<div class="sidebar-shortcuts-mini" id="sidebar-shortcuts-mini">
						<span class="btn btn-success"></span> <span class="btn btn-info"></span>

						<span class="btn btn-warning"></span> <span class="btn btn-danger"></span>
					</div>
				</div>
				<!-- #sidebar-shortcuts -->

				<ul class="nav nav-list">
					<li class="active"><a href="index.html"> <i
							class="icon-dashboard"></i> <span class="menu-text"> 控制台 </span>
					</a></li>

					<li><a href="typography.html"> <i class="icon-text-width"></i>
							<span class="menu-text"> 文字排版 </span>
					</a></li>

					<li><a href="#" class="dropdown-toggle"> <i
							class="icon-desktop"></i> <span class="menu-text"> UI 组件 </span>

							<b class="arrow icon-angle-down"></b>
					</a>

						<ul class="submenu">
							<li><a href="elements.html"> <i
									class="icon-double-angle-right"></i> 组件
							</a></li>

							<li><a href="buttons.html"> <i
									class="icon-double-angle-right"></i> 按钮 &amp; 图表
							</a></li>

							<li><a href="treeview.html"> <i
									class="icon-double-angle-right"></i> 树菜单
							</a></li>

							<li><a href="jquery-ui.html"> <i
									class="icon-double-angle-right"></i> jQuery UI
							</a></li>

							<li><a href="nestable-list.html"> <i
									class="icon-double-angle-right"></i> 可拖拽列表
							</a></li>

							<li><a href="#" class="dropdown-toggle"> <i
									class="icon-double-angle-right"></i> 三级菜单 <b
									class="arrow icon-angle-down"></b>
							</a>

								<ul class="submenu">
									<li><a href="#"> <i class="icon-leaf"></i> 第一级
									</a></li>

									<li><a href="#" class="dropdown-toggle"> <i
											class="icon-pencil"></i> 第四级 <b class="arrow icon-angle-down"></b>
									</a>

										<ul class="submenu">
											<li><a href="#"> <i class="icon-plus"></i> 添加产品
											</a></li>

											<li><a href="#"> <i class="icon-eye-open"></i> 查看商品
											</a></li>
										</ul></li>
								</ul></li>
						</ul></li>

					<li><a href="#" class="dropdown-toggle"> <i
							class="icon-list"></i> <span class="menu-text"> 表格 </span> <b
							class="arrow icon-angle-down"></b>
					</a>

						<ul class="submenu">
							<li><a href="tables.html"> <i
									class="icon-double-angle-right"></i> 简单 &amp; 动态
							</a></li>

							<li><a href="jqgrid.html"> <i
									class="icon-double-angle-right"></i> jqGrid plugin
							</a></li>
						</ul></li>

					<li><a href="#" class="dropdown-toggle"> <i
							class="icon-edit"></i> <span class="menu-text"> 表单 </span> <b
							class="arrow icon-angle-down"></b>
					</a>

						<ul class="submenu">
							<li><a href="form-elements.html"> <i
									class="icon-double-angle-right"></i> 表单组件
							</a></li>

							<li><a href="form-wizard.html"> <i
									class="icon-double-angle-right"></i> 向导提示 &amp; 验证
							</a></li>

							<li><a href="wysiwyg.html"> <i
									class="icon-double-angle-right"></i> 编辑器
							</a></li>

							<li><a href="dropzone.html"> <i
									class="icon-double-angle-right"></i> 文件上传
							</a></li>
						</ul></li>

					<li><a href="widgets.html"> <i class="icon-list-alt"></i>
							<span class="menu-text"> 插件 </span>
					</a></li>

					<li><a href="calendar.html"> <i class="icon-calendar"></i>

							<span class="menu-text"> 日历 <span
								class="badge badge-transparent tooltip-error"
								title="2&nbsp;Important&nbsp;Events"> <i
									class="icon-warning-sign red bigger-130"></i>
							</span>
						</span>
					</a></li>

					<li><a href="gallery.html"> <i class="icon-picture"></i> <span
							class="menu-text"> 相册 </span>
					</a></li>

					<li><a href="#" class="dropdown-toggle"> <i
							class="icon-tag"></i> <span class="menu-text"> 更多页面 </span> <b
							class="arrow icon-angle-down"></b>
					</a>

						<ul class="submenu">
							<li><a href="profile.html"> <i
									class="icon-double-angle-right"></i> 用户信息
							</a></li>

							<li><a href="inbox.html"> <i
									class="icon-double-angle-right"></i> 收件箱
							</a></li>

							<li><a href="pricing.html"> <i
									class="icon-double-angle-right"></i> 售价单
							</a></li>

							<li><a href="invoice.html"> <i
									class="icon-double-angle-right"></i> 购物车
							</a></li>

							<li><a href="timeline.html"> <i
									class="icon-double-angle-right"></i> 时间轴
							</a></li>

							<li><a href="login.html"> <i
									class="icon-double-angle-right"></i> 登录 &amp; 注册
							</a></li>
						</ul></li>

					<li><a href="#" class="dropdown-toggle"> <i
							class="icon-file-alt"></i> <span class="menu-text"> 其他页面 <span
								class="badge badge-primary ">5</span>
						</span> <b class="arrow icon-angle-down"></b>
					</a>

						<ul class="submenu">
							<li><a href="faq.html"> <i
									class="icon-double-angle-right"></i> 帮助
							</a></li>

							<li><a href="error-404.html"> <i
									class="icon-double-angle-right"></i> 404错误页面
							</a></li>

							<li><a href="error-500.html"> <i
									class="icon-double-angle-right"></i> 500错误页面
							</a></li>

							<li><a href="grid.html"> <i
									class="icon-double-angle-right"></i> 网格
							</a></li>

							<li><a href="blank.html"> <i
									class="icon-double-angle-right"></i> 空白页面
							</a></li>
						</ul></li>
				</ul>
				<!-- /.nav-list -->

				<div class="sidebar-collapse" id="sidebar-collapse">
					<i class="icon-double-angle-left"
						data-icon1="icon-double-angle-left"
						data-icon2="icon-double-angle-right"></i>
				</div>

				<script type="text/javascript">
					try {
						ace.settings.check('sidebar', 'collapsed')
					} catch (e) {
					}
				</script>
			</div>

			<div class="main-content">
				<sitemesh:write property='body' />
			</div>
			<div class="ace-settings-container" id="ace-settings-container">
				<div class="btn btn-app btn-xs btn-warning ace-settings-btn"
					id="ace-settings-btn">
					<i class="icon-cog bigger-150"></i>
				</div>

				<div class="ace-settings-box" id="ace-settings-box">
					<div>
						<div class="pull-left">
							<select id="skin-colorpicker" class="hide">
								<option data-skin="default" value="#438EB9">#438EB9</option>
								<option data-skin="skin-1" value="#222A2D">#222A2D</option>
								<option data-skin="skin-2" value="#C6487E">#C6487E</option>
								<option data-skin="skin-3" value="#D0D0D0">#D0D0D0</option>
							</select>
						</div>
						<span>&nbsp; 选择皮肤</span>
					</div>
					<div>
						<input type="checkbox" class="ace ace-checkbox-2"
							id="ace-settings-navbar" /> <label class="lbl"
							for="ace-settings-navbar"> 固定导航条</label>
					</div>

					<div>
						<input type="checkbox" class="ace ace-checkbox-2"
							id="ace-settings-sidebar" /> <label class="lbl"
							for="ace-settings-sidebar"> 固定滑动条</label>
					</div>

					<div>
						<input type="checkbox" class="ace ace-checkbox-2"
							id="ace-settings-breadcrumbs" /> <label class="lbl"
							for="ace-settings-breadcrumbs">固定面包屑</label>
					</div>

					<div>
						<input type="checkbox" class="ace ace-checkbox-2"
							id="ace-settings-rtl" /> <label class="lbl"
							for="ace-settings-rtl">切换到左边</label>
					</div>

					<div>
						<input type="checkbox" class="ace ace-checkbox-2"
							id="ace-settings-add-container" /> <label class="lbl"
							for="ace-settings-add-container"> 切换窄屏 <b></b>
						</label>
					</div>
				</div>
			</div>
		</div>
		<a href="#" id="btn-scroll-up"
			class="btn-scroll-up btn btn-sm btn-inverse"> <i
			class="icon-double-angle-up icon-only bigger-110"></i>
		</a>
	</div>
	<script type="text/javascript">
		jQuery(function($) {
		});
	</script>
</body>
</html>
