package com.mindtree.service;

import java.util.List;

import org.springframework.context.ApplicationContext;

import com.mindtree.entity.Actors;
import com.mindtree.exception.ServiceException;

public interface ActorsService {

	public String insertActors(ApplicationContext con,Actors actor) throws ServiceException;
	public String deleteActors(ApplicationContext con,int id) throws ServiceException;
	public List<Actors> selectAllActors(ApplicationContext con) throws ServiceException;
}
