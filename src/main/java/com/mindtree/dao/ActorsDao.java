package com.mindtree.dao;

import java.util.List;

import com.mindtree.entity.Actors;
import com.mindtree.exception.DaoException;

public interface ActorsDao {

	public String insertActors(Actors actor) throws DaoException;
	public String deleteActors(int id) throws DaoException;
	public List<Actors> selectAllActors() throws DaoException;
}
