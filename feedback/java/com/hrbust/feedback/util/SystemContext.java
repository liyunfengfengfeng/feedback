package com.hrbust.feedback.util;
/**
 * ���������б�����ThreadLocal����
 * @author ���Ʒ�
 *
 */
public class SystemContext {
	/**
	 * ��ҳ��С      ThreadLocal��Ӧ�ó��ϣ��Ҿ������ʺϵ��ǰ��̶߳�ʵ����ÿ���̶߳�Ӧһ��ʵ�����Ķ���ķ��ʣ������������ܶ�ط���Ҫ�õ���
	 */
	private static ThreadLocal<Integer> pageSize = new ThreadLocal<Integer> ();
	/**
	 * ��ҳ����ʼҳ
	 */
	private static ThreadLocal<Integer> pageOffset = new ThreadLocal<Integer> ();
	/**
	 * ��ҳ������ʽ
	 */
	private static ThreadLocal<String> sort = new ThreadLocal<String> ();
	/**
	 * ��ҳ�������ֶ�
	 */
	private static ThreadLocal<String> order = new ThreadLocal<String> ();
	/**
	 * ��ȡ��ʵ��ַ
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
