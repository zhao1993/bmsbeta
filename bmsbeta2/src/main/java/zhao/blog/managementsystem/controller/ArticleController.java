package zhao.blog.managementsystem.controller;

import java.io.File;
import java.io.OutputStream;
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
import zhao.blog.managementsystem.constant.FolderAndFile;
import zhao.blog.managementsystem.entity.Article;
import zhao.blog.managementsystem.service.ArticleService;
import zhao.blog.managementsystem.util.FileUtil;
import zhao.blog.managementsystem.util.DateUtil;
import zhao.blog.managementsystem.util.Parser;

@Controller
@RequestMapping("/article")
public class ArticleController {
	@Resource
	private ArticleService articleServiceImpl;

	@RequestMapping("/toadd")
	public ModelAndView toAdd() throws Exception {
		ModelAndView modelAndView = new ModelAndView("bms/article-manage-add-edit");
		modelAndView.addObject("types", articleServiceImpl.queryType());
		return modelAndView;
	}

	@RequestMapping("/add")
	public ModelAndView add(Article article, @RequestParam("file") CommonsMultipartFile file,
			HttpServletRequest request) throws Exception {
		if (null != file.getFileItem().getString() && !"".equals(file.getFileItem().getString()))
			article.setImage(FileUtil.UpLoad(request, file, FolderAndFile.ARTICLE_FOLDER));
		else
			//这里准备用默认文章配图路径
			article.setImage(articleServiceImpl.selectById(article.getId()).getImage());
		article.setTime(DateUtil.getTime4J());
		article.setFinaltime(DateUtil.getTime4J());
		articleServiceImpl.save(article);
		ModelAndView modelAndView = new ModelAndView("redirect:query");
		modelAndView.addObject("pagenum", request.getSession().getAttribute("nowPage"));
		return modelAndView;
	}

	@RequestMapping("/delete")
	public ModelAndView delete(String ids, HttpSession session) throws Exception {
		articleServiceImpl.deleteByIds(Parser.str2IntL(ids, "-"));
		ModelAndView modelAndView = new ModelAndView("redirect:query");
		modelAndView.addObject("pagenum", session.getAttribute("nowPage"));
		return modelAndView;
	}

	@RequestMapping("/toupdate")
	public ModelAndView query4Update(int id) throws Exception {
		ModelAndView modelAndView = new ModelAndView("bms/article-manage-add-edit");
		modelAndView.addObject("types", articleServiceImpl.queryType());
		modelAndView.addObject("article", articleServiceImpl.selectById(id));
		return modelAndView;
	}

	@RequestMapping("/update")
	public ModelAndView update(@ModelAttribute("form") Article article, @RequestParam("file") CommonsMultipartFile file,
			HttpServletRequest request) throws Exception {
		if (null != file.getFileItem().getString() && !"".equals(file.getFileItem().getString()))
			article.setImage(FileUtil.UpLoad(request, file, FolderAndFile.ARTICLE_FOLDER));
		else
			article.setImage(articleServiceImpl.selectById(article.getId()).getImage());
		article.setTime(articleServiceImpl.selectById(article.getId()).getTime());
		article.setFinaltime(DateUtil.getTime4J());
		articleServiceImpl.update(article);
		ModelAndView modelAndView = new ModelAndView("redirect:query");
		modelAndView.addObject("pagenum", request.getSession().getAttribute("nowPage"));
		return modelAndView;
	}

	@RequestMapping("/query")
	public ModelAndView query(@RequestParam(required = false) Integer pagenum,
			@RequestParam(required = false) Integer pagesize, HttpSession session) throws Exception {
		session.setAttribute("nowPage", null == pagenum || pagenum < 1 ? Common.DEFAULT_PAGE_NOW : pagenum);
		ModelAndView modelAndView = new ModelAndView("bms/article-manage");
		modelAndView.addObject("articles", articleServiceImpl.selectByPage(pagenum, pagesize));
		modelAndView.addObject("maxPage", articleServiceImpl.allPage(pagesize));
		return modelAndView;
	}

	@RequestMapping("/queryimage")
	public void queryImage(String image, HttpServletRequest request, HttpServletResponse response) throws Exception {
		response.setHeader("content-Disposition", "filename=" + FileUtil.opDownloadFileName(image, request));
		String realPath = FileUtil.getRealPath(FolderAndFile.ARTICLE_FOLDER, request);
		OutputStream outputStream = response.getOutputStream();
		FileUtils.copyFile(new File(realPath, image), outputStream);
		outputStream.close();
	}
}
