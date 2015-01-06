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
			<li class="active">系统参数管理</li>
		</ul>
	</div>
	<div class="page-content">
		<div class="page-header">
			<h1>
				系统参数管理<small> <i class="icon-double-angle-right"></i> 查看
				</small>
			</h1>
		</div>
		<div class="row">
			<div class="col-xs-12">
				<a class="btn btn-primary" href='<c:url value="/parameter"/>'>返回</a>
				<div class="hr hr-dotted"></div>
				<div class="row">
					<div class="col-xs-12">
						<div class="profile-user-info profile-user-info-striped">
							<div class="profile-info-row">
								<div class="profile-info-name">参数名称</div>
								<div class="profile-info-value">
									<span class="">${systemParameter.name}</span>
								</div>
							</div>
							<div class="profile-info-row">
								<div class="profile-info-name">参数值</div>
								<div class="profile-info-value">
									<span class="">${systemParameter.value}</span>
								</div>
							</div>
							<div class="profile-info-row">
								<div class="profile-info-name">参数编码</div>
								<div class="profile-info-value">
									<span class="">${systemParameter.code}</span>
								</div>
							</div>
							<div class="profile-info-row">
								<div class="profile-info-name">备注</div>
								<div class="profile-info-value">
									<span class="">${systemParameter.remarks}</span>
								</div>
							</div>
						</div>
					</div>
				</div>
				<div class="hr hr-dotted"></div>
				<a class="btn btn-primary pull-right"
					href='<c:url value="/parameter/edit/${systemParameter.id}"/>'>修改</a>
			</div>
		</div>
	</div>
</body>
</html>
