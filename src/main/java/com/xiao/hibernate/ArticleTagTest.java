package com.xiao.hibernate;

import org.hibernate.SessionFactory;
import org.hibernate.classic.Session;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.xiao.domain.Article;
import com.xiao.domain.Tag;

public class ArticleTagTest {

	public static void main(String[] args) {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("app-context.xml");
		SessionFactory sf = ctx.getBean(SessionFactory.class);
		Session session = sf.openSession();
		session.beginTransaction();
		
		Article a = new Article();
		a.setName("On parent");
		Tag t1 = new Tag("novel");
		Tag t2 = new Tag("Science");
		a.getTags().add(t1);
		a.getTags().add(t2);
		
		session.save(a);
		session.getTransaction().commit();
		session.close();
		
		session = sf.openSession();
		session.beginTransaction();
		
		Article returnA = (Article) session.createQuery("from Article a").list().get(0);
		returnA.getTags().size();
		
		session.getTransaction().commit();
		session.close();
		
		System.out.println(returnA);
	}

}
