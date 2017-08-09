$(function(){
	var daily_id = 'daily-edit-div';
	var open_edit = function(){
		if($('.daily-edit').is(':visible'))
			alert('the edit box has been opened!');
		else{
			$('.daily-edit').fadeIn('slow');
			$('#delete-btn').addClass('disabled').attr({'data-toggle':"tooltip",'data-original-title':'当前状态不允许删除'});
			$('[data-toggle="tooltip"]').tooltip();
		}
		
	}
	$('#add-btn,#edit-btn').unbind('click');
	$('#daily-edit-form').submit(function(){
		if(CKEDITOR.instances.content.document.getBody().getText().length<15){
			alert('content too short!\n\rIt`s at least 15 words');
			return false;
		}
	});
	
	var isAllowed = function(button){
		if($(button).prop("disabled") || $(button).hasClass('disabled') || $('.daily-edit').is(':visible'))
			return false;
		return true;
	}
	$('#add-btn').click(function(){
		if(!isAllowed(this)){
			return false;
		}
			$('#daily-edit-form')
			.attr('action','add').find('button[type="submit"]').text('发布');
			CKEDITOR.instances.content.setData("");
			open_edit();
		});
	$('#exit-btn').click(function(){
		$('.daily-edit').fadeOut('fast');
		$('#delete-btn').removeClass('disabled').attr({'data-toggle':'modal'}).removeAttr('data-original-title');
		//防止非submit提交表单
		return false;
	});
	$('#edit-btn').click(function(){
		if(!isAllowed(this)){
			return false;
		}
		//获取id
		var id;
		$('tbody tr').each(function(i,tr){
			if($(tr).hasClass('table-tr-select')){
				id = $(tr).find('.id').text();
			}
		});
		$('#daily-edit-form')
		.attr('action','update').find('button[type="submit"]').text('修改');;
		$('#daily-edit-form').find('input[type="hidden"]').val(id);
		$.ajax({
			type:'post',
			url:'toupdate',
			data:{'id':id},
			dataType:'json',
			async:false,
			success:function(daily){
				CKEDITOR.instances.content.setData(daily.content);
			}
		});
		open_edit();
	});
});