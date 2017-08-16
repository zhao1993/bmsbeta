<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<jsp:include page="../p4jsc/web-plugin-head.jsp" />
<jsp:include page="../p4jsc/web-plugin-head-fupload.jsp" />
<jsp:include page="../p4jsc/web-plugin-head-validator.jsp" />
<title>article-manage</title>
</head>
<body>
		<jsp:include page="manage-nav-bar.jsp"/>
	<div class="row">
	<div class="col-sm-3 col-md-3 col-lg-2">
		<jsp:include page="manage-left-menu.jsp"/>
	</div>
	<div class="col-sm-8 col-md-8 col-lg-9" >
	<div class="page-header">
		<span class="glyphicon glyphicon-map-marker"></span>&nbsp;<a href="mshome">后台管理</a>&nbsp;>&nbsp;<a class="retreat">相册管理</a>&nbsp;>&nbsp;相册${empty album?'新增':'编辑'}
	</div>
	<!-- ckeditor -->
		<div class="col-sm-1 col-md-1" ></div>
			<div class="col-sm-10 col-md-9" >
			 <form id="album-form" class="form-horizontal" action="${!empty album.id?'update':'add'}" enctype="multipart/form-data" method="post">
				<input type="hidden" name="id" value="${album.id}">
				 <div class="form-group">
				    <label for="album-name" class="col-xs-4 control-label">album name</label>
				    <div class="col-xs-6">
				      <input type="text" class="form-control" id="album-name" name="title" value="${album.title}" placeholder="风景集" initvalue="${album.title}">
				    </div>
				  </div>
				  <div class="form-group">
				    <label for="album-name" class="col-xs-4 control-label">album description</label>
				    <div class="col-xs-6">
				      <input type="text" class="form-control" id="album-name" name="content" value="${album.content}" placeholder="相册描述">
				    </div>
				  </div>
			      <div class="form-group">
			      <label for="album-name" class="col-xs-4 control-label">photos list</label>
				    <div class="col-xs-8">
	                    <input id="photos" type="file" name="file" multiple data-overwrite-initial="false">
				    </div>
                </div>
	       			<div class="form-group">
						<button class="btn btn-default col-xs-offset-5 col-sm-offset-4 col-md-offset-5" type="submit">${!empty album?"保存修改":"发布"}</button>
					</div>
			    </form>
			</div>
				<div class="col-sm-1 col-md-2" > 
					
			</div>
	<!--close ckeditor -->
	</div>
	</div><!-- close row -->
		<jsp:include page="../p4jsc/web-plugin-footer.jsp" />
		<script>
			$(function(){
			//表单验证
			$("#album-form").bootstrapValidator({
				 message: 'This value is not valid',
			        feedbackIcons: {
			            valid: 'glyphicon glyphicon-ok',
			            invalid: 'glyphicon glyphicon-remove',
			            validating: 'glyphicon glyphicon-refresh'
			        },//feedbackIcons
			        fields:{
			        	title:{
			        	validators:{
				        	notEmpty:{
				        	message:"必须要有相册名!"
				        	},
				        	isExisted:{
				        	message:"已经存在的相册集!"
				        	} 
			        	}//validators
			         }//title
			      }//fields
			}); 
			// updateData start
			var urlfix = "http://localhost:8080/bmsbeta2/album/queryimage?image=";
			var initialPreview = new Array();
			var initialPreviewConfig = new Array();
			var initialCount = 0;
			if('${album}'!=''){
				$.ajax({
				type:'post',
				url:'queryphotos',
				dataType:'json',
				data:{id:'${album.id}'},
				async:false,
				success:function(lists){
					 $.each(lists,function(i,photo){
							var config = new Object();
							config.caption = photo.note;
							config.url = "deletephoto";
							config.type = "image";
							config.key = photo.id;
							initialPreviewConfig.push(config);
							initialPreview.push(urlfix+photo.image);
							initialCount++;
						}); 
					}
				});
			}
			// updateData end
				$("#photos").fileinput({
			       	showBrowse:'false',
			       	uploadUrl:'${album}'==''?'':'addphoto?albumid=${album.id}',
					theme:'explorer',
					overwriteInitial:'false',
					language:'zh',
					allowedFileExtensions:['jpg','png'],
					initialPreviewAsData: '${album}'==''?false:true,
					initialPreview:initialPreview,
			        initialPreviewConfig:initialPreviewConfig,
					enctype:'multipart/form-data',
					showUpload:false,
					showRemove:true,
					maxFileSize:2048,
					maxImageWidth:100,
					browseClass:'btn btn-default',
					dropZoneTitle:"可以将图片拖拽到这里",
					msgUploadEnd:"已经更新到相册",
					msgUploadThreshold:"正在上传文件...",
					fileActionSettings:{uploadTitle:"上传并更新"}
				});
			});
		</script>
</body>
</html>