package com.mindtree.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.springframework.orm.hibernate4.HibernateTemplate;

import com.mindtree.dao.ActorsDao;
import com.mindtree.entity.Actors;
import com.mindtree.exception.DaoException;

public class ActorsDaoImpl implements ActorsDao{

	private HibernateTemplate template;

	public HibernateTemplate getTemplate() {
		return template;
	}

	public void setTemplate(HibernateTemplate template) {
		this.template = template;
	}

	@Override
	public String insertActors(Actors actor)  throws DaoException{
		try {
			Session session=template.getSessionFactory().openSession();
			session.save(actor);
			session.beginTransaction().commit();
		}
		catch(Exception e)
		{
			throw new DaoException(e);
		}
		return "Success";
	}

	@Override
	public String deleteActors(int id)  throws DaoException{
		try
		{
			template.bulkUpdate("Delete Actor where id = ?", id);
			return "Success";
		}
		catch(Exception e)
		{
			throw new DaoException(e);
		}
	}

	@Override
	public List<Actors> selectAllActors()  throws DaoException{
		try
		{
			return template.loadAll(Actors.class);
		}
		catch(Exception e)
		{
			throw new DaoException(e);
		}
	}

}
