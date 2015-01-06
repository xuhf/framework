<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<!DOCTYPE html>
<html lang="en" style="overflow: hidden;">
<head>
<meta charset="utf-8">
<script type="text/javascript">
	$(function(){
		$("#treeTable").treeTable({expandLevel : 3});
	});
</script>
</head>
<body>
	<div class="breadcrumbs" id="breadcrumbs">
		<ul class="breadcrumb">
			<li><i class="icon-home home-icon"></i> <a
				href="<c:url value="/"/>">首页</a></li>
			<li class="active">部门管理</li>
		</ul>
	</div>
	<div class="page-content">
		<div class="page-header">
			<h1>
				部门管理<small> <i class="icon-double-angle-right"></i> 部门列表
				</small>
			</h1>
		</div>
		<div class="row">
			<div class="col-xs-12">
				<div class="row">
					<div class="col-xs-12">
						<a class="btn btn-primary" href='<c:url value="/department/new"/>'>添加部门</a>
					</div>
				</div>
				<div class="hr hr-dotted"></div>
				<tags:message message="${message.message}"
					success="${message.success }" />
				<div class="row">
					<div class="col-xs-12">
						<div class="table-responsive">
							<table id="treeTable"
								class="table table-striped table-bordered table-hover">
								<thead>
									<tr>
										<th>名称</th>
										<th>操作</th>
									</tr>
								</thead>
								<tbody>
									<c:forEach items="${list}" var="department">
										<tr id="${department.id}"
											pId="${department.parent.id}">
											<td>
												<a href="<c:url value="/department/show/${department.id }"/>">${department.name}</a>
											</td>
											<td>
												<div
													class="visible-md visible-lg hidden-sm hidden-xs btn-group">
													<a class="btn btn-xs btn-info"
														href='<c:url value="/department/parent/${department.id }"/>'>
														<i class="icon-save bigger-120"></i>
													</a> <a class="btn btn-xs btn-info"
														href='<c:url value="/department/edit/${department.id }"/>'>
														<i class="icon-edit bigger-120"></i>
													</a> <a
														href='<c:url value="/department/delete/${department.id }"/>'
														data-role='jbox-confirm' data-confirm="您确认删除该部门吗？"
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
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>
