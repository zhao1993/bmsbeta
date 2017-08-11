package zhao.blog.managementsystem.util;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;

public class Parser {
	private static Logger logger = Logger.getLogger(Parser.class);
	/**
	 * 将一个字符串按照指定规则 解析成数字集合（类似于 String.split方法） 
	 * @param strs 需要解析的字符串
	 * @param regex 解析的 规则
	 * @return 返回一个数字集合 
	 * @throws 并不会抛出异常,而是会返回一个为空的集合
	 */
	public static List<Integer> str2IntLi(String strs ,String regex){
		String[] arrs = strs.split(regex);
		List<Integer> intarr = new ArrayList<Integer>();
		for (String str : arrs) {
			try{
				intarr.add(Integer.valueOf(str));
			}catch(NumberFormatException e){
				logger.error("在字符串转数组时发生异常："+e);
				intarr.clear();
				return intarr;
			}
		}
		return intarr;
	}
	public static int[] str2IntL(String strs,String regex){
		List<Integer> intlis = Parser.str2IntLi(strs, regex);
		int[] ints = new int[intlis.size()];
		for (int i = 0; i < ints.length; i++) {
			ints[i] = intlis.get(i);
		}
		return ints;
	}
}
