<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<div class="sidebar" id="sidebar">
	<ul class="nav nav-list">
		<%-- <li><a href="javascript:void(0)" class="dropdown-toggle"> <i
				class="icon-desktop"></i> <span class="menu-text"> 系统管理 </span> <b
				class="arrow icon-angle-down"></b>
		</a>
			<ul class="submenu">
				<li><a href="${ctx}/user"> <i
						class="icon-double-angle-right"></i> 用户管理
				</a></li>
				<li><a href="${ctx}/menu"> <i
						class="icon-double-angle-right"></i> 菜单管理
				</a></li>
				<li><a href="${ctx}/role"> <i
						class="icon-double-angle-right"></i> 角色管理
				</a></li>

				<li><a href="treeview.html"> <i
						class="icon-double-angle-right"></i> 部门管理
				</a></li>

				<li><a href="${ctx}/dict"> <i
						class="icon-double-angle-right"></i> 字典管理
				</a></li>
			</ul></li> --%>
		<c:forEach items="${sysMenuList}" var="menu">
			<c:if test="${empty menu.parent}">
				<li><a href="javascript:void(0)" class="dropdown-toggle"><i
						class="icon-desktop"></i><span class="menu-text">${menu.name}</span><b
						class="arrow icon-angle-down"></b></a>
					<ul class="submenu">
						<c:forEach items="${sysMenuList}" var="child">
							<c:if test="${menu.id == child.parent.id}">
								<!-- 如果菜单链接以/开头就不需要加了 -->
								<li><a href="${ctx}${child.href}"><i
										class="icon-double-angle-right"></i> ${child.name}</a></li>
							</c:if>
						</c:forEach>
					</ul></li>
			</c:if>
		</c:forEach>
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

		$(function() {
			// 减少全局变量
			(function() {
				var $href = window.location.href;
				$('#sidebar .nav-list li').removeClass('active').removeClass(
						'open');
				$('#sidebar .nav-list li').each(
						function() {
							var $this = $(this);
							var $a = $this.find('a');
							if ($href.indexOf($a.attr("href")) >= 0) {
								$this.addClass('active');
								$this.closest('ul').closest('li').addClass(
										'active open');
							}
						});
			}());
		});
	</script>
</div>
