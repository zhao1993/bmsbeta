package zhao.blog.managementsystem.dao;


import java.util.List;

import zhao.blog.managementsystem.entity.Manager;

public interface ManagerDao extends BaseDao<Manager> {
	/**
	 * 根据账号密码查询管理员信息
	 * @param account 账号
	 * @param password 密码
	 * @return 返回拥有信息的管理员bean 没有则返回null
	 */
	List<Manager> queryLogin(String account,String password);
}
