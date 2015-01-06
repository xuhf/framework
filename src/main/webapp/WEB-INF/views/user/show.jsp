<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<!DOCTYPE html>
<html lang="en" style="overflow: hidden;">
<head>
<meta charset="utf-8">
</head>
<body>
	<div class="breadcrumbs" id="breadcrumbs">
		<ul class="breadcrumb">
			<li><i class="icon-home home-icon"></i> <a href="${ctx}">首页</a></li>
			<li class="active">用户管理</li>
		</ul>
	</div>
	<div class="page-content">
		<div class="page-header">
			<h1>
				用户管理<small> <i class="icon-double-angle-right"></i> 查看
				</small>
			</h1>
		</div>
		<div class="row">
			<div class="col-xs-12">
				<a class="btn btn-primary" href='<c:url value="/user"/>'>返回</a>
				<div class="hr hr-dotted"></div>
				<div class="row">
					<div class="col-xs-12">
						<div class="profile-user-info profile-user-info-striped">
							<div class="profile-info-row">
								<div class="profile-info-name">用户名</div>
								<div class="profile-info-value">
									<span class="">${user.loginName}</span>
								</div>
							</div>
							<div class="profile-info-row">
								<div class="profile-info-name">昵称</div>
								<div class="profile-info-value">
									<span class="">${user.name}</span>
								</div>
							</div>
							<div class="profile-info-row">
								<div class="profile-info-name">邮件</div>
								<div class="profile-info-value">
									<span class="">${user.email}</span>
								</div>
							</div>
							<div class="profile-info-row">
								<div class="profile-info-name">电话</div>
								<div class="profile-info-value">
									<span class="">${user.mobile}</span>
								</div>
							</div>
							<div class="profile-info-row">
								<div class="profile-info-name">固定电话</div>
								<div class="profile-info-value">
									<span class="">${user.phone}</span>
								</div>
							</div>
							<div class="profile-info-row">
								<div class="profile-info-name">部门</div>
								<div class="profile-info-value">
									<span class="">${user.department.name}</span>
								</div>
							</div>
							<div class="profile-info-row">
								<div class="profile-info-name">最后登录时间</div>
								<div class="profile-info-value">
									<span class="">${user.loginDate}</span>
								</div>
							</div>
							<div class="profile-info-row">
								<div class="profile-info-name">最后登录IP</div>
								<div class="profile-info-value">
									<span class="">${user.loginIp}</span>
								</div>
							</div>
							<div class="profile-info-row">
								<div class="profile-info-name">用户角色</div>
								<div class="profile-info-value">
									<span class=""> <c:forEach items="${user.roleList }"
											var="role">
											${role.name }&nbsp;
										</c:forEach>
									</span>
								</div>
							</div>
						</div>
					</div>
				</div>
				<div class="hr hr-dotted"></div>
				<a class="btn btn-primary pull-right"
					href='<c:url value="/user/edit/${user.id}"/>'>修改</a>
			</div>
		</div>
	</div>
</body>
</html>
