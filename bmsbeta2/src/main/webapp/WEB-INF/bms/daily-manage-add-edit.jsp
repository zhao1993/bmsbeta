<%@page pageEncoding="UTF-8"%>
<jsp:include page="<%=request.getContextPath()%>/p4jsc/web-plugin-head.jsp" />
<script type="text/javascript" src="<%=request.getContextPath()%>/ckeditor/ckeditor.js"></script>
	<form action="${!empty daily.id?'update':'add'}" method="post" enctype="multipart/form-data">
		<div class="row">
			<div class="col-sm-9 col-md-10" >
				<textarea name='daily-content'></textarea>
				<script type="text/javascript">CKEDITOR.replace('daily-content');</script>
			</div><!--close ckeditor -->
			<div class="col-sm-1 col-md-2" >
				<button type="submit" class="btn btn-info col-xs-offset-5 col-sm-offset-2 col-md-offset-5">${!empty daily.id?'保存修改':'发布'}</button>
				<br/>	
				<button id="exit-btn" class="btn btn-default col-xs-offset-5 col-sm-offset-2 col-md-offset-5">退出</button>			
			</div>
	</div><!-- close row -->
</form>	