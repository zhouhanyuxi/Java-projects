package com.ncu.clothwholesale.tool;

import java.util.Collection;
import java.util.Map;

/**
 * 校验工具类 <p>
 * validate - 注解验证参数
 * @author 
 */
public class ValidateUtils {
 
	public enum DefaultPageInfo{
		PAGE(1),
		SIZE(10);
		private Integer value = null;
		DefaultPageInfo(Integer value){
			this.value = value;
		}
		public String toString() {
			// TODO Auto-generated method stub
			return value.toString();
		}
		public Integer intValue(){
			return value;
		}
	}
	
	public enum DefaultPageInfoName{
		PAGE_NAME("page"),
		SIZE_NAME("size");
		private String value = null;
		DefaultPageInfoName(String value){
			this.value = value;
		}
		public String toString() {
			// TODO Auto-generated method stub
			return value.toString();
		}
		 
	}
	
	
	public static void ValidatePageInfo(Integer page, Integer size){
		ValidatePageInfo(page,size,DefaultPageInfo.PAGE.intValue(),DefaultPageInfo.SIZE.intValue());
	}
	public static void ValidatePageInfo(Integer page, Integer size,Integer defaultSize){
		ValidatePageInfo(page,size,DefaultPageInfo.PAGE.intValue(),defaultSize);
	}
	
	public static void ValidatePageInfo(Integer page, Integer size,Integer defaultPage,Integer defaultSize){
		if(defaultPage == null || defaultPage <= 0){
			defaultPage=DefaultPageInfo.PAGE.intValue();
		}
		if(defaultSize == null || defaultSize <= 0){
			defaultSize=DefaultPageInfo.SIZE.intValue();
		}
		if(page == null || page <= 0){
			page = defaultPage;
		}
		if(size == null || size <= 0){
			size = defaultSize;
		}
	}
	public static void ValidatePageInfo(Map<String, Object> arguments,String pageName,String sizeName) {
		// TODO Auto-generated method stub
		if(arguments.get(pageName) == null && arguments.get(sizeName) == null){
			arguments.put(pageName, DefaultPageInfo.PAGE.intValue());
			arguments.put(sizeName, DefaultPageInfo.SIZE.intValue());
			return;
		}
		if(arguments.get(pageName) == null){
			arguments.put(pageName, DefaultPageInfo.PAGE.toString());
		}
		if(arguments.get(sizeName) == null){
			arguments.put(sizeName, DefaultPageInfo.SIZE.toString());
		}
		Integer page = DefaultPageInfo.PAGE.intValue();
		Integer size = DefaultPageInfo.SIZE.intValue();
		try{
			page = Integer.parseInt((String) arguments.get(pageName));
		}catch(Exception e){
			//不做处理
		}
		try{
			size = Integer.parseInt((String) arguments.get(sizeName));
		}catch(Exception e){
			//不做处理
		}
		ValidatePageInfo(page,size);
		arguments.remove(pageName);
		arguments.remove(sizeName);
		arguments.put(pageName, page);
		arguments.put(sizeName, size);
		
	}
	
	public static void ValidatePageInfo(Map<String, Object> arguments) {
		// TODO Auto-generated method stub
		ValidatePageInfo(arguments,DefaultPageInfoName.PAGE_NAME.toString(),DefaultPageInfoName.SIZE_NAME.toString());
	}
	
	/**
	 * 验证传入的变量 为空 
	 * @param t 待验证变量
	 * @return true - 为空  , false - 不为空
	 */
	public static <T> boolean validateEmpty(T t){
		return validateEmpty(t,true);
	}
	
	/**
	 * 验证传入的变量 为空 
	 * @param t 待验证变量
	 * @param flag 标志 是否需要判断空字符串、列表、数组、集合等为空  true - 需要  , false - 不需要
	 * @return true - 为空  , false - 不为空
	 */
	@SuppressWarnings("rawtypes")
	public static <T> boolean validateEmpty(T t,boolean flag){
		if(t == null){
			return true;
		}
		if(!flag){
			return false;
		}
		if(t instanceof String){
			return "".equals(((String) t).trim());
		}else if(t instanceof Collection){
			return  ((Collection) t).size() == 0 ? true : false;
		}else if(t instanceof Map){
			return ((Map) t).size() == 0 ? true : false;
		}
		return false;
	}
	
	/**
	 * 验证传入的变量 不为空 
	 * @param t 待验证变量
	 * @return true - 不为空  , false - 为空
	 */
	public static <T> boolean validateNotEmpty(T t){
		return !validateEmpty(t,true);
	}
	
	/**
	 * 验证传入的变量 不为空 
	 * @param t 待验证变量
	 * @param flag 标志 是否需要判断空字符串、列表、数组、集合等为空  true - 需要  , false - 不需要
	 * @return true - 不为空  , false - 为空
	 */
	public static <T> boolean validateNotEmpty(T t,boolean flag){
		return !validateEmpty(t, flag);
	}
}
