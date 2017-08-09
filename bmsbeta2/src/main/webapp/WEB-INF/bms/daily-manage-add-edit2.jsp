<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<jsp:include page="web-plugin-head.jsp" />
<script type="text/javascript" src="<%=request.getContextPath()%>/ckeditor/ckeditor.js"></script>
<title>article-manage</title>
</head>
<body>
		<jsp:include page="manage-nav-bar.jsp"/>
	<div class="row">
	<div class="col-sm-3 col-md-3 col-lg-2" >
		<jsp:include page="manage-left-menu.jsp"/>
	</div>
	<div class="col-sm-8 col-md-8 col-lg-9" >
	<div class="page-header">
		<span class="glyphicon glyphicon-map-marker"></span>&nbsp;<a class="mshome">后台管理</a>&nbsp;>&nbsp;<a class="retreat">日志管理</a>&nbsp;>&nbsp;日志编辑&发布
	</div>
	<!-- ckeditor -->
		<div class="col-sm-1 col-md-1" ></div>
			<div class="col-sm-10 col-md-9" >
			<form action="${!empty daily.id?'update':'add'}" method="post" enctype="multipart/form-data">
				<textarea name='daily-content'></textarea>
				<script type="text/javascript">CKEDITOR.replace('daily-content');</script>
				<button type="submit" class="btn btn-default col-xs-offset-5 col-sm-offset-5 col-md-offset-5">${!empty daily.id?'保存修改':'发布'}</button>
`			</form>	
				</div>
			<div class="col-sm-1 col-md-2" >
				
			</div>
	<!--close ckeditor -->
	</div>
	</div><!-- close row -->
		<jsp:include page="web-plugin-footer.jsp" />
</body>
</html>