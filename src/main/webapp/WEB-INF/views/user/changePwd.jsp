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
				用户管理<small> <i class="icon-double-angle-right"></i> 密码修改
				</small>
			</h1>
		</div>
		<div class="row">
			<div class="col-xs-12">
				<tags:message message="${message.message}"
					success="${message.success }" />
				<div class="row">
					<div class="col-xs-12">
						<form:form id="userForm" data-role='validate'
							action="${ctx }/user/changePwd" cssClass="form-horizontal"
							role="form" method="post">
							<div class="form-group">
								<label class="col-sm-3 control-label no-padding-right"
									for="form-field-1"> 旧密码 </label>
								<div class="col-sm-9">
									<input name="password" id="password" type="password"
										class="input-xlarge required" minlength="6" maxlength="20"
										placeholder="请输入旧密码" />
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-3 control-label no-padding-right"
									for="form-field-1"> 新密码 </label>
								<div class="col-sm-9">
									<input name="newPassword" id="newPassword" type="password"
										class="input-xlarge required" minlength="6" maxlength="20"
										placeholder="请输入新密码" />
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-3 control-label no-padding-right"
									for="form-field-1"> 确认密码 </label>
								<div class="col-sm-9">
									<input type="password" name="confirmPassword"
										placeholder="请再次输入新密码" class="input-xlarge"
										equalTo="#newPassword" minlength="6" maxlength="20" />
								</div>
							</div>
							<div class="clearfix form-actions">
								<div class="col-md-offset-3 col-md-9">
									<button class="btn btn-info" type="submit">
										<i class="icon-ok bigger-110"></i> 确认修改
									</button>
									&nbsp;&nbsp;&nbsp;&nbsp;
									<button class="btn" type="reset">
										<i class="icon-undo bigger-110"></i> 重置
									</button>
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
