package com.mindtree.dao;

import java.util.List;

import com.mindtree.entity.Movie;
import com.mindtree.exception.DaoException;

public interface MovieDao {

	public String insertMovie(Movie movie) throws DaoException;
	public String deleteMovie(int id) throws DaoException;
	public List<Movie> selectAllMovie() throws DaoException;
	public String updateBoxoffice(double boxoffice,int id) throws DaoException;
}
