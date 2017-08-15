package zhao.blog.managementsystem.util;

import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.codec.binary.Base64;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

public class FileUtil {
	
	
	/**
	 * springMVC 的文件上传
	 * @param request 请求对象
	 * @param file 需要上传的文件 
	 * @param dir 文件目录名称
	 * @return 返回uuid作为key 文件名作为value的oneMap对象
	 */
	public static OneMap<String,String> upLoadm(HttpServletRequest request,CommonsMultipartFile file,String dir){
		return new OneMap<String, String>(FileUtil.UpLoad(request, file, dir), file.getFileItem().getName());
	}
	
	/**
	 * springMVC 的文件上传
	 * @param request 请求对象
	 * @param file 需要上传的文件 
	 * @param dir 文件目录名称
	 * @return 返回成功上传的文件的名字 [带路径][经过UUID处理的文件名字](异常被捕获但不做任何处理！)
	 */
	public static String UpLoad(HttpServletRequest request,CommonsMultipartFile file,String dir){
		String filename = UUID.randomUUID()+getExtension(file.getOriginalFilename());
		File fileTarget = new File(FileUtil.getRealPath(dir, request),filename);
		try {
			file.transferTo(fileTarget);
		} catch (IllegalStateException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return filename;
	}
	/**
	 * 获取文件的扩展名
	 * @param fileName 文件名
	 * @return 返回扩展名   带[.] 如果没有获取到扩展名返回null  
	 */
	public static String getExtension(String fileName){
		if(null!=fileName && -1!=fileName.lastIndexOf(".")){
			return fileName.substring(fileName.lastIndexOf(".")-1);
		}
		return null;
	}
	/**
	 * 获取指定路径在服务器中的真实路径 不存在则会创建
	 * @param path 需要获取的路径
	 * @return 返回真路径
	 */
	public static String getRealPath(String path,HttpServletRequest request){
		String realPath  = request.getSession().getServletContext().getRealPath(path);
		File f = new File(realPath);
		if(!f.exists()){
			f.mkdirs();
		}
		return realPath;
	}
	/**
     * 根据不同浏览器的版本设置下载文件名
     * @param downloadFileName 下载源文件名称
     */
    public static String opDownloadFileName(String fileName,HttpServletRequest request) {
        try {
            if (request.getHeader("User-Agent").toLowerCase().indexOf("firefox") > 0) {//火狐浏览器
            	fileName = "=?UTF-8?B?"+(new String(Base64.encodeBase64(fileName.getBytes("UTF-8")))) + "?=";
            } else {				//其它浏览器
            	fileName = URLEncoder.encode(fileName, "UTF-8");
            }
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return fileName;
    }
}
