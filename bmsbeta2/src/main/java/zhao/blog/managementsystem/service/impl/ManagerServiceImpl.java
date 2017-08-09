package zhao.blog.managementsystem.service.impl;


import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import zhao.blog.managementsystem.constant.ManagerState;
import zhao.blog.managementsystem.dao.ManagerDao;
import zhao.blog.managementsystem.entity.Manager;
import zhao.blog.managementsystem.service.ManagerService;

@Service
public class ManagerServiceImpl extends BaseServiceImpl<Manager> implements ManagerService {
	@Resource
	private ManagerDao managerDaoImpl;

	@Override
	public ManagerState login(String account, String password) {
		List<Manager> maList = managerDaoImpl.queryLogin(account, password);
		if(maList.size()!=1){
			logger.error(new StringBuffer().append("账号[").append(account).append("] 密码[").append(password).append("]验证失败 ：没有查询到对应数据或者 查询数据结果不唯一！"));
			return ManagerState.FAILED;
		}
		return ManagerState.SUCCESS;
	}
	
}
