package com.sz.quadratic;

import static org.junit.Assert.assertFalse;

import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.sz.quadratic.interfaces.IQuadraticDao;
import com.sz.quadratic.models.Quadratic;

public class HibernateDaoTest {
	private ApplicationContext context = new ClassPathXmlApplicationContext("spring-context.xml");
	private IQuadraticDao quadraticDao;
	private Quadratic quadratic;
	
	@Before
	public void before(){
		quadratic = context.getBean("quadratic1", Quadratic.class);
		quadraticDao = context.getBean("quadraticDaoImpl", IQuadraticDao.class);
		quadraticDao.save(quadratic);
	}
	
	@After
	public void after(){
		quadraticDao.delete(quadratic.getId());
	}
	
	@Test
	public void testGetAll() {
		List<Quadratic> quadratics = quadraticDao.getAll();
		assertFalse(quadratics.isEmpty());
		System.out.println(quadratics);
	}

}
