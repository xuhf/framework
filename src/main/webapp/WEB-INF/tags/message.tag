<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ attribute name="message" type="java.lang.String" required="true"
	description="消息内容"%>
<%@ attribute name="success" type="java.lang.Boolean"
	description="消息类型：info、success、warning、error、loading"%>
<c:if test="${not empty message}">
	<c:if test="${success == false }">
		<div class="alert alert-block alert-danger center" id="messageBox">
			<button type="button" class="close" data-dismiss="alert">
				<i class="icon-remove"></i>
			</button>
			<i class="icon-remove"></i> ${message }
		</div>
	</c:if>
	<c:if test="${success == true }">
		<div class="alert alert-block alert-success center">
			<button type="button" class="close" data-dismiss="alert">
				<i class="icon-remove"></i>
			</button>
			<i class="icon-ok green"></i> ${message }
		</div>
	</c:if>
	<script type="text/javascript">
		(function() {
			setTimeout('$("#messageBox").remove();', 3000);
		}());
	</script>
</c:if>