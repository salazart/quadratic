package com.sz.quadratic;

import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sz.quadratic.models.Quadratic;
import com.sz.quadratic.service.QuadraticService;

public class QuadraticServiceTest {
	private ApplicationContext context;

	@Before
	public void before(){
		 context = new ClassPathXmlApplicationContext("spring-context.xml");
	}

	@Test
	public void testGetQuadratic() {
		Quadratic quadratic = context.getBean("quadratic1", Quadratic.class);
		QuadraticService quadraticService = new QuadraticService(quadratic);
		assertTrue(quadraticService.isResult());
	}

}
