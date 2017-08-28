package zhao.blog.managementsystem.dao;

import java.util.List;

public interface BaseDao<T> {
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
	 * 根据id集合删除批量数据
	 * @param ids id数组?
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
	 * 查询 column 为 value 的数据集合
	 * @param column 类变量名
	 * @param value 值
	 * @return 返回符合的集合
	 */
	List<T> selectByColumn(String column,String value);
	/**
	 * 条件查询 
	 * @param queryString 查询语句
	 * @param parameters 查询语句中的参数
	 * @return 返回符合条件的查询结果[bean对象集合]
	 */
	List<T> selectCriteria4Entity(String queryString,Object... parameters);
	/**
	 * 条件查询 
	 * @param queryString 查询语句
	 * @param parameters 查询语句中的参数
	 * @return 返回符合条件的查询结果[Object对象集合]
	 */
	List<Object> selectCriteria4Object(String queryString,Object... parameters);
	/**
	 * 分页查询
	 * @param firstResult 第一条数据的下标位置
	 * @param maxResult 最多查询的数据条数
	 * @return 返回符合条件的数据结果集合
	 */
	List<T> select4Page(int firstResult,int maxResult);
	/**
	 * 按照指定分页条件的分页查询
	 * @param firstResult 第一条数据的下标位置
	 * @param maxResult 最多查询的数据条数
	 * @return 返回符合条件的数据结果集合
	 */
	List<T> select4PageByCriteria(int firstResult,int maxResult,String hql,String... params);
	
	/**
	 * 查询数据条数
	 * @return 返回对应数据总条数
	 */
	int dataCount();
}
