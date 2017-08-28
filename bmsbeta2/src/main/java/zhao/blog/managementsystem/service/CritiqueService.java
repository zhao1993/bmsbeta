package zhao.blog.managementsystem.service;

import java.util.List;

import zhao.blog.managementsystem.entity.Critique;

public interface CritiqueService extends BaseService<Critique> {

	/**
	 * 初始化列表的查询区别在于查询结果不属于任何楼中楼
	 * @param pagenum 页码
	 * @param pagesize 显示数
	 * @return 
	 */
	List<Critique> selectByPage4Init(Integer pagenum, Integer pagesize);

	List<Critique> selectCritiquesByDeck(Integer id);

}
