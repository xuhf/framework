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
				用户管理<small> <i class="icon-double-angle-right"></i> 添加
				</small>
			</h1>
		</div>
		<div class="row">
			<div class="col-xs-12">
				<a class="btn btn-primary" href='<c:url value="/user"/>'>返回</a>
				<div class="hr hr32 hr-dotted"></div>
				<div class="row">
					<div class="col-xs-12">
						<form class="form-horizontal" role="form">
							<div class="form-group">
								<label class="col-sm-3 control-label no-padding-right"
									for="form-field-1"> 用户名 </label>

								<div class="col-sm-9">
									<input type="text" placeholder="Username" class="input-xlarge" />
								</div>
							</div>
							<div class="space-4"></div>
							<div class="form-group">
								<label class="col-sm-3 control-label no-padding-right"
									for="form-field-2"> 密码 </label>
								<div class="col-sm-9">
									<input type="password" placeholder="Password"
										class="input-xlarge" />
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-3 control-label no-padding-right"
									for="form-field-2"> 重复密码 </label>
								<div class="col-sm-9">
									<input type="password" placeholder="Password"
										class="input-xlarge" />
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-3 control-label no-padding-right"
									for="form-field-2"> 邮箱 </label>
								<div class="col-sm-9">
									<input type="password" placeholder="Password"
										class="input-xlarge" />
								</div>
							</div>
							<div class="clearfix form-actions">
								<div class="col-md-offset-3 col-md-9">
									<button class="btn btn-info" type="button">
										<i class="icon-ok bigger-110"></i> 提交
									</button>
									&nbsp;&nbsp;&nbsp;&nbsp;
									<button class="btn" type="reset">
										<i class="icon-undo bigger-110"></i> 重置
									</button>
								</div>
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>
