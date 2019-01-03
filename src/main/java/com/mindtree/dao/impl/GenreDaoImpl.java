package com.mindtree.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.springframework.orm.hibernate4.HibernateTemplate;

import com.mindtree.dao.GenreDao;
import com.mindtree.entity.Genre;
import com.mindtree.exception.DaoException;

public class GenreDaoImpl implements GenreDao{

	private HibernateTemplate template;
	
	public HibernateTemplate getTemplate() {
		return template;
	}

	public void setTemplate(HibernateTemplate template) {
		this.template = template;
	}

	@Override
	public String insertGenre(Genre genere) throws DaoException{
		try
		{
			Session session=template.getSessionFactory().openSession();
			session.save(genere);
			session.beginTransaction().commit();
			return "Success";
		}
		catch(Exception e)
		{
			throw new DaoException(e);
		}
	}

	@Override
	public String deleteGenre(int id) throws DaoException{
		try
		{
			template.bulkUpdate("Delete Genre where id = ?", id);
			return "Success";
		}
		catch(Exception e)
		{
			throw new DaoException(e);
		}
	}

	@Override
	public List<Genre> selectAllGenre() throws DaoException{
		try
		{
			return template.loadAll(Genre.class);
		}
		catch(Exception e)
		{
			throw new DaoException(e);
		}
	}

}
