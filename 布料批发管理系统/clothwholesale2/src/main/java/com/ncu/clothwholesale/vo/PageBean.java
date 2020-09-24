package com.ncu.clothwholesale.vo;

import java.util.List;

/**
 * 分页的JavaBean
 * @author Administrator
 */
public class PageBean<T> {
	
	// 当前页
	private int currentPage;
	//总页数
	private int lastPage;
	// 总记录数
	private int totalCount;
	
	// 每页显示的记录条数
	private int length;
	// 每页显示的数据
	private List<T> beanList;
	
	public int getPageCode() {
		return currentPage;
	}
	public void setPageCode(int pageCode) {
		this.currentPage = pageCode;
	}
	
	/**
	 * 调用getTotalPage() 获取到总页数
	 * JavaBean的属性规定：totalPage是JavaBean是属性 ${pageBean.totalPage}
	 * @return
	 */
	 
	
	public int getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}
	public int getPageSize() {
		return length;
	}
	public void setPageSize(int pageSize) {
		this.length = pageSize;
	}
	public List<T> getBeanList() {
		return beanList;
	}
	public void setBeanList(List<T> beanList) {
		this.beanList = beanList;
	}
	public int getLastPage() {
		int totalPage = totalCount / length;
		// 说明整除
		if(totalCount % length == 0){
			return totalPage;
		}else{
			return totalPage + 1;
		}
	}
	public void setLastPage(int lastPage) {
		this.lastPage = lastPage;
	}
	
	public int getCurrentPage() {
		return currentPage;
	}
	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}
	public int getLength() {
		return length;
	}
	public void setLength(int length) {
		this.length = length;
	}
 
}
