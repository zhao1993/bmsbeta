package zhao.blog.managementsystem.controller;

import java.util.List;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import zhao.blog.managementsystem.constant.Common;
import zhao.blog.managementsystem.entity.Daily;
import zhao.blog.managementsystem.service.DailyService;
import zhao.blog.managementsystem.util.DateUtil;
import zhao.blog.managementsystem.util.Parser;

@Controller
@RequestMapping("/daily")
public class DailyController {
	@Resource
	private DailyService dailyServiceImpl;

	@RequestMapping("/toadd")
	public ModelAndView toAdd() throws Exception {
		ModelAndView modelAndView = new ModelAndView("daily-manage-add-edit");
		return modelAndView;
	}

	@RequestMapping("/add")
	public ModelAndView add(Daily daily,HttpServletRequest request) throws Exception {
		daily.setTime(DateUtil.getTime4J());
		dailyServiceImpl.save(daily);
		ModelAndView modelAndView = new ModelAndView("redirect:query");
		modelAndView.addObject("pagenum", request.getSession().getAttribute("nowPage"));
		return modelAndView;
	}

	@RequestMapping("/delete")
	public ModelAndView delete(String ids, HttpSession session) throws Exception {
		dailyServiceImpl.deleteByIds(Parser.str2IntL(ids, "-"));
		ModelAndView modelAndView = new ModelAndView("redirect:query");
		modelAndView.addObject("pagenum", session.getAttribute("nowPage"));
		return modelAndView;
	}

	@ResponseBody
	@RequestMapping("/toupdate")
	public Daily query4Update(int id) throws Exception {
		return dailyServiceImpl.selectById(id);
	}

	@RequestMapping("/update")
	public ModelAndView update(
			@ModelAttribute("form") Daily daily,
			HttpServletRequest request) throws Exception {
		daily.setTime(dailyServiceImpl.selectById(daily.getId()).getTime());
		dailyServiceImpl.update(daily);
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
		ModelAndView modelAndView = new ModelAndView("daily-manage");
		modelAndView.addObject("dailys", dailyServiceImpl.selectByPage(pagenum, pagesize));
		modelAndView.addObject("maxPage", dailyServiceImpl.allPage(pagesize));
		return modelAndView;
	}
}
