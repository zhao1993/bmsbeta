<%@page pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
 <div class="aside fs16 visible-lg">
 	<div id="topbar" onclick="go_top()">至顶</div>
	 <div class="board">
	 		<span class="board-title">标签标题</span>
			<span class="board-date">2017年8月17日 星期四</span>
			<p class="board-content">显示一些简短的语句、显示一些简短的语句、显示一些简短的语句</p>
	 </div>
		<div id="search">
		 <p class="htitle"><span>站内搜索</span></p>
			<div class="input-group">
				<input type="text" class="form-control" placeholder="这里是搜索内容"/>
				<span class="input-group-addon">
					<input class="btn btn-info btn-search" value="搜索" type="button"/>
					</span>
					<!-- 这里可以表单提交也可以超链接提交 -->
			</div>
	 	</div>
	 	<p class="htitle"><span>分类标题</span></p>
		<ul class="hot">
		<c:forEach begin="1" step="1" end="4" var="i">
	        <li><a href="index.html">
	        		<span class="pic"><img src="../image/p1.jpg"/></span>
	        		<span class="text article-content">这里是文章标题、这里是文章标题这里是文章标题、这里是文章标题</span>
	        		<span class="eyes">阅读量(999)</span>
	        	</a>
	        </li>
		</c:forEach>
	  </ul>
	<p class="htitle"><span>分类标题2</span></p>
	<ul class="hot">
		<c:forEach begin="1" step="1" end="4" var="i">
	        <li><a href="index.html">
	        		<span class="pic"><img src="../image/p1.jpg"/></span>
	        		<span class="text">这里是文章标题、这里是文章标题</span>
	        		<span class="eyes">阅读量(999)</span>
	        	</a>
	        </li>
		</c:forEach>
	  </ul>
	  <p class="htitle"><span>其他</span></p>
	<ul class="hot">
		<c:forEach begin="1" step="1" end="4" var="i">
	        <li><a href="index.html">
	        		<span class="pic"><img src="../image/p1.jpg"/></span>
	        		<span class="text">这里是文章标题、这里是文章标题</span>
	        		<span class="eyes">阅读量(999)</span>
	        	</a>
	        </li>
		</c:forEach>
	  </ul>
 </div>