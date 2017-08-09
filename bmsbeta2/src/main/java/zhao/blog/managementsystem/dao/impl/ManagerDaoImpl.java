package zhao.blog.managementsystem.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import zhao.blog.managementsystem.dao.ManagerDao;
import zhao.blog.managementsystem.entity.Manager;

@Repository
public class ManagerDaoImpl extends BaseDaoImpl<Manager> implements ManagerDao {
	@Override
	public List<Manager> queryLogin(String account, String password) {
		return  super.selectCriteria4Entity("FROM Manager WHERE account=? AND password=?", account,password);
	}
	
}
