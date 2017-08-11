package zhao.blog.managementsystem.dao;



import java.util.List;

import zhao.blog.managementsystem.entity.Critique;

public interface CritiqueDao extends BaseDao<Critique> {

	/**
	 * 根据用户id查询其回复内容列表
	 * @param userId 用户的id
	 * @return 回复对象集合
	 */
	List<Critique> selectCritiquesByUserId(int userId);
	
}
