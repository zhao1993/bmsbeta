<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
      <%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
	%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<base href="<%=basePath%>">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<jsp:include page="../p4jsc/web-plugin-head.jsp"/>
<jsp:include page="../p4jsc/web-plugin-head4bui.jsp"/>
<jsp:include page="../p4jsc/web-plugin-article.jsp"/>
<title>article</title>
</head>
<body>
<div class="container">
		<div class="row">
		 <div class="col-xs-0 col-sm-4 col-md-3 col-lg-2">
			<jsp:include page="nav.jsp"/>
		</div> 
		<div class="col-xs-12 col-sm-8 col-md-9 col-lg-7" >
			<div class="top_position">
				<script type="text/javascript">
				$(function(){
					$(".top_position").navigation([
					{"text":"首页","url":"${basePath}blog/bui/index"},
					{"text":"文章","url":"${basePath}blog/bui/article"},	
					{"text":"文章正文","url":"#"},
					]);
				})
				</script>
			</div>
			<p class="htitle"><span>正文</span></p>
			<div>
				<p class="article-title">这里是文章的标题</p>
				<div class="article-info">
				<span>编辑:</span>
				<span>鲁迅</span>
				<span>时间:</span>
				<span>2017年8月22日</span>
				<span>浏览:</span>
				<span>1212</span>
				</div>
				<div class="article-content">
											<p>服务器推送事件（Server-sent Events）是基于WebSocket 协议的一种服务器向客户端发送事件&amp;数据的单向通讯。目前所有主流浏览器均支持服务器发送事件，当然除了 Internet Explorer 。2333...</p>
<p>WebSocket 协议是继HTTP协议后又一服务器客户端通讯协议，不同于HTTP单纯的客户端请求服务器响应单向通讯模式的是它支持了服务端客户端的双向通讯。</p>
<p><strong>Server-sent Events 的使用</strong></p>
<p>Server-sent Events（以下简称SSE）作为服务器=&gt;客户端通讯方式那必然客户端要有相应的服务地址和响应方法，服务端要有相应的数据发送方法；废话不多说，上代码！</p>
<p><strong>客户端JS代码</strong></p>
<p>&nbsp;H5页面需添加如下JS代码：</p>

<pre class="brush:js;">
     &lt;script&gt;
         if (typeof (EventSource) !== &quot;undefined&quot;) {
             //推送服务接口地址
             var eventSource = new EventSource(&quot;http://localhost:2242/webservice/ServerSent/SentNews&quot;);
             //当通往服务器的连接被打开
             eventSource.onopen = function () {
                 console.log(&quot;连接打开...&quot;);
             }
              //当错误发生
              eventSource.onerror= function (e) {
                  console.log(e);
              };
              //当接收到消息，此事件为默认事件
              eventSource.onmessage = function (event) {
                  console.log(&quot;onmessage...&quot;);
          　　　　 eventSource.close()//关闭SSE链接
              };
              //服务器推送sentMessage事件
              eventSource.addEventListener('sentMessage', function (event) { 
                  var data = eval('('+event.data+')');//服务器端推送的数据，eval装换Json对象
                  var origin = event.origin;//服务器 URL 的域名部分，即协议、域名和端口，表示消息的来源。
                  var lastEventId = event.lastEventId;////数据的编号，由服务器端发送。如果没有编号，这个属性为空。
                  //此处根据需求编写业务逻辑
                  console.log(data);              }, false);
          } else {
              //浏览器不支持server-sent events 所有主流浏览器均支持服务器发送事件，除了 Internet Explorer。
              document.getElementById(&quot;result&quot;).innerHTML = &quot;Sorry, your browser does not support server-sent events...&quot;;
          }
      &lt;/script&gt;
</pre>

<p><strong>服务端</strong></p>
<p>服务端应当返回怎样的数据格式？应当以什么样的响应给客户端呢？先来个.Net 的样例</p>

<pre class="brush:csharp;">
　　　　/// &lt;summary&gt;
        /// 推送消息
        /// &lt;/summary&gt;
        /// &lt;returns&gt;&lt;/returns&gt;
        [HttpGet]
        public HttpResponseMessage SentNews()
        {
            HttpResponseMessage response = Request.CreateResponse(HttpStatusCode.OK);
            try
            {
                //response.Headers.Add(&quot;Access-Control-Allow-Origin&quot;, &quot;*&quot;);//如需要跨域可配置
                string data_str = &ldquo;推送至客户端的数据&rdquo;;//当然可以是json字符串格式
                string even = &quot;&quot;, data = &quot;&quot;;
                if (!string.IsNullOrWhiteSpace(data_str))
                {
                    even = &quot;event:sentMessage\n&quot;;
                    data = &quot;data:&quot; + data_str + &quot;\n\n&quot;;
                }
                string retry = &quot;retry:&quot; + 1000 + &quot;\n&quot;;//连接断开后重连时间（毫秒），其实可以理解为轮询时间 2333...
                byte[] array = Encoding.UTF8.GetBytes(even + data + retry);
                Stream stream_result = new MemoryStream(array);
                response.Content = new StreamContent(stream_result);
                response.Content.Headers.ContentType = new MediaTypeHeaderValue(&quot;text/event-stream&quot;);//此处一定要配置
                response.Headers.CacheControl = new CacheControlHeaderValue();
                response.Headers.CacheControl.NoCache = false;
            }
            catch (Exception ex)
            {
                LogHelper.WriteWebLog(ex);
            }
            return response;
        }

</pre>

<p>看完以上代码我想你应该有个大概了，响应的方式还是HTTPResponse响应，但总是有点小小的要求的：</p>
<p>响应报头&quot;Content-Type&quot; 要设置为 &quot;text/event-stream&quot;</p>
<p>响应的数据格式也应该注意到了上述代码中的&quot;data:&quot;、&quot;event:&quot;和&quot;retry:&quot;这些标记：</p>
<p>1.event：表示该行用来声明事件的类型。浏览器在收到数据时，会产生对应类型的事件。</p>
<p>2.data：表示该行包含的是数据。以 data 开头的行可以出现多次。所有这些行都是该事件的数据。</p>
<p>3.retry：表示该行用来声明浏览器在连接断开之后进行再次连接之前的等待时间。</p>
<p>4.id：表示该行用来声明事件的标识符（即数据的编号），不常用。</p>
<p>以上就是Server-sent Events的简单应用，实现效果我就不再展示了，有兴趣可以亲自操作实现效果！</p>
			本文地址：http://itbyc.com/web/html5/17667.html<br>
			转载请注明出处。
				</div> <!-- 正文结束 -->
				<!-- 上下文 -->				
				<div class="article-prenext	">
					<span>上一篇:</span><a href="">HTML5使用方便功能强大、一脸懵逼</a>
					<span>下一篇:</span><a href="">PHP是世界上最好的编程语言、JAVA表示不服</a>
				</div>
			</div>
			<p class="htitle"><span>最新评论</span></p>
			<!-- 回复框容器 -->
			<div class="reply_container">
				<script type="text/javascript">
					$(".reply_container").reply({
						/* url_init:$this.attr('data-init-url') */
						 url_init:'${basePath}critique/bui/initreply',
						 url_deck:'${basePath}critique/bui/deckreply',
						 eventCustom:{reply:function(val,cid,uid){
						 	$.ajax({
						 		url:'${basePath}article/bui/addreply',
						 		type:'post',
						 		data:{cid:cid,aid:1,uid:uid,val:val},
						 		async:false,
						 		success:function(flag){
							 		 if(flag==true){
							 			window.location.reload();
							 		}  
						 		}
						 	});
						 },
						 login:function(loginid){
						 	
						 }
						},
					});
				</script>
			</div>
		</div>
		<div class="aside-div col-xs-0 col-sm-0 col-md-0 col-lg-3">
			<jsp:include page="aside.jsp"/>
		</div>
	</div>
</div>
<jsp:include page="../p4jsc/web-plugin-footer4bui.jsp" />
</body>
</html>