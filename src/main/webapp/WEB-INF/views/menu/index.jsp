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
			<li class="active">菜单管理</li>
		</ul>
	</div>
	<div class="page-content">
		<div class="page-header">
			<h1>
				菜单管理<small> <i class="icon-double-angle-right"></i> 菜单列表
				</small>
			</h1>
		</div>
		<div class="row">
			<div class="col-xs-12">
				<div class="row">
					<div class="col-xs-12">
						<a class="btn btn-primary" href='<c:url value="/menu/new"/>'>添加菜单</a>
					</div>
				</div>
				<div class="hr hr-dotted"></div>
				<tags:message message="${message.message}"
					success="${message.success }" />
				<form action="${ctx }/menu/sort" method="post">
					<div class="row">
						<div class="col-xs-12">
							<div class="table-responsive">
								<table id="treeTable"
									class="table table-striped table-bordered table-hover">
									<thead>
										<tr>
											<th>名称</th>
											<th>链接</th>
											<th>排序</th>
											<th>可见</th>
											<th>权限标识</th>
											<th>操作</th>
										</tr>
									</thead>
									<tbody>
										<c:forEach items="${list}" var="menu">
											<tr id="${menu.id}"
												pId="${menu.parent.id ne '1' ? menu.parent.id : '0'}">
												<td><i
													class="icon-${not empty menu.icon?menu.icon:' hide'}"></i>
													<a href="<c:url value="/menu/edit/${menu.id }"/>">${menu.name}</a></td>
												<td>${menu.href}</td>
												<td style="text-align: center;"><input type="hidden"
													name="ids" value="${menu.id}" /> <input name="sorts"
													type="text" value="${menu.sort}"
													onkeyup="this.value=this.value.replace(/[^\d]/g,'')"
													onafterpaste="this.value=this.value.replace(/[^\d]/g,'')"
													style="text-align: center;" /></td>
												<td>${menu.isShow eq '1'?'显示':'隐藏'}</td>
												<td>${menu.permission}</td>
												<td>
													<div
														class="visible-md visible-lg hidden-sm hidden-xs btn-group">
														<a class="btn btn-xs btn-info"
															href='<c:url value="/menu/parent/${menu.id }"/>'> <i
															class="icon-plus bigger-120"></i>
														</a> <a class="btn btn-xs btn-info"
															href='<c:url value="/menu/edit/${menu.id }"/>'> <i
															class="icon-edit bigger-120"></i>
														</a> <a href='<c:url value="/menu/delete/${menu.id }"/>'
															data-role='jbox-confirm' data-confirm="要删除该菜单及所有子菜单项吗？"
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
							<div class="hr hr-dotted"></div>
							<div class="row">
								<div class="col-xs-12">
									<button class="btn btn-lg btn-success pull-right">
										<i class="icon-ok"></i> 保存菜单排序
									</button>
								</div>
							</div>
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>
</body>
</html>
