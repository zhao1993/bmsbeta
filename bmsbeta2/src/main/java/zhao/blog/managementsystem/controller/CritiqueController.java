package zhao.blog.managementsystem.controller;


import javax.annotation.Resource;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import zhao.blog.managementsystem.constant.Common;
import zhao.blog.managementsystem.service.CritiqueService;
import zhao.blog.managementsystem.util.Parser;

@Controller
@RequestMapping("critique")
public class CritiqueController {
	@Resource
	private CritiqueService critiqueServiceImpl;

	//?????
	@RequestMapping("/all")
	public ModelAndView selectAll(){
		return new ModelAndView("bms/critique-manage","critiqueslist", critiqueServiceImpl.selectAll());
	}
	
	@RequestMapping("/delete")
	public ModelAndView delete(String ids,HttpSession session){
		critiqueServiceImpl.deleteByIds(Parser.str2IntL(ids, "-"));
		ModelAndView modelAndView = new ModelAndView("redirect:query");
		modelAndView.addObject("pagenum",session.getAttribute("nowPage"));
		return modelAndView;
	}
	@RequestMapping("/query")
	public ModelAndView query(
			@RequestParam(required=false) Integer pagenum,
			@RequestParam(required=false) Integer pagesize,
			HttpSession session){
		session.setAttribute("nowPage",null==pagenum||pagenum<1?Common.DEFAULT_PAGE_NOW:pagenum);
		ModelAndView modelAndView = new ModelAndView("bms/critique-manage");
		modelAndView.addObject("critiqueslist",critiqueServiceImpl.selectByPage(pagenum, pagesize));
		modelAndView.addObject("maxPage",critiqueServiceImpl.allPage(pagesize));
		return modelAndView;
	}
}
