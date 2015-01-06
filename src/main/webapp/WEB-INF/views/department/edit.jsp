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
				部门管理<small> <i class="icon-double-angle-right"></i> 修改
				</small>
			</h1>
		</div>
		<div class="row">
			<div class="col-xs-12">
				<a class="btn btn-primary" href='<c:url value="/department"/>'>返回</a>
				<div class="hr hr32 hr-dotted"></div>
				<tags:message message="${message.message}"
					success="${message.success }" />
				<div class="row">
					<div class="col-xs-12">
						<form:form id="menuForm" data-role='validate'
							action="${ctx }/department/update" cssClass="form-horizontal"
							role="form" method="post" modelAttribute="department">
							<form:hidden path="id" value="${department.id }" />
							<div class="form-group">
								<label class="col-sm-3 control-label no-padding-right"
									for="form-field-1"> 上级部门</label>
								<div class="col-sm-9">
									<form:select path="parent.id"
										cssClass="input-xlarge chosen-select">
										<form:option value="0">一级部门</form:option>
										<c:forEach items="${departmentList}" var="obj">
											<c:choose>
												<c:when test="${department.parent.id == obj.id}">
													<form:option value="${obj.id}" selected="selected">${obj.name}</form:option>
												</c:when>
												<c:otherwise>
													<form:option value="${obj.id}">${obj.name}</form:option>
												</c:otherwise>
											</c:choose>
										</c:forEach>
									</form:select>
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-3 control-label no-padding-right"
									for="form-field-1"> 名称 </label>
								<div class="col-sm-9">
									<form:input path="name" htmlEscape="false" maxlength="50"
										class="input-xlarge required" placeholder="请输入部门名称" />
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-3 control-label no-padding-right"
									for="form-field-1"> 描述 </label>
								<div class="col-sm-9">
									<form:textarea path="description" htmlEscape="false"
										class="input-xlarge required" rows="5" placeholder="请输入部门描述" />
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
