package com.hrbust.feedback.util;
/**
 * 用来传递列表对象的ThreadLocal数据
 * @author 李云峰
 *
 */
public class SystemContext {
	/**
	 * 分页大小      ThreadLocal的应用场合，我觉得最适合的是按线程多实例（每个线程对应一个实例）的对象的访问，并且这个对象很多地方都要用到。
	 */
	private static ThreadLocal<Integer> pageSize = new ThreadLocal<Integer> ();
	/**
	 * 分页的起始页
	 */
	private static ThreadLocal<Integer> pageOffset = new ThreadLocal<Integer> ();
	/**
	 * 分页的排序方式
	 */
	private static ThreadLocal<String> sort = new ThreadLocal<String> ();
	/**
	 * 分页的排序字段
	 */
	private static ThreadLocal<String> order = new ThreadLocal<String> ();
	/**
	 * 获取真实地址
	 */
	private static ThreadLocal<String> readPath = new ThreadLocal<String> ();
	
	public static Integer getPageSize() {
		return pageSize.get();
	}
	public static void setPageSize(Integer _pageSize) {
		SystemContext.pageSize.set(_pageSize);;
	}
	public static Integer getPageOffset() {
		return pageOffset.get();
	}
	public static void setPageOffset(Integer _pageOffset) {
		SystemContext.pageOffset.set(_pageOffset);;
	}
	public static String getSort() {
		return sort.get();
	}
	public static void setSort(String _sort) {
		SystemContext.sort.set(_sort);
	}
	public static String getOrder() {
		return order.get();
	}
	public static void setOrder(String _order) {
		SystemContext.order.set(_order);
	}
	public static String getReadPath() {
		return readPath.get();
	}
	public static void setReadPath(String _readPath) {
		SystemContext.readPath.set(_readPath);
	}
	
} 
