<%
	//页面顶部的导航栏
%>
<%@page pageEncoding="UTF-8"%>
<nav class="navbar navbar-default" role="navigation">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="#"><font size="5">BlogMS-Demo</font></a>
    </div>
    <ul class="nav navbar-nav navbar-left">
      <li><a href="#"> 注册用户<span class="badge">6</span></a></li>
      <li><a href="#"> 文章总数<span class="badge">11</span></a></li>
    </ul>
    <ul class="nav navbar-nav navbar-right">
      <li><a href="#" data-toggle="modal" data-target="#admin-login"><span class="glyphicon glyphicon-user"></span> 管理员登录</a></li>
    </ul>
  </div>
</nav>
<%
	//管理员登录的模态框	
%>
<div class="modal fade" id="admin-login" tabindex="-1" role="dialog" >
  <div class="modal-dialog modal-sm" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span></button>
        <h4 class="modal-title" ><span class="glyphicon glyphicon-user"></span>管理员登录</h4>
      </div><!-- close modal-header -->
      <div class="modal-body">
        <form action="user-k.jsp" method="post">
          <div class="form-group">
          	账号:
            <input type="text" class="form-control" id="admin-account" name="admin-account">
          </div><!-- close form-group -->
          <div class="form-group">
           	密码:
            <input type="text" class="form-control" id="admin-password" name="admin-password">
          </div><!-- close form-group -->
           <div class="modal-footer">
         	 <button type="submit" class="btn btn-default" >登录</button>
         	 <button type="submit" class="btn btn-default" data-dismiss="modal">取消</button>
	      </div><!-- close modal-footer -->
        </form>
      </div><!-- close modal-body -->
    </div><!-- close modal-content -->
  </div><!-- close modal-dialog modal-sm -->
</div><!-- close modal fade -->
<%
	//删除模态框  
%>
<div class="modal fade" id="delete-data" tabindex="-1" role="dialog" >
  <div class="modal-dialog modal-dialog-center modal-sm" role="document">
    <div class="modal-content">
      <div class="modal-header">
        <h4 class="modal-title" ><span class="glyphicon glyphicon-warning-sign"></span>系统提示</h4>
      </div><!-- close modal-header -->
      <div class="modal-body">
	        <div class="form-group">
	        	<font size='3'>本次操作将删除[&nbsp;<font id='delete-count' color='red' size='3'>??</font>&nbsp;]条数据,请确定操作</font>
	        </div>
           <div class="modal-footer">
         	 <button type="submit" class="btn btn-default" >确定</button>
         	 <button type="button" class="btn btn-default" data-dismiss="modal">取消</button>
	      </div><!-- close modal-footer -->
      </div><!-- close modal-body -->
    </div><!-- close modal-content -->
  </div><!-- close modal-dialog modal-sm -->
</div><!-- close modal fade -->