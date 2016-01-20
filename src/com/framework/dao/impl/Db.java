package com.framework.dao.impl;

import java.lang.reflect.Field;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

import com.framework.utils.TUtils;

public class Db {

	public Boolean isExists(Object obj, String where) throws SQLException {
		Class<?> cls = obj.getClass();
		String sql = "select 1 as val from " + cls.getSimpleName();
		if (where.trim().length() > 0)
			sql = sql + " where " + where;
		List<Map<String, Object>> list = JdbcHelper.query(sql);
		if (list != null && list.size() > 0) {
			Map<String, Object> map = list.get(0);
			Object val = map.get("val");
			if (val != null && val.toString().equals("1"))
				return true;
			// for (String k : map.keySet()) {
			// System.out.println(k + " : " + map.get(k));
			// }
		}
		return false;
	}

	public Object insert(Object obj, String id, boolean identity)
			throws Exception {
		Class<?> cls = obj.getClass();
		String sql = "INSERT INTO " + cls.getSimpleName();
		// Field[] fls = cls.getDeclaredFields();
		Field[] sfls = cls.getDeclaredFields();

		String f_sql = "";
		String v_sql = "";
		// 只加载父类的主键
		for (Field f : sfls) {
			// if (Modifier.isStatic(f.getModifiers()) ||
			// Modifier.isFinal(f.getModifiers())) {
			// continue;
			// }
			String name = f.getName();
			if (name.equals(id)) {

				if (identity) {
					continue;
				}
			}

			String getMethodName = "get" + toFirstLetterUpperCase(name);
			// String setMethodName = "set" + toFirstLetterUpperCase(name);
			Object value = cls.getMethod(getMethodName).invoke(obj);
			f_sql = f_sql + name + ",";
			v_sql = v_sql + "'" + value + "',";
		}
		// 删除最后一个逗号
		if (f_sql.trim().length() > 0)
			f_sql = f_sql.substring(0, f_sql.length() - 1);
		if (v_sql.trim().length() > 0)
			v_sql = v_sql.substring(0, v_sql.length() - 1);
		sql = sql + "(" + f_sql + ")VALUES(" + v_sql + ")";
		return JdbcHelper.insertWithReturnPrimeKey(sql);
	}

	private static String toFirstLetterUpperCase(String str) {
		if (str == null || str.length() < 2) {
			return str;
		}
		String firstLetter = str.substring(0, 1).toUpperCase();
		return firstLetter + str.substring(1, str.length());
	}
}
