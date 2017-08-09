<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" href="<%=request.getContextPath()%>/bootstrap/datetimepicker/css/bootstrap-datetimepicker.css">
<title>user-manage</title>
<jsp:include page="web-plugin-head.jsp" />
<script type="text/javascript" src="<%=request.getContextPath()%>/bootstrap/datetimepicker/js/moment-with-locales.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/bootstrap/datetimepicker/js/bootstrap-datetimepicker.js"></script>
<script type="text/javascript" src="<%=request.getContextPath()%>/bootstrap/showpassword/bootstrap-show-password.js"></script>
</head>
<body>
		<jsp:include page="manage-nav-bar.jsp"/>
<div class="row">
	<div class="col-sm-3 col-lg-2" >
		<jsp:include page="manage-left-menu.jsp"/>
	</div>
	<div class="col-sm-7 col-md-7 col-lg-9" >
<div class="page-header">
	<span class="glyphicon glyphicon-map-marker"></span>&nbsp;<a class="mshome">后台管理</a>&nbsp;>&nbsp;<a class="retreat">用户管理</a>&nbsp;>&nbsp;用户资料编辑
</div>
<form class="form-horizontal" action="${!empty user.id?'update':'add'}" method="post">
  <div class="form-group">
    <label for="user-id" class="col-xs-4 control-label">用户ID</label>
    <div class="col-xs-6">
      <input type="text" class="form-control" id="user-id" name="id" value="${user.id}" placeholder="用户ID展示" readonly/>
    </div>
  </div>
  <div class="form-group">
    <label for="user-name" class="col-xs-4 control-label">用户组名称</label>
    <div class="col-xs-6">
      <input type="text" class="form-control" id="user-name" name="name" value="${user.name}" placeholder="用户组名称展示" />
    </div>
  </div>
  <div class="form-group">
    <label for="user-account" class="col-xs-4 control-label">用户账号</label>
    <div class="col-xs-6">
      <input type="text" class="form-control" id="user-account" name="account"  value="${user.account}" placeholder="用户账号展示" />
    </div>
  </div>
  <div class="form-group">
    <label for="user-password" class="col-xs-4 control-label">用户密码</label>
		<div class="col-xs-6">
		  <input type="password"  data-toggle="password" data-placement="last" class="form-control" name="password" value="${user.password}"/>
		</div>
  </div>
   <div class="form-group">
	 	 <label for="user-birth" class="col-xs-4 control-label">出生日期</label>
	         <div class='col-xs-6'>
	         <div class='input-group date' id='datetimepicker2'>
	             <input type='text' class="form-control" name="birth" value="${user.birth}"/>
	             <span class="input-group-addon"><span class="glyphicon glyphicon-calendar"></span>
	             </span>
	         </div>
	         </div>
	  </div>
  <div class="form-group">
    <label for="user-hobbies" class="col-xs-4 control-label">爱好</label>
    <div class="col-xs-6">
      <input type="text" class="form-control" id="user-hobbies" placeholder="打篮球，看电视" name="hobby" value="${user.hobby}"/>
    </div>
  </div>
  <div class="form-group">
    <label for="user-homepage" class="col-xs-4 control-label">个人主页</label>
    <div class="col-xs-6">
      <input type="text" class="form-control" id="user-homepage" placeholder="http://www.grzy.com" name="homepage" value="${user.homepage}"/>
    </div>
  </div>
	 
  <div class="form-group">
    <label for="user-contact" class="col-xs-4 control-label">联系方式</label>
    <div class="col-xs-6">
      <input type="text" class="form-control" id="user-contact" placeholder="用户联系方式" name="contact" value="${user.contact}"/>
    </div>
  </div>
  <div class="form-group">
    <label for="user-description" class="col-xs-4 control-label">备注</label>
    <div class="col-xs-6">
      <input type="text" class="form-control" id="user-description" placeholder="这个很懒，什么都没留下？" name="desciption" value="${user.desciption}"/>
    </div>
  </div>
  <div class="form-group">
    <label for="user-cd" class="col-xs-4 control-label">账号创建时间</label>
    <div class="col-xs-6">
      <input type="text" class="form-control"  id="user-cd" placeholder="用户账号创建时间" name="createdate" value="${user.createdate}" readonly/>
    </div>
  </div>
  <div class="form-group">
    <div class="col-md-offset-5 col-sm-offset-5">
      <button type="submit" class="btn btn-default">${!empty user.id?'保存修改':'发布'}</button>
      <button type="button" class="btn btn-default" onclick="self.location=document.referrer">取消编辑</button>
    </div>
  </div>
	</form>
	</div>
	</div><!-- close row -->
	<jsp:include page="web-plugin-footer.jsp" />
	<script>
    $(function() {
    	//datetimepickerSetting
    	$('#datetimepicker2').datetimepicker({
            locale: 'zh-cn',
            dayViewHeaderFormat:'YYYY年M月DD日'
        });
    });
</script>
</body>
</html>