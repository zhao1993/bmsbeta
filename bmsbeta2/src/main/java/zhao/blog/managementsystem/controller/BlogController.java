package zhao.blog.managementsystem.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/blog")
public class BlogController {
	
	@RequestMapping("/bms/queryset4bms")
	public ModelAndView querySet4bms() throws Exception{
		return new ModelAndView("bms/system-setting");
	}
	
	@RequestMapping("/bui/queryset4bui")
	public ModelAndView querySet4bui() throws Exception{
		return new ModelAndView("bms");
	}
	@RequestMapping("/bui/index")
	public ModelAndView index() throws Exception{
		return new ModelAndView("bui/index");
	}
	@RequestMapping("/bui/test")
	public ModelAndView test(String url){
		return new ModelAndView(url);
	}
}
