<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<jsp:include page="../p4jsc/web-plugin-head.jsp" />
<title>system-setting</title>
</head>
<body>
		<jsp:include page="manage-nav-bar.jsp"/>
		<div class="row"> 
	<div class="col-sm-3 col-md-3 col-lg-2" >
		<jsp:include page="manage-left-menu.jsp"/>
	</div>
		<div class="col-sm-8 col-md-8 col-lg-9" >
		<div class="page-header">
			<span class="glyphicon glyphicon-map-marker"></span>&nbsp;<a class="mshome">后台管理</a>&nbsp;>&nbsp;功能设置
		</div>
			<div class="alert alert-info">  
			 <strong>提示:<br/>功能设置!</strong>
		 	</div>
		 	<form class="form-horizontal" action="set" method="post">
		 	<span><strong>通用设置</strong></span><hr/>
			 	 <div class="form-group">
				    <label for="sys-pagesize" class="col-xs-2 col-md-2 col-sm-4 control-label">每页显示数据条数</label>
				    <div class="col-xs-1 col-md-2 col-sm-2">
				    <select name="pagesize" class="form-control" id="sys-pagesize">
				    <c:forEach begin="5" step="1" end="12" var="ps">
				    	<option value="${ps}">${ps}</option>
				    </c:forEach>
				    </select>
				  </div>
			
			
			</div>
		 	
		 	
		 	
		 	
		 	</form>
		</div><!-- close row -->
	</div><!-- close row -->
	<jsp:include page="../p4jsc/web-plugin-footer.jsp" />
</body>
</html>