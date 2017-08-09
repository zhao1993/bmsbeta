package zhao.blog.managementsystem.controller;

import java.io.File;
import java.io.OutputStream;
import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.commons.io.FileUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.commons.CommonsMultipartFile;
import org.springframework.web.servlet.ModelAndView;

import zhao.blog.managementsystem.constant.Common;
import zhao.blog.managementsystem.constant.Folder;
import zhao.blog.managementsystem.entity.Album;
import zhao.blog.managementsystem.service.AlbumService;
import zhao.blog.managementsystem.util.FileUtil;
import zhao.blog.managementsystem.util.Parser;

@Controller
@RequestMapping("album")
public class AlbumController {
	@Resource
	private AlbumService albumServiceImpl;
	
	@RequestMapping("/toadd")
	public ModelAndView toAdd() throws Exception {
		ModelAndView modelAndView = new ModelAndView("album-manage-add-edit");
		return modelAndView;
	}

	@RequestMapping("/add")
	public ModelAndView add(Album album, @RequestParam("file") CommonsMultipartFile file,
			HttpServletRequest request) throws Exception {
		albumServiceImpl.save(album);
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
		//modelAndView.addObject("types", albumServiceImpl.queryType());
		modelAndView.addObject("article", albumServiceImpl.selectById(id));
		return modelAndView;
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
		String realPath = FileUtil.getRealPath(Folder.ARTICLE_FOLDER, request);
		OutputStream outputStream = response.getOutputStream();
		FileUtils.copyFile(new File(realPath, image), outputStream);
		outputStream.close();
	}
}
