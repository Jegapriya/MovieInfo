package com.mindtree.dao;

import java.util.List;

import com.mindtree.entity.Genre;
import com.mindtree.exception.DaoException;

public interface GenreDao {

	public String insertGenre(Genre genere) throws DaoException;
	public String deleteGenre(int id) throws DaoException;
	public List<Genre> selectAllGenre() throws DaoException;
}
