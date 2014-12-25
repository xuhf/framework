<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<div class="sidebar" id="sidebar">
	<ul class="nav nav-list">
		<li><a href="javascript:void(0)" class="dropdown-toggle"> <i
				class="icon-desktop"></i> <span class="menu-text"> 系统管理 </span> <b
				class="arrow icon-angle-down"></b>
		</a>
			<ul class="submenu">
				<li><a href="${ctx}/user"> <i
						class="icon-double-angle-right"></i> 用户管理
				</a></li>

				<li><a href="buttons.html"> <i
						class="icon-double-angle-right"></i> 角色管理
				</a></li>

				<li><a href="treeview.html"> <i
						class="icon-double-angle-right"></i> 部门管理
				</a></li>

				<li><a href="jquery-ui.html"> <i
						class="icon-double-angle-right"></i> 字典管理
				</a></li>
			</ul></li>
	</ul>
	<div class="sidebar-collapse" id="sidebar-collapse">
		<i class="icon-double-angle-left" data-icon1="icon-double-angle-left"
			data-icon2="icon-double-angle-right"></i>
	</div>
	<script type="text/javascript">
		try {
			ace.settings.check('sidebar', 'collapsed')
		} catch (e) {
		}
	</script>
</div>
