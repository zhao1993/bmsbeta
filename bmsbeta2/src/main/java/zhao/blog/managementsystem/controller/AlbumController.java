package zhao.blog.managementsystem.controller;

import java.io.File;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;
import zhao.blog.managementsystem.constant.Common;
import zhao.blog.managementsystem.constant.FolderAndFile;
import zhao.blog.managementsystem.entity.Album;
import zhao.blog.managementsystem.entity.Photo;
import zhao.blog.managementsystem.service.AlbumService;
import zhao.blog.managementsystem.service.PhotoService;
import zhao.blog.managementsystem.util.BeanUtil;
import zhao.blog.managementsystem.util.DateUtil;
import zhao.blog.managementsystem.util.FileUtil;
import zhao.blog.managementsystem.util.OneMap;
import zhao.blog.managementsystem.util.Parser;

@Controller
@RequestMapping("album")
public class AlbumController {
	@Resource
	private AlbumService albumServiceImpl;
	@Resource
	private PhotoService photoServiceImpl; 
	
	@RequestMapping("/bms/toadd")
	public ModelAndView toAdd() throws Exception {
		ModelAndView modelAndView = new ModelAndView("bms/album-manage-add-edit");
		return modelAndView;
	}

	@RequestMapping("/bms/add")
	public ModelAndView add(HttpServletRequest request,
			Album album, 
			@RequestParam("file") CommonsMultipartFile[] file ) throws Exception {
		album.setTime(DateUtil.getTime4J());
		albumServiceImpl.save(album);
		Photo photo = savePhoto(request, album, file);
		if(null==photo)
			album.setImage("default.png");
		else
			album.setImage(photo.getImage());
		albumServiceImpl.update(album);
		ModelAndView modelAndView = new ModelAndView("redirect:query");
		modelAndView.addObject("pagenum", request.getSession().getAttribute("nowPage"));
		return modelAndView;
	}
	@ResponseBody
	@RequestMapping("/bms/addphoto")
	public boolean asyncAddPhoto(
			@RequestParam("file") CommonsMultipartFile file,
			@RequestParam("albumid") int id,
			HttpServletRequest request
			){
		savePhoto(request, albumServiceImpl.selectById(id), file);
		return true;
	}
	@RequestMapping("/bms/delete")
	public ModelAndView delete(String ids, HttpSession session) throws Exception {
		albumServiceImpl.deleteByIds(Parser.str2IntL(ids, "-"));
		ModelAndView modelAndView = new ModelAndView("redirect:query");
		modelAndView.addObject("pagenum", session.getAttribute("nowPage"));
		return modelAndView;
	}
	@ResponseBody
	@RequestMapping("/bms/deletephoto")
	public boolean deletePhoto(@RequestParam("key") int photoId){
		photoServiceImpl.deleteById(photoId);
		return true;
	}
	@RequestMapping("/bms/toupdate")
	public ModelAndView query4Update(int id) throws Exception {
		ModelAndView modelAndView = new ModelAndView("bms/album-manage-add-edit");
		modelAndView.addObject("album", albumServiceImpl.selectById(id));
		return modelAndView;
	}
	@RequestMapping("/bms/update")		
	public ModelAndView update(
			@ModelAttribute("form") Album album, 
			@RequestParam("file") CommonsMultipartFile[] file,
			HttpServletRequest request) throws Exception {
		album.setTime(albumServiceImpl.selectById(album.getId()).getTime());
		savePhoto(request, album, file);
		albumServiceImpl.update(album);
		ModelAndView modelAndView = new ModelAndView("redirect:query");
		modelAndView.addObject("pagenum", request.getSession().getAttribute("nowPage"));
		return modelAndView;
	}

	@ResponseBody
	@RequestMapping("/bms/queryphotos")
	public List<Map<String, Object>> queryPhotosByAlbumId(int id){
		List<Map<String,Object>> arrayList = new ArrayList<Map<String,Object>>();
		List<Photo> list = photoServiceImpl.selectPhotosByAlbumId(id);
		for (Photo photo : list) {
			arrayList.add(BeanUtil.bean2Map(photo, "album"));
		}
		return arrayList;
	}
	@RequestMapping("/bms/query")
	public ModelAndView query(
			@RequestParam(required = false) Integer pagenum,
			@RequestParam(required = false) Integer pagesize,
			HttpSession session) throws Exception {
		session.setAttribute("nowPage", null == pagenum || pagenum < 1 ? Common.DEFAULT_PAGE_NOW : pagenum);
		ModelAndView modelAndView = new ModelAndView("bms/album-manage");
		modelAndView.addObject("albums", albumServiceImpl.select4Page(pagenum, pagesize));
		modelAndView.addObject("maxPage", albumServiceImpl.allPage(pagesize));
		return modelAndView;
	}

	@RequestMapping("/bms/queryimage")
	public void queryImage(String image, HttpServletRequest request, HttpServletResponse response) throws Exception {
		response.setHeader("content-Disposition", "filename=" + FileUtil.opDownloadFileName(image, request));
		String realPath = FileUtil.getRealPath(FolderAndFile.ALBUM_FOLDER, request);
		OutputStream outputStream = response.getOutputStream();
		FileUtils.copyFile(new File(realPath, image), outputStream);
		outputStream.close();
	}
	
	@ResponseBody
	@RequestMapping("/bms/alreadyexisted")
	public boolean alreayIsExisted(@RequestParam("ajaxParam") Object ajaxParam) throws Exception{
	 	 return  albumServiceImpl.hasAlbumName(String.valueOf(ajaxParam));
	}
	/***********其他方法*********/
	/**
	 * 返回被保存的图片对象
	 * @param request 请求对象
	 * @param album 
	 * @param file 
	 * @return  
	 */
	private List<Photo> savePhotos(HttpServletRequest request,Album album,CommonsMultipartFile... file){
		List<Photo> photos = new ArrayList<Photo>(file.length);
		for (CommonsMultipartFile cmFile : file) {
			if(cmFile.getSize()>0){
				OneMap<String, String> pn= FileUtil.upLoadm(request, cmFile, FolderAndFile.ALBUM_FOLDER);
				Photo photo = new Photo(album, pn.getKey(),pn.getValue(),null,null,null,DateUtil.getTime4J());
				photos.add(photo);
				photoServiceImpl.save(photo);
			}
		}
		return photos;
	}
	/**
	 * 将图片保存到服务器并且返回第一张存入的图片作为相册封面
	 * @param request 本次会话请求对象
	 * @param album 相册
	 * @param file 前台提交的文件对象
	 * @return 返回一个photo实例
	 */
	private Photo savePhoto(HttpServletRequest request,Album album,CommonsMultipartFile... file){
		List<Photo> photos = savePhotos(request, album, file);
		return photos.size()>0?photos.get(0):null;
	}
}
