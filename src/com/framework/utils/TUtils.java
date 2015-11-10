package com.framework.utils;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

@SuppressWarnings("all")
public class TUtils {

	/**
	 * 泛型转换
	 * @param entity
	 * @return
	 */
	public static Class getActualType(Class entity) {
		// 子类获取父类, 例如：BaseAction<T>
		Type type = entity.getGenericSuperclass();
		// 获取参数类型, 例如：<T>
		ParameterizedType parameterizedType = (ParameterizedType) type;
		// 获取子类传递的真实类型参数，第一个值T, 例如：ElecText
		Class entityClass = (Class) parameterizedType.getActualTypeArguments()[0];
		
		return entityClass;
	}

}
