<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ page
	import="org.apache.shiro.web.filter.authc.FormAuthenticationFilter"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<html lang="en" style="overflow: hidden;">
<head>
<link rel="stylesheet" href="${ctx }/assets/css/bootstrap.min.css" />
<link rel="stylesheet" href="${ctx }/assets/css/ace.min.css" />
<link rel="stylesheet" href="${ctx }/assets/css/ace-rtl.min.css" />
<link rel="stylesheet" href="${ctx }/assets/css/bootstrap.min.css" />
<link rel="stylesheet" href="${ctx }/assets/css/font-awesome.min.css" />
<script src="${ctx }/assets/js/jquery-2.1.1.js"></script>
<script src="${ctx }/assets/js/bootstrap.min.js"></script>
<script src="${ctx }/assets/js/jquery.validate.min.js"></script>
<script src="${ctx }/assets/js/jquery.validate.CN.js"></script>
<style type="text/css">
label.error {
	color: red;
}
</style>
<meta charset="utf-8">
<title>BaseFramework后台管理系统|登录</title>
</head>
<%
	String error = (String) request
			.getAttribute(FormAuthenticationFilter.DEFAULT_ERROR_KEY_ATTRIBUTE_NAME);
%>
<body class="login-layout">
	<div class="main-container">
		<div class="main-content">
			<div class="row">
				<div class="col-sm-10 col-sm-offset-1">
					<div class="login-container">
						<div class="center">
							<h1>
								<i class="icon-leaf green"></i> <span class="red">BaseFramework</span>
							</h1>
							<h4 class="blue">
								<a href="http://www.isharec.com" target="_blank">http://www.isharec.com</a>
							</h4>
						</div>
						<div class="space-6"></div>
						<div class="position-relative">
							<div class="row <%=error == null ? "hide" : ""%>">
								<div class="col-xs-12">
									<div class="alert alert-block alert-danger">
										<button type="button" class="close" data-dismiss="alert">
											<i class="icon-remove"></i>
										</button>
										用户或密码错误，请重试。
									</div>
								</div>
							</div>
							<div id="login-box"
								class="login-box visible widget-box no-border">
								<div class="widget-body">
									<div class="widget-main">
										<h4 class="header blue lighter bigger">
											<i class="icon-coffee green"></i> 请输入您的用户名/密码
										</h4>
										<div class="space-6"></div>
										<form action="${ctx }/login" method="post">
											<fieldset>
												<label class="block clearfix"> <span
													class="block input-icon input-icon-right"> <input
														type="text" class="form-control" name="username"
														placeholder="请输入用户名" value="${username}"/> <i class="icon-user"></i>
												</span>
												</label> <label class="block clearfix"> <span
													class="block input-icon input-icon-right"> <input
														type="password" name="password" class="form-control"
														placeholder="请输入密码" /> <i class="icon-lock"></i>
												</span>
												</label>
												<div class="space"></div>
												<div class="clearfix">
													<label class="inline"> <input type="checkbox"
														class="ace" name="rememberMe" /> <span class="lbl">
															记住我</span>
													</label>
													<button type="submit"
														class="width-35 pull-right btn btn-sm btn-primary">
														<i class="icon-key"></i> 登录
													</button>
												</div>
												<div class="space-4"></div>
											</fieldset>
										</form>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
	<script type="text/javascript">
		$(function() {
			$("form").validate({
				rules : {
					username : "required",
					password : {
						required : true,
						minlength : 6
					}
				},
				messages : {
					username : "请输入用户名",
					password : {
						required : "请输入密码",
						minlength : jQuery.format("密码不能小于{0}个字 符")
					}
				}
			});
		});
	</script>
</body>
</html>
