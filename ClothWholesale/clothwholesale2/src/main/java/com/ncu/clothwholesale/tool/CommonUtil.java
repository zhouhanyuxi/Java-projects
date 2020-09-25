package com.ncu.clothwholesale.tool;

import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

/**
 * 通用的工具类<p>
 * 函数 <p>
 * getLog - 日志生成器
 * getMapArguments -将request中参数转换为map
 * @author wpx
 */
public class CommonUtil {
 
 

	/**
	 * 获取前台传递的参数，并以Map形式返回
	 * @param request
	 * @return
	 */
	public static Map<String, Object> getMapArguments(HttpServletRequest request) {
		Map<String, String[]> allParams = request.getParameterMap();
		Map<String, Object> params = new HashMap<String, Object>();
		for (Map.Entry<String, String[]> entry : allParams.entrySet()) {
			if (entry.getValue().length > 0) {
				params.put(entry.getKey(), entry.getValue()[0]);
			}
		}
		return params;
	} 
	 
}
