package zhao.blog.managementsystem.dao.impl;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import zhao.blog.managementsystem.dao.BaseDao;
@Repository
public class BaseDaoImpl<T> implements BaseDao<T> {
	protected Class<T> clazz;
	protected String simpleName;
	@Autowired
	protected SessionFactory sessionFactory;
	@SuppressWarnings("unchecked")
	public BaseDaoImpl() {
		Type type = this.getClass().getGenericSuperclass();
		if(type instanceof ParameterizedType){
			Type[] types = ((ParameterizedType) type).getActualTypeArguments();
			this.clazz = (Class<T>) types[0];
			simpleName = this.clazz.getSimpleName();
		}
	}
	/**
	 * @return the clazz
	 */
	public Class<T> getClazz() {
		return clazz;
	}
	/* (non-Javadoc)
	 * @see zhao.blog.managementsystem.dao.BaseDao#save(java.lang.Object)
	 */
	@Override
	public void save(T t) {
		sessionFactory.getCurrentSession().save(t);
		flush();
	}

	/* (non-Javadoc)
	 * @see zhao.blog.managementsystem.dao.BaseDao#saveAll(java.util.List)
	 */
	@Override
	public void saveAll(List<T> ts) {
		for (T t : ts) this.save(t);
	}

	/* (non-Javadoc)
	 * @see zhao.blog.managementsystem.dao.BaseDao#deleteById(int)
	 */
	@Override
	public void deleteById(int id) {
		sessionFactory.getCurrentSession().delete(this.selectById(id));
		flush();
	}

	/* (non-Javadoc)
	 * @see zhao.blog.managementsystem.dao.BaseDao#deleteByIds(int[])
	 */
	@Override
	public void deleteByIds(int... ids) {
		for (int id : ids) {
			this.deleteById(id);
		}
	}
	/* (non-Javadoc)
	 * @see zhao.blog.managementsystem.dao.BaseDao#update(java.lang.Object)
	 */
	@Override
	public void update(T t) {
		sessionFactory.getCurrentSession().merge(t);
		flush();
	}

	/* (non-Javadoc)
	 * @see zhao.blog.managementsystem.dao.BaseDao#selectById(int)
	 */
	@SuppressWarnings("unchecked")
	@Override
	public T selectById(int id) {
		return (T) sessionFactory.getCurrentSession().get(clazz, id);
	}

	/* (non-Javadoc)
	 * @see zhao.blog.managementsystem.dao.BaseDao#selectAll()
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<T> selectAll() {
		return sessionFactory.getCurrentSession().createQuery("FROM "+simpleName).list();
	}
	
	/* (non-Javadoc)
	 * @see zhao.blog.managementsystem.dao.BaseDao#selectByColumn(java.lang.String, java.lang.String)
	 */
	@Override
	public List<T> selectByColumn(String column, String value) {
		return selectCriteria4Entity(new StringBuffer("From ") .append(simpleName) .append(" where ") .append(column) .append("= ?").toString(),value); 
	}
	/* (non-Javadoc)
	 * @see zhao.blog.managementsystem.dao.BaseDao#selectCriteria(java.lang.String, java.lang.Object[])
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<T> selectCriteria4Entity(String queryString, Object... parameters) {
		Query query = sessionFactory.getCurrentSession().createQuery(queryString);
		for (int i = 0; i < parameters.length; i++) 
			query.setParameter(i, parameters[i]);
		return query.list();
	}
	
	/* (non-Javadoc)
	 * @see zhao.blog.managementsystem.dao.BaseDao#selectCriteria4Object(java.lang.String, java.lang.Object[])
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Object> selectCriteria4Object(String queryString, Object... parameters) {
		Query query = sessionFactory.getCurrentSession().createQuery(queryString);
		for (int i = 0; i < parameters.length; i++) 
			query.setParameter(i, parameters[i]);
		return query.list();
	}
	/* (non-Javadoc)
	 * @see zhao.blog.managementsystem.dao.BaseDao#selectCriteria(int, int)
	 */
	@Override
	public List<T> select4Page(int firstResult, int maxResult) {
		return select4PageByCriteria(firstResult, maxResult, "FROM "+simpleName);
	}

	/* (non-Javadoc)
	 * @see zhao.blog.managementsystem.dao.BaseDao#select4PageByCriteria(int, int, java.lang.String, java.lang.String[])
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<T> select4PageByCriteria(int firstResult, int maxResult, String hql, String... params) {
		Query query = sessionFactory.getCurrentSession().createQuery(hql);
		for (int i = 0; i < params.length; i++) {
			query.setParameter(i+1, params[i]);
		}
		return query.setFirstResult(firstResult).setMaxResults(maxResult).list();
	}
	/* (non-Javadoc)
	 * @see zhao.blog.managementsystem.dao.BaseDao#dataCount()
	 */
	@Override
	public int dataCount() {
		return  (int) selectAll().size();
	}
	
	protected void flush(){
		sessionFactory.getCurrentSession().flush();
	}
}
