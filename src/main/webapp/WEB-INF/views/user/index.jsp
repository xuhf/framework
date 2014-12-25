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
				用户管理<small> <i class="icon-double-angle-right"></i> 查看
				</small>
			</h1>
		</div>
		<div class="row">
			<div class="col-xs-12">
				<a class="btn btn-primary" href='<c:url value="/user/new"/>'>添加用户</a>
				<div class="hr hr32 hr-dotted"></div>
				<div class="row">
					<div class="col-xs-12">
						<div class="table-responsive">
							<table id="sample-table-1"
								class="table table-striped table-bordered table-hover">
								<thead>
									<tr>
										<th class="center"><label> <input type="checkbox"
												class="ace" /> <span class="lbl"></span>
										</label></th>
										<th>用户名</th>
										<th>昵称</th>
										<th>Email</th>
										<th>电话</th>
										<th>操作</th>
									</tr>
								</thead>

								<tbody>
									<c:forEach items="${page.list }" var="user">
										<tr>
											<td class="center"><label> <input
													type="checkbox" class="ace" /> <span class="lbl"></span>
											</label></td>

											<td><a href="#">${user.loginName }</a></td>
											<td>${user.name }</td>
											<td>${user.email }</td>
											<td>${user.phone }</td>
											<td>
												<div class="visible-md visible-lg hidden-sm hidden-xs btn-group">
													<a class="btn btn-xs btn-info" href='<c:url value="/user/edit/${user.id }"/>'>
														<i class="icon-edit bigger-120"></i>
													</a>
													<a class="btn btn-xs btn-danger">
														<i class="icon-trash bigger-120"></i>
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
	<form:form id="searchForm" action="${ctx}/user" method="post" class="">
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
