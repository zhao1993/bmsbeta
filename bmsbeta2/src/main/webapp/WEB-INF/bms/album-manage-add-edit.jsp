<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<jsp:include page="web-plugin-head.jsp" />
<jsp:include page="web-plugin-head-fupload.jsp" />
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
		<span class="glyphicon glyphicon-map-marker"></span>&nbsp;<a class="mshome">后台管理</a>&nbsp;>&nbsp;<a class="retreat">相册管理</a>&nbsp;>&nbsp;相册新增&编辑
	</div>
	<!-- ckeditor -->
		<div class="col-sm-1 col-md-1" ></div>
			<div class="col-sm-10 col-md-9" >
			 <form action="${!empty album.id?'update':'add'}" enctype="multipart/form-data">
				 <div class="form-group">
				    <label for="album-name" class="col-xs-4 control-label">相册名称</label>
				    <div class="col-xs-6">
				      <input type="text" class="form-control" id="album-name" placeholder="风景集">
				    </div>
				  </div>
				  <div class="form-group">
				    <label for="album-name" class="col-xs-4 control-label">相册描述</label>
				    <div class="col-xs-6">
				      <input type="text" class="form-control" id="album-name" placeholder="相册描述">
				    </div>
				  </div>
			        <div class="form-group">
	         				  <input name="album-file" id="album-file" type="file" multiple>
	      				 </div>
	       			<div class="form-group">
						<button class="btn btn-default col-xs-offset-5 col-sm-offset-4 col-md-offset-5" type="submit">${!empty album.id?"保存修改":"发布"}</button>
					</div>
			    </form>
			</div>
				<div class="col-sm-1 col-md-2" > 
					
			</div>
	<!--close ckeditor -->
	</div>
	</div><!-- close row -->
		<jsp:include page="web-plugin-footer.jsp" />
		<script>
			$(function(){
				$("#album-file").fileinput({
					language:'zh',
					allowedFileExtensions:['jpg','png'],
					maxFileCount:10,
					enctype:'multipart/form-data',
					showUpload:true,
					showCaption:false,
					browseClass:'btn btn-default',
				});
			});
		</script>
</body>
</html>