package com.hrbust.feedback.test;


import org.hibernate.SessionFactory;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.hrbust.feedback.action.LoginController;
import com.hrbust.feedback.dao.AdminDao;
import com.hrbust.feedback.domain.Admin;
import com.hrbust.feedback.service.AdminService;




public class TestDataSource {
	@Test
	public void test() {
		ApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");;
		SessionFactory sf =  (SessionFactory) ac.getBean("sessionFactory");
		System.out.println("%%%%%%%%" + sf);
	}
	@Test
	public void testAdminService() {
		ApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
		AdminService as = (AdminService) ac.getBean("adminService");
		Admin admin = as.loadAdminByAccount("123456");
		System.out.println("admin name"+admin.getName());
	}
	@Test
	public void testloadAdmin() {
		ApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
		AdminService as = (AdminService) ac.getBean("adminService");
		as.loadAdminById(1);
	}
	@Test
	public void testAdminDao() {
		ApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
		AdminDao as = (AdminDao) ac.getBean("adminDao");
		as.loadAdminByAccount("123456");
	}
	
	@Test
	public void testLoadAdmin() {
		ApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
		AdminDao as = (AdminDao) ac.getBean("adminDao");
		as.loadAdmin(1);
	}
	
	@Test
	public void testController() {
		ApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");
		LoginController l = (LoginController) ac.getBean("loginController");
		System.out.println(l);
	}
}
