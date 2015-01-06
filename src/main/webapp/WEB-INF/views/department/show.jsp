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
			<li class="active">部门管理</li>
		</ul>
	</div>
	<div class="page-content">
		<div class="page-header">
			<h1>
				部门管理<small> <i class="icon-double-angle-right"></i> 部门信息
				</small>
			</h1>
		</div>
		<div class="row">
			<div class="col-xs-12">
				<a class="btn btn-primary" href='<c:url value="/department"/>'>返回</a>
				<div class="hr hr-dotted"></div>
				<div class="row">
					<div class="col-xs-12">
						<div class="profile-user-info profile-user-info-striped">
							<div class="profile-info-row">
								<div class="profile-info-name">部门名称</div>
								<div class="profile-info-value">
									<span class="">${department.name}</span>
								</div>
							</div>
							<div class="profile-info-row">
								<div class="profile-info-name">部门简介</div>
								<div class="profile-info-value">
									<span class="">${department.description}</span>
								</div>
							</div>
							<div class="profile-info-row">
								<div class="profile-info-name">上级部门</div>
								<div class="profile-info-value">
									<span class=""> <c:choose>
											<c:when test="${department.parent == null || department.parent.id == 0}">
												无
											</c:when>
											<c:otherwise>
												${department.parent.name}
											</c:otherwise>
										</c:choose>
									</span>
								</div>
							</div>
						</div>
					</div>
				</div>
				<div class="hr hr-dotted"></div>
				<a class="btn btn-primary pull-right"
					href='<c:url value="/department/edit/${department.id}"/>'>修改</a>
			</div>
		</div>
	</div>
</body>
</html>
