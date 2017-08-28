package zhao.blog.managementsystem.service;

import java.util.List;

public interface BaseService<T> {
	/**
	 * 将bean数据保存到数据库
	 * @param t 将要保存的bean
	 */
	void save(T t);
	/**
	 * 将存放在集合中的多个bean对象全部保存到数据库
	 * @param ts 将要进行保存的存放着bean对象的集合
	 */
	void saveAll(List<T> ts);
	/**
	 * 根据id删除某一条数据
	 */
	void deleteById(int id);
	/**
	 * @param ids 根据id数组删除批量数据
	 */
	void deleteByIds(int... ids);
	/**
	 * 将bean对象的变化数据修改到数据库
	 * @param t 将要进行修改的bean对象
	 */
	void update(T t);
	/**
	 * 根据id查询指定信息
	 * @param id 需要查询的数据id
	 * @return 返回一个与id对应的数据信息
	 * 			如果未查询到对应数据信息则会返回一个拥有默认值的bean对象
	 */
	T selectById(int id);
	
	/**
	 * 查询数据库中所有对象bean的数据信息
	 * @return 将结果以集合的形式返回
	 */
	List<T> selectAll();
	
	/**
	 * 条件查询
	 * @param queryString 查询语句
	 * @param params 语句中的参数
	 * @return 返回符合条件的数据集合
	 */
	List<T> selectAll(String queryString,Object... params);
	
	
	/**
	 * 分页查询
	 * @param pagenum 需要查询的页码
	 * @param pagesize 每页显示条数
	 * @return 符合条件的结果集合
	 */
	List<T> select4Page(Integer pagenum,Integer pagesize);

	/**
	 * 
	 * @return 数据总数量
	 */
	int dataCount();
	
	/**
	 * 查询数据总页数
	 * @param pagesize 数据显示条数
	 * @return 返回计算过后的总页数
	 */
	int allPage(Integer pagesize);
	
}
