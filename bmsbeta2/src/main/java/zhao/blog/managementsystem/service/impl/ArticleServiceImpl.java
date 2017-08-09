package zhao.blog.managementsystem.service.impl;


import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import zhao.blog.managementsystem.dao.ArticleDao;
import zhao.blog.managementsystem.entity.Article;
import zhao.blog.managementsystem.service.ArticleService;

@Service
@Transactional
public class ArticleServiceImpl extends BaseServiceImpl<Article> implements ArticleService {
	@Resource
	private ArticleDao articleDaoImpl;
	
	public List<Article> selectAll(){
		return  articleDaoImpl.selectAll();
	}

	/* (non-Javadoc)
	 * @see zhao.blog.managementsystem.service.ArticleService#queryType()
	 */
	@Override
	public List<Object> queryType() {
		return articleDaoImpl.queryGroup("type");
	}

	
}
