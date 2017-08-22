$(function(){
	//分页插件(当在文档 中发现kkpager标签时插入分页按钮分页按钮)
	if($('kkpager').length==1){
		kkpager.generPageHtml({
			pno : $('kkpager').attr('data-page'),
			total : $('kkpager').attr('data-max'),
			hrefFormer : $('kkpager').attr('data-url')|'query',
			hrefLatter : '',
			getLink : function(n){
				return this.hrefFormer + this.hrefLatter + "?pagenum="+n;
			}
		});
	}
});