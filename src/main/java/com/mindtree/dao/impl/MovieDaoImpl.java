package com.mindtree.dao.impl;

import java.util.List;

import org.hibernate.Session;
import org.springframework.orm.hibernate4.HibernateTemplate;

import com.mindtree.dao.MovieDao;
import com.mindtree.entity.Movie;
import com.mindtree.exception.DaoException;

public class MovieDaoImpl implements MovieDao{

	private HibernateTemplate template;
	
	public HibernateTemplate getTemplate() {
		return template;
	}

	public void setTemplate(HibernateTemplate template) {
		this.template = template;
	}

	@Override
	public String insertMovie(Movie movie) throws DaoException {
		try
		{
			Session session=template.getSessionFactory().openSession();
			session.save(movie);
			session.beginTransaction().commit();
			return "Success";
		}
		catch(Exception e)
		{
			throw new DaoException(e);
		}
	}

	@Override
	public String deleteMovie(int id) throws DaoException{
		try
		{
			template.bulkUpdate("Delete Movie where id = ?", id);
			return "Success";
		}
		catch(Exception e)
		{
			throw new DaoException(e);
		}
	}

	@Override
	public List<Movie> selectAllMovie() throws DaoException {
		try
		{
			return template.loadAll(Movie.class);
		}
		catch(Exception e)
		{
			throw new DaoException(e);
		}
	}

	@Override
	public String updateBoxoffice(double boxoffice,int id) throws DaoException {
		try
		{
			template.bulkUpdate("update Movie set boxoffice=? where id =?", boxoffice,id);
			return "Success";
		}
		catch(Exception e)
		{
			throw new DaoException(e);
		}
	}

}
