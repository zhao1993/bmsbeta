package zhao.blog.managementsystem.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import zhao.blog.managementsystem.constant.ManagerState;
import zhao.blog.managementsystem.entity.Manager;
import zhao.blog.managementsystem.service.ManagerService;

@Controller
@RequestMapping("bms/manage")
public class ManagerController {
	@Resource
	private ManagerService managerServiceImpl;
	private Manager manager;
	
	@RequestMapping("/login")
	public String managerLogin(String account,String password){
		if(managerServiceImpl.login(account, password)==ManagerState.SUCCESS){
			return "user-manage";
		}
		return "manage-login";
	}
	/**
	 * @return the manager
	 */
	public Manager getManager() {
		return manager;
	}

	/**
	 * @param manager the manager to set
	 */
	public void setManager(Manager manager) {
		this.manager = manager;
	}
}
