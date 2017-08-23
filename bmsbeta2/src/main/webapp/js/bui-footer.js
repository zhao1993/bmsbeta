/**
 * 
 */
var go_top;
$(function(){
	/*搜索框效果*/
	var search_box = window.document.getElementById("search"); 
	var search_top = search_box.offsetTop;
	/*回顶部按钮效果开始*/
	var topbar = window.document.getElementById("topbar");
	go_top = function(){
		var start = window.setInterval(function() {
			window.scrollBy(0, -36);
			if(window.scrollY<=0){
				window.clearInterval(start);
			}
		}, 6);
	}
	window.onscroll = function(){
		/*回顶部监听*/
		if(window.scrollY>=100){
			topbar.style.display = "block";
		}else{
			topbar.style.display = "none";
		}
		/*搜索框悬浮效果开始*/
		if(search_top <= window.scrollY){
			search_box.style.width = search_box.offsetWidth+"px";
			$(search_box).addClass("search_fixed");		
		}else{
			$(search_box).removeClass("search_fixed");		
		}
		/*搜索框悬浮效果结束*/
	}
})
