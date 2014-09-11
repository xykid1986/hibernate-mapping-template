package com.xiao.hibernate;

import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.xiao.domain.Department;
import com.xiao.domain.Employee;
/**
 * Bidirectional one to many relationship. Many is usually the owner
 * @author yi
 *
 */
public class OneManyTest {
	
	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("app-context.xml");
		SessionFactory sf = ctx.getBean(SessionFactory.class);
		Session session = sf.openSession();
		session.beginTransaction();
		
		Employee e = new Employee("Jack");
		Department d = new Department("PS");
		e.setDepartment(d);
		
		session.persist(e);
		
		session.getTransaction().commit();
		session.close();
	}
}
