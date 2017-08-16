<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<jsp:include page="../p4jsc/web-plugin-head.jsp" />
<jsp:include page="../p4jsc/web-plugin-head-kkpager.jsp" />
<script type="text/javascript" src="<%=request.getContextPath()%>/ckeditor/ckeditor.js"></script>
<title>daily-manage</title>
</head>
<body>
		<jsp:include page="manage-nav-bar.jsp"/>
		<div class="row"> 
	<div class="col-sm-3 col-md-3 col-lg-2" >
		<jsp:include page="manage-left-menu.jsp"/>
	</div>
		<div class="col-sm-8 col-md-8 col-lg-9" >
	<div class="page-header">
			<span class="glyphicon glyphicon-map-marker"></span>&nbsp;<a class="mshome">后台管理</a>&nbsp;>&nbsp;日志管理
		</div>
		<div class="alert alert-info">  
			 <strong>提示:<br/>日志删除、修改操作不可恢复,请谨慎操作!
			 </strong>
		 </div>
<table class="table table-bordered table-hover">
  <thead>
    <tr>
      <th>序号</th>
      <th>日志内容</th>
      <th>发布时间</th>
    </tr>
  </thead>
  <tbody>
  <c:forEach items="${dailys}" var="daily">
    <tr>
      <td><span class='id'>${daily.id}</span></td>
      <td>${daily.content}</td>
      <td>${daily.time}</td>
    </tr>
  </c:forEach>
  </tbody>
</table>
	<div class="daily-edit" style="display: none">
				<form id="daily-edit-form" action="" method="post" enctype="multipart/form-data">
				<input name="id" type="hidden" value="">
					<div class="row">
						<div class="col-sm-9 col-md-10" >
							<textarea id='content' name='content'></textarea>
							<script type="text/javascript">CKEDITOR.replace('content');</script>
						</div><!--close ckeditor -->
						<div class="col-sm-1 col-md-2" >
							<button type="submit" class="btn btn-info col-xs-offset-5 col-sm-offset-2 col-md-offset-5">提交</button>
							<button id="exit-btn" class="btn btn-default col-xs-offset-5 col-sm-offset-2 col-md-offset-5">退出</button>			
						</div>
				</div><!-- close row -->
			</form>	
		<br/>
	</div>
	<div class="row">
	<div class="col-sm-5 col-md-5" >
		<button class="btn btn-default" id="check-all"><span class="glyphicon glyphicon-th-large" ></span>全选</button>
		<button class="btn btn-default" id="invert-selection"><span class="glyphicon glyphicon-retweet" ></span>反选</button>
		<button class="btn btn-default" id="add-btn"><span class="glyphicon glyphicon-plus" ></span>新增</button>
		<button class="btn btn-default" id="edit-btn"><span class="glyphicon glyphicon-pencil" ></span>编辑</button>
		<button class="btn btn-default" id="delete-btn" data-toggle="modal" data-target="#delete-data"><span class="glyphicon glyphicon-remove" ></span>删除</button>
	</div>
	<div class="col-sm-7 col-md-7">
		<kkpager data-page="${nowPage}" data-max="${maxPage}">
					<div id="kkpager"></div>  
			</div>
		</div><!-- close row2 -->
	</div>
	</div><!-- close row1 -->
		<jsp:include page="../p4jsc/web-plugin-footer.jsp" />
		<script type="text/javascript" src="<%=request.getContextPath()%>/js/bms-daily.js"></script>
</body>
</html>