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
			<li class="active">菜单管理</li>
		</ul>
	</div>
	<div class="page-content">
		<div class="page-header">
			<h1>
				菜单管理<small> <i class="icon-double-angle-right"></i> 添加
				</small>
			</h1>
		</div>
		<div class="row">
			<div class="col-xs-12">
				<a class="btn btn-primary" href='<c:url value="/menu"/>'>返回</a>
				<div class="hr hr-dotted"></div>
				<tags:message message="${message.message}"
					success="${message.success }" />
				<div class="row">
					<div class="col-xs-12">
						<form:form id="menuForm" data-role='validate'
							action="${ctx }/menu/save" cssClass="form-horizontal" role="form"
							method="post" modelAttribute="menu">
							<div class="form-group">
								<label class="col-sm-3 control-label no-padding-right"
									for="form-field-1"> 上级菜单</label>
								<div class="col-sm-9">
									<form:select path="parent.id"
										cssClass="input-xlarge chosen-select">
										<form:option value="0">一级菜单</form:option>
										<c:forEach items="${menuList}" var="obj">
											<c:if test="${obj.isShow eq '1' && menu.parent.id==obj.id}">
												<form:option value="${obj.id}" selected="selected">${obj.name}</form:option>
											</c:if>
											<c:if test="${obj.isShow eq '1'}">
												<form:option value="${obj.id}">${obj.name}</form:option>
											</c:if>
										</c:forEach>
									</form:select>
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-3 control-label no-padding-right"
									for="form-field-1"> 名称 </label>
								<div class="col-sm-9">
									<form:input path="name" htmlEscape="false" maxlength="50"
										class="input-xlarge required" placeholder="请输入菜单名称" />
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-3 control-label no-padding-right"
									for="form-field-1"> 链接 </label>
								<div class="col-sm-9">
									<form:input path="href" htmlEscape="false"
										cssClass="input-xlarge" maxlength="100"
										placeholder="请输入菜单链接，非必需" />
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-3 control-label no-padding-right"
									for="form-field-1"> 图标 </label>
								<div class="col-sm-9">
									<form:select path="icon" cssClass="input-xlarge chosen-select">
										<form:option value="icon-desktop">
											<span><i class="icon-desktop"></i> 桌面</span>
										</form:option>
									</form:select>
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-3 control-label no-padding-right"
									for="form-field-1"> 目标 </label>
								<div class="col-sm-9">
									<form:input path="target" cssClass="input-xlarge"
										htmlEscape="false" maxlength="10" />
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-3 control-label no-padding-right"
									for="form-field-1"> 排序 </label>
								<div class="col-sm-9">
									<form:input path="sort" cssClass="input-xlarge required digits"
										htmlEscape="false" maxlength="50" />
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-3 control-label no-padding-right"
									for="form-field-1"> 可见 </label>
								<div class="col-sm-9">
									<%-- <div class="radio">
										<label> <form:radiobutton path="isShow" value="1"
												cssClass="ace" /><span class="lbl"> 显示 </span>
										</label>
									</div>
									<div class="radio">
										<label> <form:radiobutton path="isShow" value="0"
												cssClass="ace" /> <span class="lbl"> 隐藏 </span>
										</label>
									</div> --%>
									<c:if test="${menu.isShow != '0'}">
										<label class="formButton"><input type="radio"
											name="isShow" value="1" checked="checked" /> <span>显示</span></label>
										<label class="formButton"><input type="radio"
											name="isShow" value="0" /> <span>隐藏</span></label>
									</c:if>
									<c:if test="${menu.isShow eq '0'}">
										<label class="formButton"><input type="radio"
											name="isShow" value="1" /> <span>显示</span></label>
										<label class="formButton"><input type="radio"
											name="isShow" value="0" checked="checked" /> <span>隐藏</span></label>
									</c:if>
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-3 control-label no-padding-right"
									for="form-field-1"> 权限标识 </label>
								<div class="col-sm-9">
									<form:input path="permission" htmlEscape="false"
										cssClass="input-xlarge" maxlength="100"
										placeholder="请输入菜单权限标识，非必需" />
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
