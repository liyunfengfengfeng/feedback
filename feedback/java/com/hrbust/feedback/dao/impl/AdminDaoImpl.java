package com.hrbust.feedback.dao.impl;

import org.springframework.stereotype.Repository;

import com.hrbust.feedback.dao.AdminDao;
import com.hrbust.feedback.domain.Admin;

@Repository("adminDao")
public class AdminDaoImpl extends BaseDaoImpl<Admin> implements AdminDao {

	@Override
	public Admin loadAdmin(int id) {
		return this.loadEntity(id);
	}

	@Override
	public void updateAdmin(Admin admin) {
		this.updateEntity(admin);
	}

	@Override
	public void addAdmin(Admin admin) {
		this.addEntity(admin);
	}
	/**
	 * 通过管理员工号查询管理员
	 * @param account
	 * @return
	 */
	@Override
	public Admin loadAdminByAccount(String account) {
		String hql = "from Admin a where a.account = ?";
		return (Admin) this.getSession().createQuery(hql).setParameter(0, account).uniqueResult();
	}
	
}
