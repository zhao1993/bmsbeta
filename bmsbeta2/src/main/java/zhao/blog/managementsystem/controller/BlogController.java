package zhao.blog.managementsystem.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

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
}
