package zhao.blog.managementsystem.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import zhao.blog.managementsystem.entity.Critique;

@Controller
@RequestMapping("/blog")
public class BlogController {
	
	@RequestMapping("/queryset4bms")
	public ModelAndView querySet4bms() throws Exception{
		return new ModelAndView("bms/system-setting");
	}
	
	@RequestMapping("/queryset4bui")
	public ModelAndView querySet4bui() throws Exception{
		return new ModelAndView("bms");
	}
	@RequestMapping("/index")
	public ModelAndView index() throws Exception{
		return new ModelAndView("bui/index");
	}
	@RequestMapping("/test")
	public ModelAndView test(String url){
		return new ModelAndView(url);
	}
}
