<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="../plugin/bootstrap/css/bootstrap.min.css">
<script type="text/javascript" src="../include/js/jquery.min.js"></script>
<script type="text/javascript" src="../plugin/bootstrap/js/bootstrap.min.js"></script>
<title>manage</title>
<style type="text/css">
	/* 自定义部分样式 */
	.panel-group{width:200px;} 
	/* .panel-default > .panel-heading{background-color: #DDDDDD;}
	.panel-default > .panel-heading + .panel-collapse > .panel-body{background-color: #f5f5f5;}
 */	.panel-title{cursor:pointer;}
</style>
</head>
<body>
<!-- 导航栏 -->
<nav class="navbar navbar-default" role="navigation">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="#"><font size="5">后台管理系统Demo</font></a>
    </div>
    <ul class="nav navbar-nav navbar-left">
      <li><a href="#"> 注册用户<span class="badge">6</span></a></li>
      <li><a href="#"> 文章总数<span class="badge">11</span></a></li>
    </ul>
    <ul class="nav navbar-nav navbar-right">
      <li><a href="#"><span class="glyphicon glyphicon-user"></span> 管理员登录</a></li>
    </ul>
  </div>
</nav>
<div class="col-sm-2" 	>
<!-- 左侧菜单 -->
<div class="panel-group" id="accordion">
<div class="panel panel-default">
        <div class="panel-heading">
            <h3 class="panel-title" data-toggle="collapse" data-parent="#accordion" href="#collapse1">
               	<span class="glyphicon glyphicon-user" ></span>&nbsp;&nbsp;用户管理
            </h3>
        </div>
        <div id="collapse1" class="panel-collapse collapse">
            <div class="panel-body">
	            <a href="#" class="list-group-item">
					<span class="glyphicon glyphicon-plus" ></span>&nbsp;&nbsp;新增用户
				</a>
	            <a href="#" class="list-group-item">
					<span class="glyphicon glyphicon-user" ></span>&nbsp;&nbsp;编辑用户
				</a>
				<a href="#" class="list-group-item">
					<span class="glyphicon glyphicon-trash" ></span>&nbsp;&nbsp;删除用户
				</a>
            </div>
        </div>
    </div>
    <div class="panel panel-default">
        <div class="panel-heading">
            <h3 class="panel-title" data-toggle="collapse" data-parent="#accordion" href="#collapse2">
               	<span class="glyphicon glyphicon-book" ></span>&nbsp;&nbsp;文章管理
            </h3>
        </div>
        <div id="collapse2" class="panel-collapse collapse">
            <div class="panel-body">
	            <a href="#" class="list-group-item">
					<span class="glyphicon glyphicon-plus" ></span>&nbsp;&nbsp;发布文章
				</a>
				<a href="#" class="list-group-item">
					<span class="glyphicon glyphicon-edit" ></span>&nbsp;&nbsp;编辑文章
				</a>
				<a href="#" class="list-group-item">
					<span class="glyphicon glyphicon-trash" ></span>&nbsp;&nbsp;删除文章
				</a>
            </div>
        </div>
    </div>
    <div class="panel panel-default">
        <div class="panel-heading">
            <h3 class="panel-title" data-toggle="collapse" data-parent="#accordion" href="#collapse3">
              <span class="glyphicon glyphicon-pencil" ></span>&nbsp;&nbsp;日志管理
            </h3>
        </div>
        <div id="collapse3" class="panel-collapse collapse">
        <div class="panel-body">
           <a href="#" class="list-group-item">
					<span class="glyphicon glyphicon-plus" ></span>&nbsp;&nbsp;发表日志
				</a>
				<a href="#" class="list-group-item">
					<span class="glyphicon glyphicon-trash" ></span>&nbsp;&nbsp;删除日志
				</a>
        </div>
        </div>
    </div>
    <div class="panel panel-default">
        <div class="panel-heading">
            <h3 class="panel-title" data-toggle="collapse" data-parent="#accordion" href="#collapse4" >
               	<span class="glyphicon glyphicon-picture" ></span>&nbsp;&nbsp;相册管理
            </h3>
        </div>
         <div id="collapse4" class="panel-collapse collapse">
	        <div class="panel-body">
	            <a href="#" class="list-group-item">
					<span class="glyphicon glyphicon-open-file" ></span>&nbsp;&nbsp;新建相册
				</a>
	            <a href="#" class="list-group-item">
					<span class="glyphicon glyphicon-picture" ></span>&nbsp;&nbsp;图册管理
				</a>
	            <a href="#" class="list-group-item">
					<span class="glyphicon glyphicon-trash" ></span>&nbsp;&nbsp;移除图册
				</a>
	        </div>
        </div>
    </div>
    <div class="panel panel-default">
        <div class="panel-heading">
            <h3 class="panel-title" data-toggle="collapse" data-parent="#accordion" href="#collapse5">
              <span class="glyphicon glyphicon-comment" ></span>&nbsp;&nbsp;留言板管理
            </h3>
        </div>
        <div id="collapse5" class="panel-collapse collapse">
        <div class="panel-body">
           <a href="#" class="list-group-item">
					<span class="glyphicon glyphicon-trash" ></span>&nbsp;&nbsp;删除留言
			</a>
           <a href="#" class="list-group-item">
					<span class="glyphicon glyphicon-retweet" ></span>&nbsp;&nbsp;恢复留言
			</a>
        </div>
    </div>
    
</div>
<div class="panel panel-default">
        <div class="panel-heading">
            <h3 class="panel-title" data-toggle="collapse" data-parent="#accordion" href="#collapse6">
               	<span class="glyphicon glyphicon-leaf" ></span>&nbsp;&nbsp;系统管理
            </h3>
        </div>
        <div id="collapse6" class="panel-collapse collapse">
            <div class="panel-body">
	            <a href="#" class="list-group-item">
					<span class="glyphicon glyphicon-plus" ></span>&nbsp;&nbsp;系统功能
				</a>
				<a href="#" class="list-group-item">
					<span class="glyphicon glyphicon-edit" ></span>&nbsp;&nbsp;系统功能
				</a>
				<a href="#" class="list-group-item">
					<span class="glyphicon glyphicon-trash" ></span>&nbsp;&nbsp;系统功能
				</a>
            </div>
        </div>
    </div>
<div class="panel panel-default">
        <div class="panel-heading">
            <h3 class="panel-title" data-toggle="collapse" data-parent="#accordion" href="#collapse0">
               	<span class="glyphicon glyphicon-cog" ></span>&nbsp;&nbsp;其他管理
            </h3>
        </div>
        <div id="collapse0" class="panel-collapse collapse">
            <div class="panel-body">
	            <a href="#" class="list-group-item">
					<span class="glyphicon glyphicon-plus" ></span>&nbsp;&nbsp;其他设置管理1
				</a>
				<a href="#" class="list-group-item">
					<span class="glyphicon glyphicon-edit" ></span>&nbsp;&nbsp;其他设置管理2
				</a>
				<a href="#" class="list-group-item">
					<span class="glyphicon glyphicon-trash" ></span>&nbsp;&nbsp;其他设置管理3
				</a>
            </div>
        </div>
    </div>
</div>
	</div>
<div class="col-sm-9" >
	<!-- 右侧表格 -->
<table class="table table-bordered table-hover">
  <caption><span class="glyphicon glyphicon-map-marker"></span>&nbsp;<a href="##">后台管理</a>><a href="##">用户管理</a>><a href="##">用户操作</a></caption>
  <thead>
    <tr>
      <th>序号</th>
      <th>用户ID</th>
      <th>名称</th>
      <th>账号</th>
      <th>密码</th>
      <th>联系方式</th>
      <th>创建日期</th>
      <th>操作</th>
    </tr>
  </thead>
  <tbody>
  <c:forEach begin="0" end="10" step="1">
    <tr>
      <td>Tanmay</td>
      <td>Bangalore</td>
      <td>560001</td>
      <td>Tanmay</td>
      <td>Bangalore</td>
      <td>560001</td>
      <td>560001</td>
      <td><a href="">编辑</a>&nbsp;&nbsp;<a href="">删除</a></td>
    </tr>
  </c:forEach>
  </tbody>
</table>
<div class="col-sm-8" >
</div>
<div class="col-sm-4">
<ul class="pagination">
    <li><a href="#">&laquo;</a></li>
    <li><a href="#">1</a></li>
    <li><a href="#">2</a></li>
    <li><a href="#">3</a></li>
    <li><a href="#">4</a></li>
    <li><a href="#">5</a></li>
    <li><a href="#">&raquo;</a></li>
</ul>
</div>
	</div>
</body>
</html>