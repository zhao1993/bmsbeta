package zhao.blog.managementsystem.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import zhao.blog.managementsystem.dao.ArticleDao;
import zhao.blog.managementsystem.entity.Article;

@Repository
public class ArticleDaoImpl extends BaseDaoImpl<Article> implements ArticleDao {

	/* (non-Javadoc)
	 * @see zhao.blog.managementsystem.dao.ArticleDao#queryGroup(java.lang.String)
	 */
	@Override
	public List<Object> queryGroup(String groupStr) {
		String hql = new StringBuffer("SELECT ")
				.append(groupStr)
				.append(" FROM Article WHERE ")
				.append(groupStr).append(" IS NOT NULL ")
				.append("GROUP BY ")
				.append(groupStr).toString();
		return super.selectCriteria4Object(hql);
	}
}
