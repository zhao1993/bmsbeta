package zhao.blog.managementsystem.dao.impl;


import java.util.List;
import org.springframework.stereotype.Repository;
import zhao.blog.managementsystem.dao.CritiqueDao;
import zhao.blog.managementsystem.entity.Critique;

@Repository
public class CritiqueDaoImp extends BaseDaoImpl<Critique> implements CritiqueDao {

	@Override
	public List<Critique> selectCritiquesByUserId(int userId) {
		return selectCriteria4Entity("from Critique where user.id = ?", userId);
	}
	@Override
	public List<Critique> selectByPage4Init(Integer firstResult, Integer maxResult) {
		return select4PageByCriteria(firstResult, maxResult, "from Critique where critique=null order by id desc");
	}
	@Override
	public List<Critique> selectCritiquesByDeck(Integer id) {
		return selectCriteria4Entity("from Critique where critique.id = ?", id);
	}
}
