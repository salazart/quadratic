package com.sz.quadratic;

import com.sz.quadratic.dao.impl.QuadraticDaoImpl;
import com.sz.quadratic.interfaces.IQuadraticService;
import com.sz.quadratic.models.Quadratic;
import com.sz.quadratic.service.QuadraticService;

public class HibernateTest {
	private static final double A = 5;
	private static final double B = 9;
	private static final double C = 3;

	public static void main(String[] args) {
//		ApplicationContext context = new ClassPathXmlApplicationContext("spring-context.xml");
//		SessionFactory sessionFactory = context.getBean("sessionFactory", SessionFactory.class);
		
		QuadraticService quadraticService = new QuadraticService(A,B,C);
		
		Quadratic quadratic = quadraticService.getResult();
		
		System.out.println(quadraticService.isResult() ? quadratic : "Don't result");
		
		IQuadraticService iQuadraticService = new QuadraticDaoImpl();
		iQuadraticService
		
	}

}
