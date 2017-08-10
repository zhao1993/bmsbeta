package zhao.blog.managementsystem.controller;

import java.io.File;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.FileUtils;
import org.springframework.http.converter.json.GsonFactoryBean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;

import zhao.blog.managementsystem.constant.Common;
import zhao.blog.managementsystem.constant.Folder;
import zhao.blog.managementsystem.entity.Album;
import zhao.blog.managementsystem.entity.Photo;
import zhao.blog.managementsystem.service.AlbumService;
import zhao.blog.managementsystem.service.PhotoService;
import zhao.blog.managementsystem.util.DateUtil;
import zhao.blog.managementsystem.util.FileUtil;
import zhao.blog.managementsystem.util.Parser;

@Controller
@RequestMapping("album")
public class AlbumController {
	@Resource
	private AlbumService albumServiceImpl;
	@Resource
	private PhotoService photoServiceImpl; 
	
	@RequestMapping("/toadd")
	public ModelAndView toAdd() throws Exception {
		ModelAndView modelAndView = new ModelAndView("album-manage-add-edit");
		return modelAndView;
	}

	@RequestMapping("/add")
	public ModelAndView add(HttpServletRequest request,
			Album album, 
			@RequestParam("file") CommonsMultipartFile[] file ) throws Exception {
		album.setTime(DateUtil.getTime4J());
		albumServiceImpl.save(album);
		album.setImage(savePhoto(request, album, file).getImage());
		albumServiceImpl.update(album);
		ModelAndView modelAndView = new ModelAndView("redirect:query");
		modelAndView.addObject("pagenum", request.getSession().getAttribute("nowPage"));
		return modelAndView;
	}

	@RequestMapping("/delete")
	public ModelAndView delete(String ids, HttpSession session) throws Exception {
		List<Integer> arrid = Parser.str2IntL(ids, "-");
		for (Integer id : arrid) {
			albumServiceImpl.deleteById(id);
		}
		ModelAndView modelAndView = new ModelAndView("redirect:query");
		modelAndView.addObject("pagenum", session.getAttribute("nowPage"));
		return modelAndView;
	}

	@RequestMapping("/toupdate")
	public ModelAndView query4Update(int id) throws Exception {
		ModelAndView modelAndView = new ModelAndView("album-manage-add-edit");
		modelAndView.addObject("album", albumServiceImpl.selectById(id));
		return modelAndView;
	}
	@ResponseBody
	@RequestMapping("/queryphotos")
	public List<Photo> queryPhotosByAlbumId(int id){
		List<Photo> list = photoServiceImpl.selectPhotosByAlbumId(id);
		/*List<String> imagePathStrs = new ArrayList<String>(list.size());
		for (Photo photo : list) {
			imagePathStrs.add(photo.getImage());
		}
		return imagePathStrs;*/
		return list;
	}
	@RequestMapping("/update")
	public ModelAndView update(
			@ModelAttribute("form") Album album, 
			@RequestParam("file") CommonsMultipartFile file,
			HttpServletRequest request) throws Exception {
		albumServiceImpl.update(album);
		ModelAndView modelAndView = new ModelAndView("redirect:query");
		modelAndView.addObject("pagenum", request.getSession().getAttribute("nowPage"));
		return modelAndView;
	}

	@RequestMapping("/query")
	public ModelAndView query(
			@RequestParam(required = false) Integer pagenum,
			@RequestParam(required = false) Integer pagesize,
			HttpSession session) throws Exception {
		session.setAttribute("nowPage", null == pagenum || pagenum < 1 ? Common.DEFAULT_PAGE_NOW : pagenum);
		ModelAndView modelAndView = new ModelAndView("album-manage");
		modelAndView.addObject("albums", albumServiceImpl.selectByPage(pagenum, pagesize));
		modelAndView.addObject("maxPage", albumServiceImpl.allPage(pagesize));
		return modelAndView;
	}

	@RequestMapping("/queryimage")
	public void queryImage(String image, HttpServletRequest request, HttpServletResponse response) throws Exception {
		response.setHeader("content-Disposition", "filename=" + FileUtil.opDownloadFileName(image, request));
		String realPath = FileUtil.getRealPath(Folder.ALBUM_FOLDER, request);
		OutputStream outputStream = response.getOutputStream();
		FileUtils.copyFile(new File(realPath, image), outputStream);
		outputStream.close();
	}
	
	//其他功能方法
	private List<Photo> savePhotos(HttpServletRequest request,Album album,CommonsMultipartFile... file){
		List<Photo> photos = new ArrayList<Photo>(file.length);
		for (CommonsMultipartFile cmFile : file) {
			String imageName = FileUtil.UpLoad(request, cmFile, Folder.ALBUM_FOLDER);
			Photo photo = new Photo(album, imageName);
			photos.add(photo);
			photoServiceImpl.save(photo);
		}
		return photos;
	}
	//其他功能方法
	private Photo savePhoto(HttpServletRequest request,Album album,CommonsMultipartFile... file){
		List<Photo> photos = new ArrayList<Photo>(file.length);
		for (CommonsMultipartFile cmFile : file) {
			String imageName = FileUtil.UpLoad(request, cmFile, Folder.ALBUM_FOLDER);
			Photo photo = new Photo(album, imageName);
			photos.add(photo);
			photoServiceImpl.save(photo);
		}
		return photos.get(0);
	}
}
