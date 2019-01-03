package com.mindtree.service.impl;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.springframework.context.ApplicationContext;

import com.mindtree.dao.impl.MovieDaoImpl;
import com.mindtree.entity.Movie;
import com.mindtree.exception.DaoException;
import com.mindtree.exception.ServiceException;
import com.mindtree.service.MovieService;

public class MovieServiceImpl implements MovieService{

	private MovieDaoImpl movieDao;
	
	@Override
	public String insertMovie(ApplicationContext con, Movie movie) throws ServiceException {
		try
		{
			movieDao=con.getBean("objMovieDao",MovieDaoImpl.class);
			return movieDao.insertMovie(movie);
		}
		catch(DaoException e)
		{
			throw new ServiceException(e);
		}
	}

	@Override
	public String deleteMovie(ApplicationContext con, int id) throws ServiceException {
		try
		{
			movieDao=con.getBean("objMovieDao",MovieDaoImpl.class);
			return movieDao.deleteMovie(id);
		}
		catch(DaoException e)
		{
			throw new ServiceException(e);
		}
	}

	@Override
	public List<Movie> selectAllMovie(ApplicationContext con) throws ServiceException {
		try
		{
			movieDao=con.getBean("objMovieDao",MovieDaoImpl.class);
			List<Movie> movies=movieDao.selectAllMovie();
			Collections.sort(movies, new MovieSorting());
			return movies;
		}
		catch(DaoException e)
		{
			throw new ServiceException(e);
		}
	}

	@Override
	public String updateBoxOffice(ApplicationContext con, double boxoffice, int id) throws ServiceException{
		try
		{
			movieDao=con.getBean("objMovieDao",MovieDaoImpl.class);
			return movieDao.updateBoxoffice(boxoffice, id);
		}
		catch(DaoException e)
		{
			throw new ServiceException(e);
		}
	}

}

class MovieSorting implements Comparator<Movie>{

	@Override
	public int compare(Movie arg0, Movie arg1) {		
		/*Double box2=arg1.getBoxoffice();
		return box2.compareTo(arg1.getBoxoffice());*/
		if(arg0.getBoxoffice()==arg1.getBoxoffice())
			return 0;
		else if(arg0.getBoxoffice()>arg1.getBoxoffice())
			return -1;
		else
			return 1;
	}

}


