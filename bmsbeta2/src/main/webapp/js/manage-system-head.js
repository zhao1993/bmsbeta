/**
			  * 返回 元素在数组中的下标
			  * function indexOf(arg)
			  * @param arg 
			  * @returns Nmber 如果值不存在则返回-1
			 */  
			Array.prototype.indexOf = function(arg){
				for(var i=0;i<this.length;i+=1){
					if(this[i] == arg) 
						return i;
				}
				return -1;
			}
			/**
			  * 移除 数组中的指定元素
			  * function remove(arg)
			  * @param arg 
			 */  
			Array.prototype.remove = function(arg){
				var index = this.indexOf(arg);
				if(-1 != index){
					this.splice(index,1);
				}
		
		}
			Date.prototype.format = function(){
				return this.getYear()>1900?this.getYear():(this.getYear()+1900)
				+'-'+this.getMonth()
				+'-'+this.getDate()
				+' '
				+this.getHours()
				+':'+this.getMinutes()
				+':'+this.getSeconds();
			}