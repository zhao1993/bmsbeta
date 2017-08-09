package zhao.blog.managementsystem.service;

import java.util.List;

import zhao.blog.managementsystem.entity.Article;

public interface ArticleService extends BaseService<Article> {
	/**
	 * 查询文章的分类信息
	 * @return 返回文章分类集合
	 */
	public List<Object> queryType();
}
