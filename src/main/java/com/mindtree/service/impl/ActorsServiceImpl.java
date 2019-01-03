package com.mindtree.service.impl;

import java.util.List;

import org.springframework.context.ApplicationContext;

import com.mindtree.dao.impl.ActorsDaoImpl;
import com.mindtree.entity.Actors;
import com.mindtree.exception.DaoException;
import com.mindtree.exception.ServiceException;
import com.mindtree.service.ActorsService;

public class ActorsServiceImpl implements ActorsService {

	private ActorsDaoImpl actorsDao;
	
	@Override
	public String insertActors(ApplicationContext con, Actors actor) throws ServiceException {
		try
		{
			actorsDao=con.getBean("objActorsDao",ActorsDaoImpl.class);
			if(actor.getAge()>14)
				return actorsDao.insertActors(actor);
			else
				return "Can't Save";
		}
		catch(DaoException e)
		{
			throw new ServiceException(e);
		}
	}

	@Override
	public String deleteActors(ApplicationContext con, int id) throws ServiceException {
		try
		{
			actorsDao=con.getBean("objActorsDao",ActorsDaoImpl.class);
			return actorsDao.deleteActors(id);
		}
		catch(DaoException e)
		{
			throw new ServiceException(e);
		}
	}

	@Override
	public List<Actors> selectAllActors(ApplicationContext con) throws ServiceException {
		try
		{
			actorsDao=con.getBean("objActorsDao",ActorsDaoImpl.class);
			return actorsDao.selectAllActors();
		}
		catch(Exception e)
		{
			throw new ServiceException(e);
		}
	}

	
}
