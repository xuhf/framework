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
				<button class="btn btn-primary">添加用户</button>
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
												<div
													class="visible-md visible-lg hidden-sm hidden-xs btn-group">
													<button class="btn btn-xs btn-success">
														<i class="icon-ok bigger-120"></i>
													</button>

													<button class="btn btn-xs btn-info">
														<i class="icon-edit bigger-120"></i>
													</button>

													<button class="btn btn-xs btn-danger">
														<i class="icon-trash bigger-120"></i>
													</button>

													<button class="btn btn-xs btn-warning">
														<i class="icon-flag bigger-120"></i>
													</button>
												</div>

												<div class="visible-xs visible-sm hidden-md hidden-lg">
													<div class="inline position-relative">
														<button class="btn btn-minier btn-primary dropdown-toggle"
															data-toggle="dropdown">
															<i class="icon-cog icon-only bigger-110"></i>
														</button>
														<ul
															class="dropdown-menu dropdown-only-icon dropdown-yellow pull-right dropdown-caret dropdown-close">
															<li><a href="#" class="tooltip-info"
																data-rel="tooltip" title="View"> <span class="blue">
																		<i class="icon-zoom-in bigger-120"></i>
																</span>
															</a></li>
															<li><a href="#" class="tooltip-success"
																data-rel="tooltip" title="Edit"> <span class="green">
																		<i class="icon-edit bigger-120"></i>
																</span>
															</a></li>
															<li><a href="#" class="tooltip-error"
																data-rel="tooltip" title="Delete"> <span class="red">
																		<i class="icon-trash bigger-120"></i>
																</span>
															</a></li>
														</ul>
													</div>
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
		$(function() {
			$("li[data-menu='user']").addClass("active");
		});
		function page(n, s) {
			$("#pageNo").val(n);
			$("#pageSize").val(s);
			$("#searchForm").submit();
			return false;
		};
	</script>
</body>
</html>
