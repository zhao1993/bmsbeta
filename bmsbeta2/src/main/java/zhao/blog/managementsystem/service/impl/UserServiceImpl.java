package zhao.blog.managementsystem.service.impl;


import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import zhao.blog.managementsystem.dao.UserDao;
import zhao.blog.managementsystem.entity.User;
import zhao.blog.managementsystem.service.UserService;

@Service
@Transactional
public class UserServiceImpl extends BaseServiceImpl<User> implements UserService {
	@Resource private UserDao userDaoImpl;
	/* (non-Javadoc)
	 * @see zhao.blog.managementsystem.service.impl.BaseServiceImpl#selectAll()
	 */
	public List<User> selectAll(){
		return userDaoImpl.selectAll();
	}
}
