package zhao.blog.managementsystem.dao;



import java.util.List;

import zhao.blog.managementsystem.entity.Article;

public interface ArticleDao extends BaseDao<Article> {

	/**
	 * 根据指定的字段（类属性）查询 出一个分组集合
	 * @param groupStr 指定的属性
	 * @return 返回数据中的指定属性所有结果集合
	 */
	List<Object> queryGroup(String groupStr);
	
}
