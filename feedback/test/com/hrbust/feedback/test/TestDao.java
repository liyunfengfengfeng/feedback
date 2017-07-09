package com.hrbust.feedback.test;

import javax.inject.Inject;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.hrbust.feedback.dao.AdminDao;
import com.hrbust.feedback.domain.Admin;

public class TestDao {
	@Inject
	private AdminDao adminDao;
	@Inject
	private SessionFactory sessionFactory;
	
	Session session;
	
	@Before
	public void setUp() {
		ApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");;
		adminDao = (AdminDao) ac.getBean("adminDao");
		sessionFactory = (SessionFactory) ac.getBean("sessionFactory");
		session = sessionFactory.openSession();
		System.out.println("dd");
	}
	/**
	 * 自动建表
	 */
	@Test
	public void setUp2() {
		ApplicationContext ac = new ClassPathXmlApplicationContext("beans.xml");;
		adminDao = (AdminDao) ac.getBean("adminDao");
		sessionFactory = (SessionFactory) ac.getBean("sessionFactory");
		session = sessionFactory.openSession();
		System.out.println("dd");
	}
	@Test
	public void testAddAdmin() {
		session.beginTransaction();
		Admin a = new Admin();
		a.setAccount("admin");
		a.setName("admin");
		a.setPassword("admin");
		adminDao.addAdmin(a);
		session.getTransaction().commit();
	}

}
