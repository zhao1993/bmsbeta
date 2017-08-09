package zhao.blog.managementsystem.util;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Date;

import com.mysql.jdbc.Connection;

public class DateUtil {
	
	/**
	 * 获取网络时间 
	 * @return 返回能够适配数据库的时间对象;如果获取不到网络时间将会获取本地时间
	 */
	public static Date getTime4Sql(){
		return new Date(getTime4J().getTime());
	}
	/**
	 * 获取网络时间 
	 * @return 返回适配普通的date对象;如果获取不到网络时间将会获取本地时间
	 */
	public static java.util.Date getTime4J(){
		try {
			URL url = new URL("http://www.baidu.com");
			HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
			long date = urlConnection.getDate();
			return new java.util.Date(date);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return new java.util.Date();
	}
	
	public static void main(String[] args) {
		System.out.println(getTime4J());
		System.out.println(getTime4Sql());
	}
}
