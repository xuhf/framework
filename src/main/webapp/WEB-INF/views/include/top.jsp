<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<div class="navbar navbar-default" id="navbar">
	<div class="navbar-container" id="navbar-container" style="padding-right:0px;">
		<div class="navbar-header pull-left">
			<a href="${ctx }" class="navbar-brand"> <small> <i
					class="icon-leaf"></i> BaseFramework|http://www.isharec.com --
					使用ACE后台管理系统模版
			</small>
			</a>
		</div>
		<div class="navbar-header pull-right" role="navigation">
			<ul class="nav ace-nav">
				<li class="light-blue"><a data-toggle="dropdown" href="#"
					class="dropdown-toggle"> <img class="nav-user-photo"
						src="${ctx }/assets/avatars/user.jpg" alt="Jason's Photo" /> <span
						class="user-info"> <small>欢迎光临,</small> <shiro:principal
								property="name" />
					</span> <i class="icon-caret-down"></i>
				</a>
					<ul
						class="user-menu pull-right dropdown-menu dropdown-yellow dropdown-caret dropdown-close">
						<li><a href="#"> <i class="icon-cog"></i> 设置
						</a></li>
						<li><a href="#"> <i class="icon-user"></i> 个人资料
						</a></li>
						<li class="divider"></li>
						<li><a href="${ctx }/logout"> <i class="icon-off"></i> 退出
						</a></li>
					</ul></li>
			</ul>
		</div>
	</div>
</div>
