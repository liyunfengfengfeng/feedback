package com.hrbust.feedback.dao;

import java.util.List;
import java.util.Map;
import com.hrbust.feedback.util.Pager;
/**
 * 公共的dao接口
 * @author Administrator
 *
 * @param <T>
 */
public interface BaseDao<T> {
	/**
	 * 添加实体
	 * @param t
	 * @return
	 */
	public T addEntity(T t);
	/**
	 * 更新实体
	 * @param t
	 */
	public void updateEntity(T t);
	/**
	 * 删除实体
	 * @param id
	 */
	public void deleteEntity(int id);
	/**
	 * 保存或更新实体
	 * @param t
	 */
	public void saveOrUpdateEntity(T t);
	/**
	 * 批量处理
	 * @param hql
	 * @param objects
	 */
	public void batchEntityByHQL(String hql ,Object...objects);
	/**
	 * 加载实体
	 * @param id
	 * @return
	 */
	public T loadEntity(int id);
	/**
	 * 获取实体
	 * @param id
	 * @return
	 */
	public T getEntity(int id);
	/**
	 * 查询实体列表
	 * @param hql
	 * @param objects
	 * @return
	 */
	public List<T> listEntityByHQL(String hql,Object...objects);
	/**
	 * 使用hql批量查询并进行分页
	 * @param hql
	 * @param objects
	 * @return
	 */
	public Pager<T> findEntityByHQL(String hql, Object...objects);
	/**
	 * 
	 * @param hql
	 * @param alias
	 * @param objects
	 * @return
	 */
	public List<T> list(String hql, Map<String, Object> alias, Object...objects);
	/**
	 * 
	 * @param hql
	 * @param objects
	 * @return
	 */
	public List<T> list(String hql, Object...objects);
	
}
