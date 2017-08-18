<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<jsp:include page="../p4jsc/web-plugin-head.jsp"/>
<jsp:include page="../p4jsc/web-plugin-head-kkpager.jsp"/>
<jsp:include page="../p4jsc/web-plugin-head4dui.jsp"/>
<title>index</title>
</head>
<body>

	<div class="row">
		<jsp:include page="nav.jsp"/>
			<div class="col-md-3 col-sm-3"></div>
			<div class="col-xs-12 col-sm-9 col-md-6" style="background: red">
				这是中间部分这是中间部分这是中间部分这是中间部分这是中间部分这是中间部分这是中间部分这是中间部分
			</div>
			<div class="col-md-3 col-sm-0">
				<jsp:include page="aside.jsp"/>
			</div>
	</div>
	<jsp:include page="../p4jsc/web-plugin-footer4dui.jsp"/>
</body>
</html>