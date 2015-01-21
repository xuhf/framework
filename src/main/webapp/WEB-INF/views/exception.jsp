<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<!DOCTYPE html>
<html style="overflow-x: hidden; overflow-y: auto;">
<head>
<meta charset="utf-8">
</head>
<body>
	<div class="breadcrumbs" id="breadcrumbs">
		<ul class="breadcrumb">
			<li><i class="icon-home home-icon"></i> <a
				href="<c:url value='/'/>">首页</a></li>
			<li class="active">系统异常</li>
		</ul>
		<div class="nav-search" id="nav-search">
			<form class="form-search">
				<span class="input-icon"> <input type="text"
					placeholder="Search ..." class="nav-search-input"
					id="nav-search-input" autocomplete="off" /> <i
					class="icon-search nav-search-icon"></i>
				</span>
			</form>
		</div>
	</div>

	<div class="page-content">
		<div class="row">
			<div class="col-xs-12">
				<!-- PAGE CONTENT BEGINS -->
				<div class="error-container">
					<div class="well">
						<h1 class="grey lighter smaller">
							<span class="blue bigger-125"> <i class="icon-random"></i>
								500
							</span> 系统异常，请您稍候再试。
						</h1>
						<hr />
						<h3 class="lighter smaller">
							我们正在努力的 <i class="icon-wrench icon-animated-wrench bigger-125"></i>
							修复它。
						</h3>

						<div class="center">
							<a href="javascript:window.history.go(-1)" class="btn btn-grey">
								<i class="icon-arrow-left"></i> 回到上一页
							</a> <a href="<c:url value='/'/>" class="btn btn-primary"> <i
								class="icon-dashboard"></i> 前往首页
							</a>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>