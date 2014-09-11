package com.xiao.hibernate;

import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.xiao.domain.Email;
import com.xiao.domain.User;

public class UserEmailTest {

	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("app-context.xml");
		SessionFactory sf = ctx.getBean(SessionFactory.class);
		Session session = sf.openSession();
		session.beginTransaction();
		
		User u = new User("Xiao");
		Email e = new Email();
		e.setContent("This is a test email");
		u.getEmails().add(e);
		
		session.save(u);
		
		session.getTransaction().commit();
		session.close();

	}

}
