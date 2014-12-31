<%@ page contentType="text/html;charset=UTF-8"%>
<%@ include file="/WEB-INF/views/include/taglib.jsp"%>
<!DOCTYPE html>
<html lang="en" style="overflow: hidden;">
<head>
<meta charset="utf-8">
<script type="text/javascript">
	$(function() {
		$("#name").focus();
		$("#roleForm").validate({
			submitHandler: function(form){
				var ids = [], nodes = tree.getCheckedNodes(true);
				for(var i=0; i<nodes.length; i++) {
					ids.push(nodes[i].id);
				}
				$("#menuIds").val(ids);
				var ids2 = [], nodes2 = tree2.getCheckedNodes(true);
				for(var i=0; i<nodes2.length; i++) {
					ids2.push(nodes2[i].id);
				}
				form.submit();
			}
		});
		var setting = {
		    check: {
		        enable: true,
		        nocheckInherit: true
		    },
		    view: {
		        selectedMulti: false
		    },
		    data: {
		        simpleData: {
		            enable: true
		        }
		    },
		    callback: {
		        beforeClick: function(id,node) {
		            tree.checkNode(node, !node.checked,true,true);
		            return false;
		        }
		    }
		};
		// 用户-菜单
		var zNodes=[
				<c:forEach items="${menuList}" var="menu">{id:'${menu.id}', pId:'${not empty menu.parent.id?menu.parent.id:0}', name:"${menu.name}"},
		        </c:forEach>];
		// 初始化树结构
		var tree = $.fn.zTree.init($("#menuTree"), setting, zNodes);
		// 默认选择节点
		var ids = "${role.menuIds}".split(",");
		for(var i=0; i<ids.length; i++) {
			var node = tree.getNodeByParam("id", ids[i]);
			try{
				tree.checkNode(node, true, false);
			}catch(e){
			}
		}
		// 默认展开全部节点
		tree.expandAll(true);
	});
</script>
<style type="text/css">
ul.ztree {
	margin-top: 10px;
	border: 1px solid #617775;
	background: #f0f6e4;
	width: 270px;
	height: 360px;
	overflow-y: scroll;
	overflow-x: auto;
}
</style>
</head>
<body>
	<div class="breadcrumbs" id="breadcrumbs">
		<ul class="breadcrumb">
			<li><i class="icon-home home-icon"></i> <a href="${ctx}">首页</a></li>
			<li class="active">角色管理</li>
		</ul>
	</div>
	<div class="page-content">
		<div class="page-header">
			<h1>
				角色管理<small> <i class="icon-double-angle-right"></i> 添加
				</small>
			</h1>
		</div>
		<div class="row">
			<div class="col-xs-12">
				<a class="btn btn-primary" href='<c:url value="/role"/>'>返回</a>
				<div class="hr hr-dotted"></div>
				<tags:message message="${message.message}"
					success="${message.success }" />
				<div class="row">
					<div class="col-xs-12">
						<form:form id="roleForm" action="${ctx }/role/save"
							cssClass="form-horizontal" role="form" method="post"
							modelAttribute="role">
							<div class="form-group">
								<label class="col-sm-3 control-label no-padding-right"
									for="form-field-1"> 角色名称 </label>
								<div class="col-sm-9">
									<form:input path="name" cssClass="input-xlarge required"
										minlength="2" maxlength="20" value="${role.name }"
										placeholder="请输入角色名称" />
								</div>
							</div>
							<div class="form-group">
								<label class="col-sm-3 control-label no-padding-right"
									for="form-field-1"> 角色授权 </label>
								<div class="col-sm-9">
									<div class="">
										<ul id="menuTree" class="ztree"></ul>
									</div>
									<form:hidden path="menuIds" />
								</div>
							</div>
							<div class="clearfix form-actions">
								<div class="col-md-offset-3 col-md-9">
									<form:button class="btn btn-info" type="submit">
										<i class="icon-ok bigger-110"></i> 提交
									</form:button>
									&nbsp;&nbsp;&nbsp;&nbsp;
									<form:button class="btn" type="reset">
										<i class="icon-undo bigger-110"></i> 重置
									</form:button>
								</div>
							</div>
						</form:form>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>
