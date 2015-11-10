package com.framework.dao.impl;

import java.io.Serializable;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.orm.hibernate3.HibernateCallback;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.framework.dao.ICommonDao;
import com.framework.utils.TUtils;
import com.framework.utils.pagination.PageInfo;

@SuppressWarnings("all")
public class CommonDaoImpl<T> extends HibernateDaoSupport implements ICommonDao<T> {

	// 泛型转换
	Class entityClass = TUtils.getActualType(this.getClass());

	// 随便写一个Set方法，注入SessionFactory
	@Resource(name = "sessionFactory")
	public void setDi(SessionFactory sessionFactory) {
		this.setSessionFactory(sessionFactory);
	}

	/**
	 * 保存
	 */
	public void save(T entity) {
		this.getHibernateTemplate().save(entity);
		this.getHibernateTemplate().flush();
	}

	/**
	 * 批量保存
	 */
	public void save(List<T> list) {
		this.getHibernateTemplate().saveOrUpdateAll(list);
		this.getHibernateTemplate().flush();
	}

	/**
	 * 根据list集合批量删除
	 */
	public void delete(List<T> list) {
		this.getHibernateTemplate().deleteAll(list);
		this.getHibernateTemplate().flush();
	}

	/**
	 * 根据ID批量删除
	 */
	public void delete(Serializable... ids) {
		if (ids != null && ids.length > 0) {
			for (Serializable id : ids) {
				// 先查询
				Object entity = this.find(id);
				// 再删除
				this.getHibernateTemplate().delete(entity);
				this.getHibernateTemplate().flush();
			}
		}
	}
	
	/**
	 * 更新
	 */
	public void update(T entity) {
		this.getHibernateTemplate().update(entity);
		this.getHibernateTemplate().flush();
	}

	/**
	 * 根据ID查找
	 */
	public T find(Serializable id) {
		return (T) this.getHibernateTemplate().get(entityClass, id);
	}

	/**
	 * 单表操作，根据查询条件，查询结果，返回List集合 SELECT * FROM elec_text o WHERE 1=1 #Dao AND
	 * o.textName LIKE '%张%' #Service AND o.textRemark LIKE '%张%' ORDER BY
	 * o.textDate ASC,o.textName DESC
	 */
	public List<T> find(final int start, final int end, String condition, final Object[] params, Map<String, String> orderby) {
		String hql = "FROM " + entityClass.getSimpleName() + " o WHERE 1=1 ";
		// 将Map集合转换成String
		String orderbyCondition = this.orderByHql(orderby);
		//拼装完整的hql
		final String finalHql = hql + condition + orderbyCondition;
		// 查询一
		// List<T> list = this.getHibernateTemplate().find(finalHql, params);
		// 查询二
		List<T> list = this.getHibernateTemplate().execute(
				new HibernateCallback() {
					public Object doInHibernate(Session session)
							throws HibernateException, SQLException {
						//创建查询
						Query query = session.createQuery(finalHql);
						//设置记录范围
						if(start>=0 && end>=0 && end >= start){
							query.setFirstResult(start);// 表示当前页从第几条开始检索，默认是0
							query.setMaxResults(end);// 表示当前页最多显示多少条记录
						}
						//设置参数
						if (params != null && params.length > 0) {
							for (int i = 0; i < params.length; i++) {
								query.setParameter(i, params[i]);
							}
						}
						return query.list();
					}
				});
		return list;
	}

	/**
	 * 分页查询
	 */
	public List<T> find(String condition, final Object[] params, Map<String, String> orderby, final PageInfo pageInfo) {
		String hql = "FROM " + entityClass.getSimpleName() + " o ";
		// 将Map集合转换成String
		String orderbyCondition = this.orderByHql(orderby);
		if(condition.trim().length() > 0){
			hql = hql + " WHERE " + condition + orderbyCondition;
		}
		final String finalHql = hql;
		List<T> list = this.getHibernateTemplate().execute(
				new HibernateCallback() {

					public Object doInHibernate(Session session)
							throws HibernateException, SQLException {
						Query query = session.createQuery(finalHql);
						if (params != null && params.length > 0) {
							for (int i = 0; i < params.length; i++) {
								query.setParameter(i, params[i]);
							}
						}
						/** 2015-4-2添加分页begin */
						// 初始化总的记录数
						pageInfo.setTotalResult(query.list().size());
						query.setFirstResult(pageInfo.getBeginResult());// 表示当前页从第几条开始检索，默认是0
						query.setMaxResults(pageInfo.getPageSize());// 表示当前页最多显示多少条记录
						/** 2015-4-2添加分页end */
						return query.list();
					}

				});
		return list;
	}
	
	public List find(String condition, final Object[] params, String orderby, final PageInfo pageInfo) {
		String hql = "FROM " + entityClass.getSimpleName() + " o ";
		// 将Map集合转换成String
		String orderbyCondition = orderby;
		if(condition.trim().length() > 0){
			hql = hql + " WHERE " + condition + orderbyCondition;
		}
		final String finalHql = hql;
		List list = this.getHibernateTemplate().execute(
				new HibernateCallback() {

					public Object doInHibernate(Session session)
							throws HibernateException, SQLException {
						Query query = session.createQuery(finalHql);
						if (params != null && params.length > 0) {
							for (int i = 0; i < params.length; i++) {
								query.setParameter(i, params[i]);
							}
						}
						/** 2015-4-2添加分页begin */
						// 初始化总的记录数
						pageInfo.setTotalResult(query.list().size());
						query.setFirstResult(pageInfo.getBeginResult());// 表示当前页从第几条开始检索，默认是0
						query.setMaxResults(pageInfo.getPageSize());// 表示当前页最多显示多少条记录
						/** 2015-4-2添加分页end */
						return query.list();
					}

				});
		return list;
	}

	/**
	 * 组织排序 ORDER BY o.textDate ASC,o.textName DESC
	 * 
	 * @param orderby
	 * @return
	 */
	public String orderByHql(Map<String, String> orderby) {
		StringBuffer buffer = new StringBuffer("");
		if (orderby != null && orderby.size() > 0) {
			buffer.append(" Order by ");
			for (Map.Entry<String, String> map : orderby.entrySet()) {
				buffer.append(map.getKey()).append(" ").append(map.getValue()).append(",");
			}
			// 删除最后一个逗号
			buffer.deleteCharAt(buffer.length() - 1);
		}
		return buffer.toString();
	}

}
