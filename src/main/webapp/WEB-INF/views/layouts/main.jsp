<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<!DOCTYPE html>
<html style="overflow-x: hidden; overflow-y: auto;">
<head>
<title>
<%-- <sitemesh:write property='title'/>  --%>
BaseFramework|http://www.isharec.com
</title>
<%@include file="/WEB-INF/views/include/header.jsp"%>
<sitemesh:write property='head' />
</head>
<body>
	<%@ include file="/WEB-INF/views/include/top.jsp"%>
	<div class="main-container" id="main-container">
		<script type="text/javascript">
			try {
				ace.settings.check('main-container', 'fixed')
			} catch (e) {
			}
		</script>

		<div class="main-container-inner">
			<a class="menu-toggler" id="menu-toggler" href="#"> <span
				class="menu-text"></span>
			</a>
			<%@ include file="/WEB-INF/views/include/menu.jsp"%>
			<div class="main-content">
				<sitemesh:write property='body' />
			</div>
			<%@ include file="/WEB-INF/views/include/settings.jsp"%>
		</div>
		<a href="#" id="btn-scroll-up"
			class="btn-scroll-up btn btn-sm btn-inverse"> <i
			class="icon-double-angle-up icon-only bigger-110"></i>
		</a>
	</div>
</body>
</html>
