package com.mindtree.service;

import java.util.List;

import org.springframework.context.ApplicationContext;

import com.mindtree.entity.Movie;
import com.mindtree.exception.ServiceException;

public interface MovieService {

	public String insertMovie(ApplicationContext con,Movie movie) throws ServiceException;
	public String deleteMovie(ApplicationContext con,int id) throws ServiceException;
	public List<Movie> selectAllMovie(ApplicationContext con) throws ServiceException;
	public String updateBoxOffice(ApplicationContext con,double boxoffice,int id) throws ServiceException;
}
