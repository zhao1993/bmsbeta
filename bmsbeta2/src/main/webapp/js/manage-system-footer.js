	
$(function(){
		//充当checkbox的元素
		function simulate_cb (){
			return $('tbody tr');
		}
		//编辑按钮
		var edit_btn = $('#edit-btn');
		//删除按钮
		var delete_btn = $('#delete-btn');
		//反选按钮
		var invert_selection = $('#invert-selection');
		//全选按钮
		var check_all = $('#check-all');
		//所以在tr的th或td中有且只有一个id的类标签（一般存放了当前对象的id）
		var arr_id = new Array();
		
		//单选
		var selectr = function(tr){
				if(null!=tr){
				//
					var id = $(tr).find('.id').text();
				//判断是否存在于数组中
					if(-1 == arr_id.indexOf(id)){
						//不存在的情况下将id添加到数组中并且设置选中样式
						arr_id.push(id);
						$(tr).addClass('table-tr-select');
					}else{
						//存在的情况下将id从数组中移除并且移除选中样式
						arr_id.remove(id);
						$(tr).removeClass('table-tr-select');
					}
				}
					//禁用编辑按钮(当选中条目大于1条时则编辑按钮不可用)
					if(arr_id.length>1 || arr_id.length==0) {
						edit_btn.addClass('disabled').attr({'data-toggle':"tooltip",'data-original-title':'未选或多选状态下无法进行编辑操作！'});
						$('[data-toggle="tooltip"]').tooltip();
					}
					else{
						edit_btn.removeClass('disabled').removeAttr("data-toggle data-original-title");
					} 
					//禁启用删除按钮
					if(arr_id.length>=1) {
						delete_btn.removeClass('disabled').attr({'data-toggle':'modal'}).removeAttr('data-original-title');
					}
					else {
						delete_btn.addClass('disabled').attr({'data-toggle':"tooltip",'data-original-title':'未选中任何项目'});
						$('[data-toggle="tooltip"]').tooltip();
					}
			 }
			//单选效果
			simulate_cb().click(function(){
				selectr(this);
			});
			//多选
			var invertr = function(trs){
				$(trs).each(function(i,dat){
					selectr(dat);
				});
			}
			//反选效果
			invert_selection.click(function(){
				invertr(simulate_cb());
			});
			//全选效果
			check_all.click(function(){
				if(arr_id.length!=simulate_cb().length){
					arr_id = [];
				}
				invertr(simulate_cb());
			});
			//展示删除数据到模态框
			delete_btn.click(function(){
				$('#delete-count').text(arr_id.length);	
				//console.dir(arr_id);
			});
			//将存放数组转换成新的字符串值(组为数字类型的数组)用于删除时组合id
			var no2Code = function(arr){
				var code ="";
				$(arr).each(function(i,d){
					if(i+1==arr.length)
							code+=d;
						else
							code+=d+"-";
				});
				return code;
			}
			//A标签返回上一级[a 标签类选择器 retreat]
			if($('.retreat').length>0){
				$('.retreat').attr('href','query');
				/* 2017年8月6日16:10:28功能不通用
				 * $('.retreat').click(function(){
					self.location = document.referrer;
				})
				.attr('herf','javascript:void(0);')
				.css('cursor','pointer');*/
			}
			//返回后台管理首页[....]
			if($('.mshome').length>0){
				$('.mshome').click(function(){
					self.location = document.referrer;
				})
				.attr('herf','javascript:void(0);')
				.css('cursor','pointer');
			}
			//新增按钮
			$('#add-btn').click(function(){
				//其他需求可以在按钮标签添加  data-url属性(下同)
				//window.location.href=$(this).attr('data-url');
				if($(this).prop("disabled") || $(this).hasClass('disabled')){
					//这里可以优化？[设置有disabled的标签也可以点击修复]
					return false;
				}else{
				window.location.href="toadd";
				}
			});
			//编辑按钮 
			$('#edit-btn').click(function(){
				//window.location.href=$(this).attr('data-url')+"?id="+arr_id[0];
				if($(this).prop("disabled") || $(this).hasClass('disabled')){
					//这里可以优化？[设置有disabled的标签也可以点击修复]
					return false;
				}else{
					window.location.href="toupdate?id="+arr_id[0];
				}
			});
			//删除数据操作(模态框id下的submit按钮 获取页面删除按钮定义的跳转链接 触发删除操作)
			$('#delete-data').find("button[type='submit']").click(function(){
				//window.location.href=$('#delete-btn').attr('data-url')+"?ids="+no2Code(arr_id);
				window.location.href="delete?ids="+no2Code(arr_id);
			});
			//所有模态框居中显示
			$('.modal-dialog-center').parent().on('shown.bs.modal',function(){
				var modal_top = $(window).height()/2 - $(this).find('.modal-dialog').height()/2;
				$(this).animate({
					top:modal_top+'px'
				},200);
			});
			//假初始化选中按钮状态
			selectr();
	});
