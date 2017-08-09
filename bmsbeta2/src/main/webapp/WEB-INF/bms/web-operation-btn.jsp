<%@page pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%
	//这里存放页面中的css样式及js脚本文件 	基于bootstrap的文件上传组件
%>
	<c:if test="${fn:containsIgnoreCase(param:hasbtn,'all')}">
		<button class="btn btn-default" id="check-all"><span class="glyphicon glyphicon-th-large" ></span>全选</button>
	</c:if>
		<button class="btn btn-default" id="invert-selection"><span class="glyphicon glyphicon-retweet" ></span>反选</button>
		<button class="btn btn-default" id="add-btn"><span class="glyphicon glyphicon-plus" ></span>新增</button>
		<button class="btn btn-default" id="edit-btn"><span class="glyphicon glyphicon-pencil" ></span>编辑</button>
		<button class="btn btn-default" id="delete-btn" data-toggle="modal" data-target="#delete-data"><span class="glyphicon glyphicon-remove" ></span>删除</button>
