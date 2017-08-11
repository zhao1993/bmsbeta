package zhao.blog.managementsystem.util;

import java.lang.reflect.Method;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import zhao.blog.managementsystem.entity.User;

public class BeanUtil {
	
	/**
	 * 将一个bean转换成一个map集合 
	 * @param bean 要转换的bean 
	 * @param excluding 转换中需要排除的类变量
	 * @return 转换好的map集合
	 * @throws Exception 捕获异常但不处理
	 */
	public static Map<String, Object> bean2Map(Object bean,String... excluding){
		Map<String,Object> map = new HashMap<String, Object>();
		Method[] methods = bean.getClass().cast(bean).getClass().getMethods();
		for (Method method : methods) {
			String method_name = method.getName();
			for (String ex : excluding) {
				if(new StringBuffer("get")
						.append(ex.substring(0,1).toUpperCase())
						.append(ex.substring(1)).toString()
						.equals(method_name)){
					
				}
			}
			if(method_name.startsWith("get") && !BeanUtil.inArray(method_name, excluding)){
				String key = method_name.replaceFirst(
						method_name.substring(0,4),
						String.valueOf(method_name.charAt(3)).toLowerCase()
						);
				try {
					map.put(key,method.invoke(bean.getClass().cast(bean)));
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		
		return map;
	}
	private static boolean inArray(String param,String... arr){
		for (String ex : arr) {
			if(new StringBuffer("get")
					.append(ex.substring(0,1).toUpperCase())
					.append(ex.substring(1)).toString()
					.equals(param)){
				return true;
				}
			}
		return false;
	}
	public static void main(String[] args) throws Exception {
		Map<String, Object> bean2Map = bean2Map(new User("1111", "password", "sex", new Date()),"album");
		System.out.println(bean2Map);
	}
}
