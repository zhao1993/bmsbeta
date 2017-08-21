(function($){
	//判断是否重名的[bootstrapvalidator]验证扩展[input 需要带initvalue 属性]
	$.fn.bootstrapValidator.validators.isExisted = {
		validate : function(validator,$field,options){
			var value = $field.val();
			var initValue = $field.attr('initvalue');
			var bl = true;
			if(initValue==value){	
				return true;
			}
			$.ajax({
					type:'post',
					url:'alreadyexisted',//验证地址
					data:{ajaxParam:value},//携带值
					dataType:'json',
					async:false,
					success:function(data){//返回false/true
						bl = data;
					}
				});
            return !bl;
		}
	}
})(jQuery)