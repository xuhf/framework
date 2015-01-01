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
				数据字典管理<small> <i class="icon-double-angle-right"></i> 数据字典 ${dictHeader.name } 条目
				</small>
			</h1>
		</div>
		<div class="row">
			<div class="col-xs-12">
				<a class="btn btn-primary" href='<c:url value="/dict"/>'>返回数据字典列表</a>
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
										<th>数据字典条目名称</th>
										<th>数据字典条目编码</th>
										<th>操作</th>
									</tr>
								</thead>
								<tbody>
									<c:forEach items="${dictHeader.items }" var="dictItem">
										<tr>
											<td>${dictItem.name }</td>
											<td>${dictItem.value }</td>
											<td>
												<div
													class="visible-md visible-lg hidden-sm hidden-xs btn-group">
													<a class="btn btn-xs btn-info"
														href='<c:url value="/dict/item/edit/${dictItem.id }"/>'>
														<i class="icon-edit bigger-120"></i>
													</a> <a
														href='<c:url value="/dict/item/delete/${dictItem.id }"/>'
														data-role='jbox-confirm' data-confirm="您确认删除此数据字典条目么？"
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
				<div class="hr hr-dotted"></div>
				<a class="btn btn-primary pull-right"
					href='<c:url value="/dict/${dictHeader.id}/item/new"/>'>新增数据字典条目</a>
			</div>
		</div>
	</div>
</body>
</html>
