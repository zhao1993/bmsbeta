/**
 * <script type="text/javascript">
				$(function(){
					$(".top_position").navigation([
					{"text":"首页","url":"index"},
					{"text":"文章","url":"article"},	
					{"text":"文章详细","url":"#"},
					]);
				})
				</script>
 */
(function($){
	$.fn.navigation = function(prms){
		var container = $(this);
		var params = $.extend(prms,[]);
		if(params.length==0){ return ; }
		container.empty();
		container.append('<span class="glyphicon glyphicon-map-marker"></span>');
		var html = '当前位置:';
		$.each(params,function(i,obj){
			if(i<params.length-1){
				html += '<a href='+obj.url+' title='+obj.text+'>'+obj.text+'</a>';
				html += '&gt;';
			}else{
				html += '<span title='+obj.text+'>'+obj.text+'</span>';
			}
		});
		container.append(html);
		container.css({
			'letter-spacing':'.2em',
			'font-size':'18px'})
			.find('a').css({
				'display':'inline-block',
				'text-decoration':'underline',
				'color':'blue'});
	}
})(jQuery)