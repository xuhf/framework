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
			<li><i class="icon-home home-icon"></i> <a
				href="<c:url value="/"/>">首页</a></li>
			<li class="active">系统参数管理</li>
		</ul>
	</div>
	<div class="page-content">
		<div class="page-header">
			<h1>
				系统参数管理<small> <i class="icon-double-angle-right"></i> 系统参数列表
				</small>
			</h1>
		</div>
		<div class="row">
			<div class="col-xs-12">
				<div class="row">
					<div class="col-xs-12">
						<a class="btn btn-primary" href='<c:url value="/parameter/new"/>'>添加系统参数</a>
					</div>
				</div>
				<div class="hr hr-dotted"></div>
				<tags:message message="${message.message}"
					success="${message.success }" />
				<div class="row">
					<div class="col-xs-12">
						<div class="table-responsive">
							<table id="sample-table-1"
								class="table table-striped table-bordered table-hover">
								<thead>
									<tr>
										<th>参数名称</th>
										<th>参数值</th>
										<th>参数编码</th>
										<th>备注</th>
										<th>操作</th>
									</tr>
								</thead>
								<tbody>
									<c:forEach items="${page.list }" var="parameter">
										<tr>
											<td><a
												href="<c:url value='/parameter/show/${parameter.id }'/>">${parameter.name }</a></td>
											<td>${parameter.value }</td>
											<td>${parameter.code }</td>
											<td>${parameter.remarks }</td>
											<td>
												<div
													class="visible-md visible-lg hidden-sm hidden-xs btn-group">
													<a class="btn btn-xs btn-info"
														href='<c:url value="/parameter/edit/${parameter.id }"/>'>
														<i class="icon-edit bigger-120"></i>
													</a> <a
														href='<c:url value="/parameter/delete/${parameter.id }"/>'
														data-role='jbox-confirm' data-confirm="您确认删除此系统参数项么？"
														class="btn btn-xs btn-danger"> <i
														class="icon-trash bigger-120"></i>
													</a>
												</div>
											</td>
										</tr>
									</c:forEach>
								</tbody>
							</table>
						</div>
						<div class="pagination">${page}</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<form:form id="searchForm" action="${ctx }/parameter" method="post" class="">
		<input id="pageNo" name="pageNo" type="hidden" value="${page.pageNo}" />
		<input id="pageSize" name="pageSize" type="hidden"
			value="${page.pageSize}" />
		<input id="orderBy" name="orderBy" type="hidden"
			value="${page.orderBy}" />
	</form:form>
	<script type="text/javascript">
		function page(n, s) {
			$("#pageNo").val(n);
			$("#pageSize").val(s);
			$("#searchForm").submit();
			return false;
		};
	</script>
</body>
</html>
