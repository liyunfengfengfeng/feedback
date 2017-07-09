package com.hrbust.feedback.dao.impl;

import java.lang.reflect.ParameterizedType;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.hrbust.feedback.dao.BaseDao;
import com.hrbust.feedback.util.Pager;
import com.hrbust.feedback.util.SystemContext;

/**
 * 用于继承的基类
 * @author Administrator
 *
 * @param <T>
 */
@SuppressWarnings("unchecked")
public class BaseDaoImpl<T> implements BaseDao<T>{
	
	/**
	 * 会话工厂
	 */
	private SessionFactory sessionFactory;

	

	public SessionFactory getSessionFactory() {
		return sessionFactory;
	}
	@Resource(name="sessionFactory")
	public void setSessionFactory(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	protected Session getSession() {
		return this.sessionFactory.getCurrentSession();
	}

	/**
	 * 用来获取泛型的class
	 */
	private Class<?> clazz;
	
	public Class<?> getClazz(){
		if(clazz == null) {
			ParameterizedType pt = (ParameterizedType) this.getClass().getGenericSuperclass();
			clazz = (Class<?>) pt.getActualTypeArguments()[0];
		}
		return clazz;
	}
	/**
	 * 设置参数
	 * @param query
	 * @param objects
	 */
	private void setParameter(Query query, Object... objects) {
		if(objects != null && objects.length > 0) {
			int index = 0;
			for (Object object : objects) {
				query.setParameter(index, object);
				index++;
			}
		}
	}
	/**
	 * 组织排序语句
	 * @param hql
	 * @return
	 */
	private String initSort(String hql) {
		String order = SystemContext.getOrder();
		String sort = SystemContext.getSort();
		if(sort != null && !"".equals(sort.trim())) {
			hql = hql + "order by " + sort;
			if(!"desc".equals(order)) {
				hql = hql + "asc";
			} else {
				hql = hql + "desc";
			}
		}
		return hql;
	}
	/**
	 * 构造hql查询总记录数
	 * @param hql
	 * @param isHql
	 * @return
	 */
	private String getCountHql(String hql, boolean isHql) {
		String e = hql.substring(hql.indexOf("from"));
		String c = "select count(*)" + e;
		if(isHql) {
			c = c.replaceAll("fetch", "");
		}
		return c;
	}
	/**
	 * 设置有关分页的数据
	 * @param query
	 * @param pages
	 */
	@SuppressWarnings("rawtypes") 
	private void setPagers(Query query, Pager pages) {
		Integer pageSize = SystemContext.getPageSize();
		Integer pageOffset = SystemContext.getPageOffset();
		
		if(pageSize == null || pageOffset < 0) {
			pageOffset = 0;
		}
		if(pageOffset == null || pageSize < 0) {
			pageSize = 15;
		}
		pages.setSize(pageSize);
		pages.setOffset(pageOffset);
		query.setFirstResult(pageOffset).setMaxResults(pageOffset + pageSize);
	}
	
	@Override
	public T addEntity(T t) {
		this.getSession().save(t);
		return t;
	}

	@Override
	public void updateEntity(T t) {
		this.getSession().update(t);
	}

	@Override
	public void deleteEntity(int id) {
		T t = this.loadEntity(id);
		this.getSession().delete(t);
	}

	@Override
	public void saveOrUpdateEntity(T t) {
		this.getSession().saveOrUpdate(t);
	}

	
	@Override
	public void batchEntityByHQL(String hql, Object... objects) {
		Query query = this.getSession().createQuery(hql);
		setParameter(query, objects);
		query.executeUpdate();
	}
	
	@Override
	public T loadEntity(int id) {
		return (T) this.getSession().load(getClazz(), id);
	}

	@Override
	public T getEntity(int id) {
		return (T) this.getSession().get(getClazz(), id);
	}
	/**
	 * 通过hql语句查询所有的实体
	 * 例如查询所有的班级
	 * Object 是查询所有的实体需要的条件
	 */
	@Override
	public List<T> listEntityByHQL(String hql, Object... objects) {
		hql = initSort(hql);
		Query query = this.getSession().createQuery(hql);
		setParameter(query, objects);
		return query.list();
	}


	@Override
	public Pager<T> findEntityByHQL(String hql, Object... objects) {
		hql = initSort(hql);
		String cq = getCountHql(hql,true);
		Query query = this.getSession().createQuery(hql);
		Query cquery = this.getSession().createQuery(cq);
		
		setParameter(query, objects);
		setParameter(cquery, objects);
		
		Pager<T> pages = new Pager<T>();
		setPagers(query, pages);
		List<T> datas = query.list();
		pages.setDatas(datas);
		long total = (Long) cquery.uniqueResult();
		pages.setTotal(total);
		return pages;
	}
	@Override
	public List<T> list(String hql, Map<String, Object> alias,
			Object... objects) {
		hql = initSort(hql);
		Query query = getSession().createQuery(hql);
		setAliasParameter(query, alias);
		setParameter(query, objects);
		return query.list();
	}
	@Override
	public List<T> list(String hql, Object...objects) {
		return this.list(hql, null, objects);
	}
	
	@SuppressWarnings("rawtypes")
	private void setAliasParameter(Query query,Map<String,Object> alias) {
		if(alias!=null) {
			Set<String> keys = alias.keySet();
			for(String key:keys) {
				Object val = alias.get(key);
				if(val instanceof Collection) {
					//鏌ヨ鏉′欢鏄垪琛�
					query.setParameterList(key, (Collection)val);
				} else {
					query.setParameter(key, val);
				}
			}
		}
	}
	
	
	
}
