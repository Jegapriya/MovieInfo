package com.mindtree.service.impl;

import java.util.List;

import org.springframework.context.ApplicationContext;

import com.mindtree.dao.impl.GenreDaoImpl;
import com.mindtree.entity.Genre;
import com.mindtree.exception.DaoException;
import com.mindtree.exception.ServiceException;
import com.mindtree.service.GenreService;

public class GenreServiceImpl implements GenreService {

	private GenreDaoImpl genreDao;
	
	@Override
	public String insertGenre(ApplicationContext con, Genre genere) throws ServiceException {
		try
		{
			genreDao=con.getBean("objGenreDao",GenreDaoImpl.class);
			return genreDao.insertGenre(genere);
		}
		catch(DaoException e)
		{
			throw new ServiceException(e);
		}
	}

	@Override
	public String deleteGenre(ApplicationContext con, int id) throws ServiceException {
		try
		{
			genreDao=con.getBean("objGenreDao",GenreDaoImpl.class);
			return genreDao.deleteGenre(id);
		}
		catch(DaoException e)
		{
			throw new ServiceException(e);
		}
	}

	@Override
	public List<Genre> selectAllGenre(ApplicationContext con) throws ServiceException {
		try
		{
			genreDao=con.getBean("objGenreDao",GenreDaoImpl.class);
			return genreDao.selectAllGenre();
		}
		catch(DaoException e)
		{
			throw new ServiceException(e);
		}
	}

}
