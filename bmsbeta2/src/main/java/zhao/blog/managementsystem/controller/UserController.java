package zhao.blog.managementsystem.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import zhao.blog.managementsystem.constant.Common;
import zhao.blog.managementsystem.entity.User;
import zhao.blog.managementsystem.service.UserService;
import zhao.blog.managementsystem.util.Parser;

@Controller
@RequestMapping("user")
public class UserController {
	@Resource
	private UserService userServiceImpl;

	@RequestMapping("/bms/all")
	public ModelAndView selectAll(){
		return new ModelAndView("bms/user-manage","userslist", userServiceImpl.selectAll());
	}
	
	@RequestMapping("/bms/delete")
	public ModelAndView delete(String ids,HttpSession session){
		userServiceImpl.deleteByIds(Parser.str2IntL(ids, "-"));
		ModelAndView modelAndView = new ModelAndView("redirect:query");
		modelAndView.addObject("pagenum",session.getAttribute("nowPage"));
		return modelAndView;
	}
	
	@RequestMapping("/bms/toupdate")
	public ModelAndView query4Update(int id){
		return new ModelAndView("bms/user-manage-edit","user",userServiceImpl.selectById(id));
	}
	
	@RequestMapping("/bms/update")
	public ModelAndView update(@ModelAttribute("form") User user,HttpSession session){
		userServiceImpl.update(user);
		ModelAndView modelAndView = new ModelAndView("redirect:query");
		modelAndView.addObject("pagenum", session.getAttribute("nowPage"));
		return modelAndView;
	}
	
	@RequestMapping("/bms/query")
	public ModelAndView query(
			@RequestParam(required=false) Integer pagenum,
			@RequestParam(required=false) Integer pagesize,
			HttpSession session){
		session.setAttribute("nowPage",null==pagenum||pagenum<1?Common.DEFAULT_PAGE_NOW:pagenum);
		ModelAndView modelAndView = new ModelAndView("bms/user-manage");
		modelAndView.addObject("userslist",userServiceImpl.select4Page(pagenum, pagesize));
		modelAndView.addObject("maxPage",userServiceImpl.allPage(pagesize));
		return modelAndView;
	}
}
