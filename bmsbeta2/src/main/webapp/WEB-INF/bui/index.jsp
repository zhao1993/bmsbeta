<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<jsp:include page="../p4jsc/web-plugin-head.jsp"/>
<jsp:include page="../p4jsc/web-plugin-head4bui.jsp"/>
<jsp:include page="../p4jsc/web-plugin-head-kkpager.jsp"/>
<title>index</title>
</head>
<body>
<div class="container">
		<div class="row">
		 <div class="col-xs-0 col-sm-4 col-md-3 col-lg-2">
			<jsp:include page="nav.jsp"/>
		</div> 
		<div class="col-xs-12 col-sm-8 col-md-9 col-lg-7" >
		<!-- 图片展示 -->
			<div id="Carousel" class="carousel slide">
			    <!-- 轮播（Carousel）指标 -->
			    <ol class="carousel-indicators">
			        <li data-target="#Carousel" data-slide-to="0" class="active"></li>
			        <li data-target="#Carousel" data-slide-to="1"></li>
			        <li data-target="#Carousel" data-slide-to="2"></li>
			    </ol>   
			    <!-- 轮播（Carousel）项目 -->
			    <div class="carousel-inner">
			        <div class="item active">
			            <img src="../image/q1.jpg" >
			        </div>
			        <div class="item">
			            <img src="../image/q2.jpg" >
			        </div>
			        <div class="item">
			            <img src="../image/q3.jpg" >
			        </div>
			    </div>
			    <!-- 轮播（Carousel）导航 -->
			    <a class="carousel-control left" href="#Carousel" 
			        data-slide="prev">
			    </a>
			    <a class="carousel-control right" href="#Carousel" 
			        data-slide="next">
			    </a>
			</div>
			<!-- /图片展示 -->
			<!-- 其他展示 -->
				<p class="htitle"><span>图片展</span></p>
			<!-- /其他展示 -->
			<!-- 最新最热 -->
			<p class="htitle"><span>最新文章</span></p>
		<c:forEach begin="1" end="8" step="1" var="p">
				<div class="articlelists row">			
					<!-- 配图结构 -->
					<div class="col-xs-5 col-sm-5 col-md-4">
						<img class="article-pic" src="../image/p1.jpg" alt="这里是文章配图"/>
					</div>
					<!-- /配图结构 -->
					<!-- 标题内容摘要与信息 -->
					<div class="col-xs-7 col-sm-7 col-md-8">
						<dl>
							<dt class="article-title">
								<a href="test?url=bui/article">这是标题这是标题这是标题这是标题这是标题这是标题这是标题这是标题这是标题这是标题这是标题这是标题这是标题这是标题这是标题这是标题这是标题这是标题这是标题这是标题</a>
							</dt>
							<dd class="article-tag">
								<span class="label label-default">资源分享</span>
								<span class="label label-primary">原创</span>
								<span class="label label-info">其他标签</span>
							</dd>
							<dd>
								<p class="article-content">这里是文章正文这里是文章正文这里是文章正文这里是文章正文这里是文章正文这里是文章正文这里是文章正文这里是文章正文这里是文章正文这里是文章正文这里是文章正文这里是文章正文这里是文章正文这里是文章正文这里是文章正文这里是文章正文</p>
							</dd>
							<dd class="article-msg">
								<span class="glyphicon glyphicon-time "></span><span class="time" title="发布时间">2017年8月21日</span>
								<span class="glyphicon glyphicon-eye-open "></span><span class="watch" title="浏览量">99</span>
								<span class="glyphicon glyphicon-pencil "></span><span class="author" title="作者">小明</span>
							</dd>
						</dl>
					</div>
					<!-- /标题内容摘要与信息 -->
			</div>
				</c:forEach>
			<!-- /最新最热 -->
			<!-- 分页 -->
				<kkpager data-page="2" data-max="10">
					<div id="kkpager"></div>  
			<!-- /分页 -->
		</div>
		<div class="aside-div col-xs-0 col-sm-0 col-md-0 col-lg-3">
			<jsp:include page="aside.jsp"/>
		</div>
	</div>
</div>
<jsp:include page="../p4jsc/web-plugin-footer4bui.jsp" />
<jsp:include page="../p4jsc/web-plugin-index.jsp" />
</body>
</html>