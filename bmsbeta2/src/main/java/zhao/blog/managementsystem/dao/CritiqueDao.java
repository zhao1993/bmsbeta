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
	
	/**
	 * 初始化列表的查询区别在于查询结果不属于任何楼中楼
	 * @param pagenum 页码
	 * @param pagesize 显示数
	 * @return 
	 */
	List<Critique> selectByPage4Init(Integer firstResult, Integer maxResult);

	List<Critique> selectCritiquesByDeck(Integer id);
	
}
