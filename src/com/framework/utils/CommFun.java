package com.framework.utils;

public class CommFun {
	/// <summary>
    /// 将对象转换为字符串
    /// </summary>
    /// <param name="obj">要转换的对象</param>
    /// <returns>转换后的string类型结果</returns>
    public static String ObjectToStr(Object obj)
    {
        try {
			if (obj == null)
			    return "";
			return obj.toString().trim();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return "";
    }
}
