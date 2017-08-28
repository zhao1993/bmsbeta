package zhao.blog.managementsystem.service.impl;


import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import zhao.blog.managementsystem.constant.CritiqueType;
import zhao.blog.managementsystem.dao.ArticleDao;
import zhao.blog.managementsystem.entity.Article;
import zhao.blog.managementsystem.entity.Critique;
import zhao.blog.managementsystem.entity.User;
import zhao.blog.managementsystem.service.ArticleService;
import zhao.blog.managementsystem.service.CritiqueService;
import zhao.blog.managementsystem.service.UserService;
import zhao.blog.managementsystem.util.DateUtil;

@Service
@Transactional
public class ArticleServiceImpl extends BaseServiceImpl<Article> implements ArticleService {
	@Resource
	private ArticleDao articleDaoImpl;
	@Resource
	private CritiqueService critiqueServiceImpl;
	@Resource
	private UserService userServiceImpl;
	
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

	@Override
	public boolean addCritique(Integer cid, Integer aid, Integer uid, String val, CritiqueType type) {
		try {
			Critique critique1 = critiqueServiceImpl.selectById(cid);
			User user = userServiceImpl.selectById(uid);
			Critique critique = new Critique();
			critique.setUser(user);
			critique.setArticleId(aid);
			critique.setCritique(critique1);
			critique.setTime(DateUtil.getTime4Sql());
			critique.setType(type.name());
			critique.setContent(val); 
			critiqueServiceImpl.save(critique);
			return true;
		} catch (Exception e) {
			System.out.println(e);
			return false;
		}
	}

	
}
