package com.sz.quadratic.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.sz.quadratic.interfaces.IDao;
import com.sz.quadratic.interfaces.IEntity;

@Repository
@Transactional
public class GeneralDao<T extends IEntity> implements IDao<T>{

//	@Autowired
//	private SessionFactory sessionFactory;
	
	@PersistenceContext
	private EntityManager em;
	
	protected Class<? extends T> clazz;
	
	public GeneralDao() {
//		this.clazz = (Class<T>) ((ParameterizedType) getClass()
//				.getGenericSuperclass()).getActualTypeArguments()[0];
	}
	
//	private Session getSession(){
//		try {
//			return sessionFactory.getCurrentSession();
//		} catch (Exception e) {
//			return sessionFactory.openSession();
//		}
//	}
	
//	public T get(int id){
//		try {
//			return getSession().get(clazz, id);
//		} finally {
//			getSession().close();
//		}
//	}
	

	public void save(T entity) {
//			 Session session = sessionFactory.getCurrentSession();
//			 session.persist(entity);
		em.persist(entity);
	}
//
//	public void update(T entity){
//		sessionFactory.merge(entity);
//	}
//	
//	public void delete(int id){
//		T entity = sessionFactory.getReference(clazz, id);
//		sessionFactory.remove(entity);
//	}
	
	@SuppressWarnings("unchecked")
	public List<T> getAll() {
//		return getSession().createQuery("from " + clazz.getName())
//				.getResultList();
//		Session session = sessionFactory.getCurrentSession();
		return em.createQuery("from " + clazz.getName())
				.getResultList();
	}

	@Override
	public void update(T entity) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void delete(int id) {
//		Session session = sessionFactory.getCurrentSession();
		T entity = em.getReference(clazz, id);
		em.remove(entity);
	}

	@Override
	public T get(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
