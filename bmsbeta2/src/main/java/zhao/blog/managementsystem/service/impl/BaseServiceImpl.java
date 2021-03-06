/**
 * 
 */
package zhao.blog.managementsystem.service.impl;

import java.util.List;


import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import zhao.blog.managementsystem.constant.Common;
import zhao.blog.managementsystem.dao.BaseDao;
import zhao.blog.managementsystem.service.BaseService;

@Service
public class BaseServiceImpl<T> implements BaseService<T> {
	@Autowired
	private BaseDao<T> baseDaoImpl;
	protected final static Logger logger= Logger.getLogger(BaseServiceImpl.class); 
	/* (non-Javadoc)
	 * @see zhao.blog.managementsystem.service.BaseService#save(java.lang.Object)
	 */
	@Override
	public void save(T t) {
		logger.debug("类型["+baseDaoImpl.getClass()+"] 进行数据添加 添加数据[ "+t+" ]");
		baseDaoImpl.save(t);
	}

	/* (non-Javadoc)
	 * @see zhao.blog.managementsystem.service.BaseService#saveAll(java.util.List)
	 */
	@Override
	public void saveAll(List<T> ts) {
		logger.debug("类型["+baseDaoImpl.getClass()+"] 进行批量数据添加  Count :"+ts.size()+"数据[ "+ts+" ]");
		baseDaoImpl.saveAll(ts);
	}

	/* (non-Javadoc)
	 * @see zhao.blog.managementsystem.service.BaseService#deleteById(int)
	 */
	@Override
	public void deleteById(int id) {
		logger.debug("类型["+baseDaoImpl.getClass()+"] 进行数据删除 ID: "+id);
		baseDaoImpl.deleteById(id);
	}
	
	/* (non-Javadoc)
	 * @see zhao.blog.managementsystem.service.BaseService#deleteByIds(int[])
	 */
	@Override
	public void deleteByIds(int... ids) {
		baseDaoImpl.deleteByIds(ids);
	}

	/* (non-Javadoc)
	 * @see zhao.blog.managementsystem.service.BaseService#update(java.lang.Object)
	 */
	@Override
	public void update(T t) {
		logger.debug("类型["+baseDaoImpl.getClass()+"] 进行数据修改 数据类容： "+t.toString());
		baseDaoImpl.update(t);
	}

	/* (non-Javadoc)
	 * @see zhao.blog.managementsystem.service.BaseService#selectById(int)
	 */
	@Override
	public T selectById(int id) {
		logger.debug("类型["+baseDaoImpl.getClass()+"] 根据id查询 ID： "+id);
		return baseDaoImpl.selectById(id);
	}

	/* (non-Javadoc)
	 * @see zhao.blog.managementsystem.service.BaseService#selectAll()
	 */
	@Override
	public List<T> selectAll() {
		logger.debug("类型["+baseDaoImpl.getClass()+"] 进行全部查询");
		return baseDaoImpl.selectAll();
	}

	/* (non-Javadoc)
	 * @see zhao.blog.managementsystem.service.BaseService#dataCount()
	 */
	@Override
	public int dataCount() {
		return baseDaoImpl.dataCount();
	}
	
	
	/* (non-Javadoc)
	 * @see zhao.blog.managementsystem.service.BaseService#allPage(int)
	 */
	@Override
	public int allPage(Integer pagesize) {
		int count = dataCount();
		if(count==0)
			logger.warn("查询到的数据总量为0,这可能对分页可能有影响");
		if(null==pagesize ||pagesize<1){
			logger.warn("pagesize[ "+pagesize+" ]");
			pagesize= Common.DEFAULT_PAGE_SIZE;	
		}
		return count%pagesize==0?count/pagesize:count/pagesize+1;
	}

	/* (non-Javadoc)
	 * @see zhao.blog.managementsystem.service.BaseService#selectAll(java.lang.String, java.lang.Object[])
	 */
	@Override
	public List<T> selectAll(String queryString, Object... params) {
		return baseDaoImpl.selectCriteria4Entity(queryString, params);
	}

	/* (non-Javadoc)
	 * @see zhao.blog.managementsystem.service.BaseService#selectByPage(java.lang.Integer, java.lang.Integer)
	 */
	@Override
	public List<T> select4Page(Integer pagenum, Integer pagesize) {
		if(null==pagesize || pagesize<1){
			pagesize = Common.DEFAULT_PAGE_SIZE;
		}
		int all_page = this.allPage(pagesize);
		if(null==pagenum || pagenum<1){
			pagenum = Common.DEFAULT_PAGE_NOW;
		}
		if(all_page < pagenum){
			pagenum = all_page;
		}
		if(all_page==0)
		return null;
		return baseDaoImpl.select4Page((pagenum-1)*pagesize,pagesize);
	}
	
}
