<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<jsp:include page="../p4jsc/web-plugin-head.jsp" />
<jsp:include page="../p4jsc/web-plugin-head-fupload.jsp" />
<jsp:include page="../p4jsc/web-plugin-head-select.jsp" />
<jsp:include page="../p4jsc/web-plugin-head-validator.jsp" />
<link href="<%=request.getContextPath()%>/bootstrap/checkbox/css/awesome-bootstrap-checkbox.css" rel="stylesheet" type="text/css"/>
<link href="<%=request.getContextPath()%>/bootstrap/checkbox/css/build.css" rel="stylesheet" type="text/css"/>
<script type="text/javascript" src="<%=request.getContextPath()%>/ckeditor/ckeditor.js"></script>

<title>article-manage</title>
<style>
	.carousel-control.right{
		background-image: -webkit-linear-gradient(left,rgba(0,0,0,0) 0,rgba(0,0,0,0) 100%);
		background-image: -o-linear-gradient(left,rgba(0,0,0,0) 0,rgba(0,0,0,0) 100%);
		background-image: -webkit-gradient(linear,left top,right top,from(rgba(0,0,0,0)),to(rgba(0,0,0,.3)));
		background-image: linear-gradient(to right,rgba(0,0,0,0) 0,rgba(0,0,0,0) 100%);
		filter: progid:DXImageTransform.Microsoft.gradient(startColorstr='#00000000', endColorstr='#00000000', GradientType=1);
	}
	select {
	  /*Chrome和Firefox里面的边框是不一样的，所以复写了一下*/
	  border: solid 1px #000;
	  /*很关键：将默认的select选择框样式清除*/
	  appearance:none;
	  -moz-appearance:none;
	  -webkit-appearance:none;
	  /*在选择框的最右侧中间显示小箭头图片*/
	  background: url("http://ourjs.github.io/static/2015/arrow.png") no-repeat scroll right center transparent;
	  /*为下拉小箭头留出一点位置，避免被文字覆盖*/
	  padding-right: 14px;
	}
/*清除ie的默认选择框样式清除，隐藏下拉箭头*/
select::-ms-expand { display: none; }
</style>
</head>
<body>
		<jsp:include page="manage-nav-bar.jsp"/>
		<div class="container">
	<div class="row">
	<div class="col-sm-4 col-md-4 col-lg-3" >
		<jsp:include page="manage-left-menu.jsp"/>
	</div>
	<div class="col-sm-8 col-md-8 col-lg-9" >
	<div class="page-header">
		<span class="glyphicon glyphicon-map-marker"></span>&nbsp;<a class="mshome">后台管理</a>&nbsp;>&nbsp;<a class="retreat">文章管理</a>&nbsp;>&nbsp;文章${article.id!=null?"编辑":"发布"}
	</div>
	<!-- ckeditor -->
		<div class="col-sm-1 col-md-1" ></div>
			<div class="col-sm-10 col-md-9" >
			<form id="article-form" action="${empty article.id?'add':'update'}" method="post" enctype="multipart/form-data">
				<div class="form-group">
					<input type="hidden" name="id" value="${article.id}"/>
					<input type="text" class="form-control" style="text-align:center" id="article-title" name="title" value="${article.title}" placeholder="标题">
				</div>
				<div class="row">
				 <div class="form-group col-sm-6 col-md-6">
            		<input id="article-pic" name="file" type="file" alt="文章配图" />
            		<!-- <img alt="预览" src=""/> -->
            		<div id="errorBlock" class="help-block"></div>
        		</div>
        			<div class="col-sm-6 col-md-6">
        				<div class="form-group">
							<div id="type-carousel" class="carousel slide">
								<!-- 轮播（Carousel）项目 -->
								<div class="carousel-inner">
									<div class="item active">
									<div class="input-group">
									<span class="input-group-addon"><strong>文章分类</strong></span>
								        <select id="singleOption" class="show-menu-arrow form-control article-type" name="type" >
								         <c:forEach items="${types}" var="type">
								         	<c:if test="${type!=''}">
								         		<option value="${type}" ${article.type eq type?"selected":""}>${type}</option>
								         	</c:if>
								        </c:forEach>
								        </select>
									<span class="input-group-addon">切换</span>
								        </div>
									</div>
									<div class="item">
										<div class="input-group">
											  <span class="input-group-addon"><strong>自定义分类</strong></span>
											  <input type="text" class="form-control article-type" placeholder="心得体会" name="type" value="${article.type}" aria-describedby="basic-addon2"/>
											  <span class="input-group-addon">切换</span>
											</div>
									</div>
								</div>
								<!-- 轮播（Carousel）导航 -->
								<a class="carousel-control right" href="#type-carousel" 
								   data-slide="next"></a>
							</div> 				
						</div>
        				<div class="form-group">
        					<div class="input-group">
							  <span class="input-group-addon" id="basic-addon1"><strong>文章关键字</strong></span>
							  <input type="text" class="form-control" name="keywords" value="${article.keywords}" placeholder="html5,css3" aria-describedby="basic-addon1">
        				 </div>
						</div>
						<div class="row">
						<!-- 选择推荐 -->
					<div class="col-sm-6">
						<div class="panel panel-default">
						<div class="panel-heading">
							<strong>文章推荐</strong>
						</div>
						<div class="panel-body panel-body-custom">
		                   <div class="form-group">
			                     <div class="radio">
			                        <input type="radio" name="recommend" id="article-recommend-yes" value="yes" ${article.recommend eq 'yes'?'checked':''}/>
			                        <label for="article-recommend-yes">设为推荐</label>
			                    </div>
			                    <div class="radio">
			                        <input type="radio" name="recommend" id="article-recommend-no" value="no" ${article.recommend ne 'yes'?'checked':''}/>
			                        <label for="article-recommend-no">不设推荐</label>
		                    	</div>
		                  </div>
		                  </div><!-- close panel-body -->
						</div><!-- close panel -->
					</div>
					<div class="col-sm-6">
						<div class="panel panel-default">
						<div class="panel-heading">
							<strong>文章来源</strong>
						</div>
						<div class="panel-body panel-body-custom">
		                   <div class="form-group">
			                     <div class="radio">
			                        <input type="radio" name="source" id="article-source-original" value="original" ${article.source eq 'original'?'checked':''}/>
			                        <label for="article-source-original">原创</label>
			                    </div>
			                    <div class="radio">
			                        <input type="radio" name="source" id="article-source-reprint" value="reprint" ${article.source ne 'original'?'checked':''}/>
			                        <label for="article-source-reprint">转载</label>
		                    	</div>
		                  </div>
		                  </div><!-- close panel-body -->
						</div><!-- close panel -->
					</div>
						</div><!-- panel row -->
		<div class="row">
			<div class="col-sm-4 col-xs-4 col-md-4">
        		<div class="panel panel-default">
	        		<div class="panel-heading">
	        			<strong>浏览量</strong>
	        		</div>
        			<div class="panel-body">
        				<span>${empty article.watch?0:article.watch}</span>
        			</div>
        		</div>
        	</div>
			<div class="col-sm-4 col-xs-4 col-md-4">
        		<div class="panel panel-default">
        		<div class="panel-heading">
        			<strong>评论数</strong>
	        		</div>
        			<div class="panel-body">
        				<span>${empty article.replys?0:article.replys}</span>
        			</div>
        		</div>
        	</div>
			<div class="col-sm-4 col-xs-4 col-md-4">
        		<div class="panel panel-default">
        		<div class="panel-heading">
        			<strong>作者</strong>
	        		</div>
        			<div class="panel-body">
        				<span>${empty article.editer || article.editer eq ''?'佚名':article.editer}</span>
        				<input type="hidden" value="${empty article.editer || article.editer eq ''?'佚名':article.editer}" name="editer"/>
        			</div>
        		</div>
        	</div>
        </div>
        	</div>
        		</div>
        		<div class="form-group">
				<textarea id="article-content" name='content'>${article.content}</textarea>
				<script type="text/javascript">
					CKEDITOR.replace('content');
				</script>
				</div>
        		<div class="form-group">
					<button class="btn btn-default col-xs-offset-5 col-sm-offset-4 col-md-offset-5" type="submit">${!empty article.id?"保存修改":"发布"}</button>
				</div>
			</form>	
				</div>
			<div class="col-sm-1 col-md-2" >
				
			</div>
	<!--close ckeditor -->
	</div>
	</div><!-- close row -->
	</div>
		<jsp:include page="../p4jsc/web-plugin-footer.jsp" />
		<script>
			$(function(){
			//表单验证
			$("#article-form").bootstrapValidator({
				 message: 'This value is not valid',
			        feedbackIcons: {
			            valid: 'glyphicon glyphicon-ok',
			            invalid: 'glyphicon glyphicon-remove',
			            validating: 'glyphicon glyphicon-refresh'
			        },
			        fields:{
			        	title:{
			        		validators:{notEmpty:{message:"标题不能为空！"} }
			        	}
			        }
			}); 
				//$.fn.fileinputLocales['zh'].dropZoneTitle='文章配图';
				$("#article-pic").fileinput({
					showBrowse:'false',
					theme:'explorer',
					overwriteInitial:'false',
					language:'zh',
					allowedFileExtensions:['jpg','png'],
					initialPreviewAsData: true,
					initialPreview:['http://localhost:8080/bmsbeta2/article/queryimage?image=${article.image}'],
			        initialPreviewConfig: [{caption: "${article.image}"}],
					maxFileCount:1,
					enctype:'multipart/form-data',
					showUpload:false,
					browseClass:'btn btn-default'
				});
				//分类切换
			      $("#type-carousel").carousel('cycle');
			      $("#type-carousel").carousel('pause');
			      var slidebscarousel = function(){
			    	  $(".item").find(".article-type").removeAttr("disabled");
			      }
			      var slidbscarousel = function(){
		    	 	 //预选和自定义切换
			    	 //先把两个选项都禁用然后再找有类active的下面的解开disabled属性[提交时只能提交一个属性]
			    	  $(".item").find(".article-type").attr("disabled","disabled");
			    	 //插件有过度时间
			    	  $(".item.active").find(".article-type").removeAttr("disabled");
			      }
			      $("#type-carousel").on({'slide.bs.carousel':function(){
			      	  slidebscarousel();
			      },'slid.bs.carousel':function(){
			    	  slidbscarousel();
			      }});
			    	  //页面载入初始化 切换分类按钮
			      	  slidebscarousel();
			    	  slidbscarousel();
			});
			//选择框
			function changeState(el) {
		        if (el.readOnly) el.checked=el.readOnly=false;
		        else if (!el.checked) el.readOnly=el.indeterminate=true;
		    }
			
		</script>
</body>
</html>