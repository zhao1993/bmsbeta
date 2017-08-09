<%
	//页面左侧的菜单卡
%>
<%@page pageEncoding="UTF-8"%>
<div class="panel-group" style="margin-left:20px">
<div class="panel panel-default">
        <div class="panel-heading">
			<a href="<%=request.getContextPath()%>/user/query">
	            <span class="panel-title">
	               	<span class="glyphicon glyphicon-user" ></span>&nbsp;&nbsp;用户管理
	            </span>
			</a>
        </div>
    </div>
    <div class="panel panel-default">
     <div class="panel-heading">
			<a href="<%=request.getContextPath()%>/article/query">
	            <span class="panel-title">
	               	<span class="glyphicon glyphicon-book" ></span>&nbsp;&nbsp;文章管理
	            </span>
			</a>
        </div>    
    </div>
    <div class="panel panel-default">
     <div class="panel-heading">
				<a href="<%=request.getContextPath()%>/daily/query">
		            <span class="panel-title">
		               	<span class="glyphicon glyphicon-pencil" ></span>&nbsp;&nbsp;日志管理
		            </span>
				</a>
	        </div>
    </div>
    <div class="panel panel-default">
    <div class="panel-heading">
				<a href="<%=request.getContextPath()%>/album/query">
		            <span class="panel-title">
		               	<span class="glyphicon glyphicon-picture" ></span>&nbsp;&nbsp;相册管理
		            </span>
				</a>
	        </div>
    </div>
    <div class="panel panel-default">
    <div class="panel-heading">
				<a href="<%=request.getContextPath()%>/critique/query">
		            <span class="panel-title">
		               	<span class="glyphicon glyphicon-comment" ></span>&nbsp;&nbsp;留言(评论)管理
		            </span>
				</a>
	        </div>
</div>
<div class="panel panel-default">
        <div class="panel-heading">
            <span class="panel-title" data-toggle="collapse" data-parent="#accordion" href="#collapse0">
               	<span class="glyphicon glyphicon-cog" ></span>&nbsp;&nbsp;其他管理<span class="caret"></span>
            </span>
        </div>
        <div id="collapse0" class="panel-collapse collapse">
            <div class="panel-body">
	            <a href="#" class="list-group-item">
					<span class="glyphicon glyphicon-plus" ></span>&nbsp;&nbsp;主副标题
				</a>
				<a href="#" class="list-group-item">
					<span class="glyphicon glyphicon-edit" ></span>&nbsp;&nbsp;心灵鸡汤
				</a>
				<a href="#" class="list-group-item">
					<span class="glyphicon glyphicon-trash" ></span>&nbsp;&nbsp;主题设置
				</a>
            </div>
        </div>
    </div>
    <div class="panel panel-default">
        <div class="panel-heading">
            <span class="panel-title" data-toggle="collapse" data-parent="#accordion" href="#collapse6">
               	<span class="glyphicon glyphicon-leaf" ></span>&nbsp;&nbsp;系统管理<span class="caret"></span>
            </span>
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
</div>