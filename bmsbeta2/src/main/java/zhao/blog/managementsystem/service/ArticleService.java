package zhao.blog.managementsystem.service;

import java.util.List;

import zhao.blog.managementsystem.constant.CritiqueType;
import zhao.blog.managementsystem.entity.Article;

public interface ArticleService extends BaseService<Article> {
	/**
	 * 查询文章的分类信息
	 * @return 返回文章分类集合
	 */
	public List<Object> queryType();

	/**
	 * 添加一条评论 
	 * @param cid 楼层id
	 * @param aid 文章id
	 * @param uid 用户id
	 * @param val 回复内容
	 * @param article 所属类型
	 * @return 成功保存返回true'
	 */
	public boolean addCritique(Integer cid, Integer aid, Integer uid, String val, CritiqueType article);
}
