package com.mindtree.service;

import java.util.List;

import org.springframework.context.ApplicationContext;

import com.mindtree.entity.Genre;
import com.mindtree.exception.ServiceException;

public interface GenreService {

	public String insertGenre(ApplicationContext con,Genre genere) throws ServiceException;
	public String deleteGenre(ApplicationContext con,int id) throws ServiceException;
	public List<Genre> selectAllGenre(ApplicationContext con) throws ServiceException;
}
