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
				用户管理<small> <i class="icon-double-angle-right"></i> 修改
				</small>
			</h1>
		</div>
		<div class="row">
			<div class="col-xs-12">
				<a class="btn btn-primary" href='<c:url value="/user"/>'>返回</a>
				<div class="hr hr32 hr-dotted"></div>
				<tags:message message="${message.message}"
					success="${message.success }" />
				<div class="row">
					<div class="col-xs-12">
						<form:form id="userForm" data-role='validate'
							action="${ctx }/user/update" cssClass="form-horizontal"
							role="form" method="post" modelAttribute="user">
							<form:hidden path="id" value="${user.id }" />
							<div class="form-group">
								<label class="col-sm-3 control-label no-padding-right"
									for="form-field-1"> 用户名 </label>
								<div class="col-sm-9">
									<form:input path="loginName" cssClass="input-xlarge required"
										value="${user.loginName }" disabled="true" />
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-3 control-label no-padding-right"
									for="form-field-1"> 密码 </label>
								<div class="col-sm-9">
									<form:password path="password" id="password"
										cssClass="input-xlarge" minlength="6" maxlength="20"
										placeholder="请输入密码" />
									<label style="color:#657ba0;margin-left: 5px;">若不修改请留空</label>
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-3 control-label no-padding-right"
									for="form-field-1"> 确认密码 </label>
								<div class="col-sm-9">
									<input type="password" name="confirmPassword"
										placeholder="请再次输入密码" class="input-xlarge" equalTo="#password"
										minlength="6" maxlength="20" />
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-3 control-label no-padding-right"
									for="form-field-1"> 昵称 </label>
								<div class="col-sm-9">
									<form:input path="name" placeholder="请输入昵称"
										cssClass="input-xlarge required" value="${user.name }" />
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-3 control-label no-padding-right"
									for="form-field-1"> 邮箱 </label>
								<div class="col-sm-9">
									<form:input path="email" cssClass="input-xlarge required email"
										placeholder="请输入邮箱" maxlength="255" value="${user.email }" />
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-3 control-label no-padding-right"
									for="form-field-1"> 电话 </label>
								<div class="col-sm-9">
									<form:input path="mobile" placeholder="请输入手机号码"
										cssClass="input-xlarge required" value="${user.mobile }" />
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-3 control-label no-padding-right"
									for="form-field-1"> 固定电话 </label>
								<div class="col-sm-9">
									<form:input path="phone" placeholder="请输入固定电话"
										cssClass="input-xlarge required" value="${user.phone }" />
								</div>
							</div>
							<div class="clearfix form-actions">
								<div class="col-md-offset-3 col-md-9">
									<form:button class="btn btn-info" type="submit">
										<i class="icon-ok bigger-110"></i> 确认修改
									</form:button>
									&nbsp;&nbsp;&nbsp;&nbsp;
									<form:button class="btn" type="reset">
										<i class="icon-undo bigger-110"></i> 重置
									</form:button>
								</div>
							</div>
						</form:form>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>
