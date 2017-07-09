package com.hrbust.feedback.dao;

import com.hrbust.feedback.domain.Admin;

public interface AdminDao extends BaseDao<Admin>{
	/**
	 * 鑾峰彇绠＄悊鍛樹俊鎭�
	 * @param id
	 * @return
	 */
	public Admin loadAdmin(int id);
	/**
	 * 鏇存柊绠＄悊鍛樹俊鎭�
	 * @param admin
	 */
	public void updateAdmin(Admin admin);
	/**
	 * 澧炲姞绠＄悊鍛�
	 * @param admin
	 */
	public void addAdmin(Admin admin);
	/**
	 * 通过管理员工号查询管理员
	 * @param account
	 * @return
	 */
	public Admin loadAdminByAccount(String account);
}
