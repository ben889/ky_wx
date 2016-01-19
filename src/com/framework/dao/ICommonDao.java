package com.framework.dao;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

import com.framework.utils.pagination.PageInfo;


public interface ICommonDao<T> {
	/**
	 * 保存
	 * @param entity (类型：T)
	 */
	void save(T entity);
	/**
	 * 批量保存
	 * @param list (类型：List<T>)
	 */
	void save(List<T> list);
	/**
	 * 更新
	 * @param entity (类型：T)
	 */
	void update(T entity);
	/**
	 * 批量删除
	 * @param list (类型：List<T>)
	 */
	void delete(List<T> list);
	/**
	 * 删除
	 * @param ids (类型：Serializable...)
	 */
	void delete(Serializable... ids);
	void delete(String where);
	/**
	 * 查找
	 * @param id (类型：Serializable)
	 * @return (类型：T)
	 */
	T find(Serializable id);
	/**
	 * 查找
	 * 
	 * @param start 开始 (类型：int)
	 * @param end 结束 (类型：int)
	 * @param condition 条件 (类型：String)
	 * @param params 参数 (类型：Object[])
	 * @param orderby 排序 (类型：Map<String, String>)
	 * @return (类型：List<T>)
	 */
	List<T> find(int start, int end, String condition,Object[] params, Map<String, String> orderby);
	/**
	 * 分页查找
	 * @param condition 条件 (类型：String)
	 * @param params 参数 (类型：Object[])
	 * @param orderby 排序 (类型：Map<String, String>)
	 * @param pageInfo 分页 (类型：PageInfo)
	 * @return (类型：List<T>)
	 */
	List<T> find(String condition,Object[] params, Map<String, String> orderby, PageInfo pageInfo);
	/**
	 * 多表联合分页查找
	 * @param condition 条件(类型：String)
	 * @param params 参数 (类型：Object[])
	 * @param orderby 排序 (类型：String)
	 * @param pageInfo 分页 (类型：PageInfo)
	 * @return (类型：List)
	 */
	List find(String condition, final Object[] params, String orderby, PageInfo pageInfo);
}
