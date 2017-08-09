<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<jsp:include page="web-plugin-head.jsp" />
<jsp:include page="web-plugin-head-kkpager.jsp" />
<title>album-manage</title>
</head>
<body>
		<jsp:include page="manage-nav-bar.jsp"/>
		<div class="row"> 
	<div class="col-sm-3 col-md-3 col-lg-2" >
		<jsp:include page="manage-left-menu.jsp"/>
	</div>
		<div class="col-sm-8 col-md-8 col-lg-9" >
		<div class="page-header">
			<span class="glyphicon glyphicon-map-marker"></span>&nbsp;<a class="mshome">后台管理</a>&nbsp;>&nbsp;相册管理
		</div>
			<div class="alert alert-info">  
			 <strong>提示:<br/>相册删除(关联的相册评论将自动删除)、修改操作不可恢复,请谨慎操作!
			 </strong>
		 </div>
<table class="table table-bordered table-hover">
  <thead>
    <tr>
      <th>序号</th>
      <th>相册集</th>
      <th>图片数量</th>
      <th>创建日期</th>
    </tr>
  </thead>
  <tbody>
  <c:forEach begin="0" end="6" step="1" var="p">
    <tr>
      <td><span class='id'>${p}</span></td>
      <td>风景集</td>
      <td>${p+1}${p}</td>
      <td>2017年7月13日</td>
    </tr>
  </c:forEach>
  </tbody>
</table>
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
		</div><!-- close row -->
	</div>
	</div><!-- close row -->
	<jsp:include page="web-plugin-footer.jsp" />
</body>
</html>