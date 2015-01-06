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
			<li class="active">数据字典管理</li>
		</ul>
	</div>
	<div class="page-content">
		<div class="page-header">
			<h1>
				数据字典管理<small> <i class="icon-double-angle-right"></i> 添加
				</small>
			</h1>
		</div>
		<div class="row">
			<div class="col-xs-12">
				<a class="btn btn-primary" href='<c:url value="/dict"/>'>返回</a>
				<div class="hr hr-dotted"></div>
				<tags:message message="${message.message}"
					success="${message.success }" />
				<div class="row">
					<div class="col-xs-12">
						<form:form id="userForm" data-role='validate'
							action="${ctx }/dict/save" cssClass="form-horizontal" role="form"
							method="post" modelAttribute="dictHeader">
							<div class="form-group">
								<label class="col-sm-3 control-label no-padding-right"
									for="form-field-1"> 数据字典名称 </label>
								<div class="col-sm-9">
									<form:input path="name" cssClass="input-xlarge required"
										minlength="2" maxlength="20" value="${dictHeader.name }"
										placeholder="请输入数据字典名称" />
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-3 control-label no-padding-right"
									for="form-field-1"> 数据字典编码 </label>
								<div class="col-sm-9">
									<form:input path="value" placeholder="请输入数据字典编码 "
										cssClass="input-xlarge required" value="${dictHeader.value }" />
								</div>
							</div>
							<div class="clearfix form-actions">
								<div class="col-md-offset-3 col-md-9">
									<form:button class="btn btn-info" type="submit">
										<i class="icon-ok bigger-110"></i> 提交
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
