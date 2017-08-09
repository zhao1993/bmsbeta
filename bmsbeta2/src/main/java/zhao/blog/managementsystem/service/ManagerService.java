/**
 * 
 */
package zhao.blog.managementsystem.service;

import zhao.blog.managementsystem.constant.ManagerState;
import zhao.blog.managementsystem.entity.Manager;

public interface ManagerService extends BaseService<Manager> {
	/**
	 * 管理员登录验证
	 * @param account 账号
 	 * @param password 密码
	 * @return 返回登录状态 ManagerState其中一种
	 */
	public ManagerState login(String account,String password);
}
