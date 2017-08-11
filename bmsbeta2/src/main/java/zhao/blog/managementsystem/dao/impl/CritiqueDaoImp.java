package zhao.blog.managementsystem.dao.impl;


import java.util.List;

import org.springframework.stereotype.Repository;

import zhao.blog.managementsystem.dao.CritiqueDao;
import zhao.blog.managementsystem.entity.Critique;

@Repository
public class CritiqueDaoImp extends BaseDaoImpl<Critique> implements CritiqueDao {

	/* (non-Javadoc)
	 * @see zhao.blog.managementsystem.dao.CritiqueDao#selectCritiquesByUserId(int)
	 */
	@Override
	public List<Critique> selectCritiquesByUserId(int userId) {
		return selectCriteria4Entity("from Critique where user.id = ?", userId);
	}
	
}
