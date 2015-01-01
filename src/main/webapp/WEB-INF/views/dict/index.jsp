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
			<li class="active">数据字典管理</li>
		</ul>
	</div>
	<div class="page-content">
		<div class="page-header">
			<h1>
				数据字典管理<small> <i class="icon-double-angle-right"></i> 数据字典列表
				</small>
			</h1>
		</div>
		<div class="row">
			<div class="col-xs-12">
				<div class="row">
					<div class="col-xs-12">
						<a class="btn btn-primary" href='<c:url value="/dict/new"/>'>添加数据字典</a>
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
										<th>数据字典名称</th>
										<th>数据字典编码</th>
										<th>操作</th>
									</tr>
								</thead>
								<tbody>
									<c:forEach items="${page.list }" var="dictHeader">
										<tr>
											<td><a
												href="<c:url value='/dict/show/${dictHeader.id }'/>">${dictHeader.name }</a></td>
											<td>${dictHeader.name }</td>
											<td>
												<div
													class="visible-md visible-lg hidden-sm hidden-xs btn-group">
													<a class="btn btn-xs btn-info"
														href='<c:url value="/dict/edit/${dictHeader.id }"/>'>
														<i class="icon-edit bigger-120"></i>
													</a> <a href='<c:url value="/dict/delete/${dictHeader.id }"/>'
														data-role='jbox-confirm' data-confirm="您确认删除此数据字典及数据字典条目么？"
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
	<form:form id="searchForm" action="${ctx }/dict" method="post" class="">
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
