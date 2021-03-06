package zhao.blog.managementsystem.controller;


import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import zhao.blog.managementsystem.constant.Common;
import zhao.blog.managementsystem.entity.Critique;
import zhao.blog.managementsystem.entity.User;
import zhao.blog.managementsystem.service.CritiqueService;
import zhao.blog.managementsystem.util.BeanUtil;
import zhao.blog.managementsystem.util.Parser;

@Controller
@RequestMapping("critique")
public class CritiqueController {
	@Resource
	private CritiqueService critiqueServiceImpl;
	
	@RequestMapping("/bms/all")
	public ModelAndView selectAll(){
		return new ModelAndView("bms/critique-manage","critiqueslist", critiqueServiceImpl.selectAll());
	}
	
	@RequestMapping("/bms/delete")
	public ModelAndView delete(String ids,HttpSession session){
		critiqueServiceImpl.deleteByIds(Parser.str2IntL(ids, "-"));
		ModelAndView modelAndView = new ModelAndView("redirect:query");
		modelAndView.addObject("pagenum",session.getAttribute("nowPage"));
		return modelAndView;
	}
	@RequestMapping("/bms/query")
	public ModelAndView query(
			@RequestParam(required=false) Integer pagenum,
			@RequestParam(required=false) Integer pagesize,
			HttpSession session){
		session.setAttribute("nowPage",null==pagenum||pagenum<1?Common.DEFAULT_PAGE_NOW:pagenum);
		ModelAndView modelAndView = new ModelAndView("bms/critique-manage");
		modelAndView.addObject("critiqueslist",critiqueServiceImpl.select4Page(pagenum, pagesize));
		modelAndView.addObject("maxPage",critiqueServiceImpl.allPage(pagesize));
		return modelAndView;
	}
	
	/*前端请求用*/
	@ResponseBody
	@RequestMapping("/bui/initreply")
	public List<Map<String,Object>> init(Object data,
			@RequestParam(required=false) Integer pagenum,
			@RequestParam(required=false) Integer pagesize){
		List<Map<String,Object>> arrayList = new ArrayList<Map<String,Object>>();
		List<Critique> list = critiqueServiceImpl.selectByPage4Init(pagenum, pagesize);
		for (Critique critique : list) {
			User user = critique.getUser();
			Map<String, Object> bean2Map = BeanUtil.bean2Map(critique, "user","critiques","critique");
			bean2Map.put("userid",user.getId());
			bean2Map.put("username",user.getName());
			bean2Map.put("userimg",user.getHeadpic());
			arrayList.add(bean2Map);
		}
		return arrayList;
	}
	@ResponseBody
	@RequestMapping("bui/deckreply")
	public List<Map<String,Object>> deck(Integer id){
		List<Map<String,Object>> arrayList = new ArrayList<Map<String,Object>>();
		List<Critique> list = critiqueServiceImpl.selectCritiquesByDeck(id);
		for (Critique critique : list) {
			User user = critique.getUser();
			Map<String, Object> bean2Map = BeanUtil.bean2Map(critique, "user","critiques","critique");
			bean2Map.put("userid",user.getId());
			bean2Map.put("username",user.getName());
			bean2Map.put("userimg",user.getHeadpic());
			arrayList.add(bean2Map);
		}
		return arrayList;
	}
	
	public List<Map<String,Object>> replys(){
		return null;}
	
}
