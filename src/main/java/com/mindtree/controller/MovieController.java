package com.mindtree.controller;

import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.mindtree.entity.Actors;
import com.mindtree.entity.Genre;
import com.mindtree.entity.Movie;
import com.mindtree.exception.ServiceException;
import com.mindtree.service.impl.ActorsServiceImpl;
import com.mindtree.service.impl.GenreServiceImpl;
import com.mindtree.service.impl.MovieServiceImpl;

@Controller
public class MovieController {

	private ApplicationContext con=new ClassPathXmlApplicationContext("Beans.xml");
	private MovieServiceImpl movieService=con.getBean("objMovieService",MovieServiceImpl.class);
	private ActorsServiceImpl actorsService=con.getBean("objActorsService",ActorsServiceImpl.class);
	private GenreServiceImpl genreService=con.getBean("objGenreService",GenreServiceImpl.class);
	
	@RequestMapping("/")
	public ModelAndView indexDisplay() {
		return new ModelAndView("index");
	}
	
	@RequestMapping("/actorPage")
	public ModelAndView actorPage()
	{
		return new ModelAndView("actorPage");
	}
	
	@RequestMapping("/genrePage")
	public ModelAndView genrePage()
	{
		return new ModelAndView("genrePage");
	}
	
	@RequestMapping("/moviePage")
	public ModelAndView moviePage()
	{
		return new ModelAndView("moviePage");
	}
	
	@RequestMapping("/addActor")
	public ModelAndView addActor()
	{
		return new ModelAndView("addActor");
	}
	
	@RequestMapping("/saveActor")
	public ModelAndView saveActorPage(@ModelAttribute Actors actor)
	{
		try
		{
			actorsService.insertActors(con, actor);
			return new ModelAndView("actorPage");
		}
		catch(ServiceException e)
		{
			return new ModelAndView("failActor");
		}
	}
	
	@RequestMapping("/updateBox")
	public ModelAndView updateBoxoffice()
	{
		return new ModelAndView("updateBoxoffice");
	}
	
	@RequestMapping("/selectAllActors")
	public ModelAndView listAllActors() {
		try
		{
			return new ModelAndView("selectAllActor","actors",actorsService.selectAllActors(con));
		}
		catch(ServiceException e)
		{	
			return new ModelAndView("failActor");
		}
	}
	
	@RequestMapping("/addGenre")
	public ModelAndView addGenre()
	{
		return new ModelAndView("addGenre");
	}
	
	@RequestMapping("/saveGenre")
	public ModelAndView saveGenrePage(@ModelAttribute Genre genre) {
		try
		{
			genreService.insertGenre(con, genre);
			return new ModelAndView("genrePage");
		}
		catch(ServiceException e)
		{
			return new ModelAndView("failGenre");
		}
	}
	
	@RequestMapping("/showGenre")
	public ModelAndView listAllGenre() {
		try
		{
			return new ModelAndView("selectAllGenre","genre",genreService.selectAllGenre(con));
		}
		catch(ServiceException e)
		{
			return new ModelAndView("failGenre");
		}
	}
	
	@RequestMapping("/addMovie")
	public ModelAndView addMovie()
	{
		return new ModelAndView("addMovie");
	}
	
	@RequestMapping("/saveMovie")
	public ModelAndView savemoviePage(@ModelAttribute Movie movie,HttpServletRequest request) {
		try
		{
			Actors actor=con.getBean("objActors",Actors.class);
			actor.setId(Integer.parseInt(request.getParameter("actors_id")));
			Genre genre=con.getBean("objGenre",Genre.class);
			genre.setId(Integer.parseInt(request.getParameter("genre_id")));
			movie.setGenere(genre);
			movie.setActors(actor);
			movieService.insertMovie(con, movie);
		
			return new ModelAndView("moviePage");
		}
		catch(ServiceException e)
		{
			return new ModelAndView("failMovie");
		}
	}
	
	@RequestMapping("/showMovie")
	public ModelAndView listAllMovie() {
		try
		{
			return new ModelAndView("selectAllMovie","movie",movieService.selectAllMovie(con));
		}
		catch(ServiceException e)
		{
			return new ModelAndView("failMovie");
		}
	}
	
	
	@RequestMapping("/highestGrossingMovie")
	public ModelAndView highestGrossingMovie() {
		
		try
		{
			List<Movie> movie=movieService.selectAllMovie(con);

			Movie movie1=movie.stream().reduce((m1,m2)-> {
				if(m1.getBoxoffice()>m2.getBoxoffice())
					return m1;
				else
					return m2;
			}).get();
			return new ModelAndView("highestGrossingMovie","movie",movie1);
		}
		catch(ServiceException e)
		{
			return new ModelAndView("failMovie");
		}
	}
	
	@RequestMapping("/selectOnGenre")
	public ModelAndView selectGenre()
	{
		return new ModelAndView("selectOnGenre");
	}
	
	@RequestMapping("/selectOnGenreList")
	public ModelAndView listMovieOnGenre(HttpServletRequest request) {
		try
		{
			return new ModelAndView("selectOnGenreList","movie",movieService.selectAllMovie(con).stream()
					.filter(m-> {
						Genre gen=m.getGenere();
						return gen.getName().equalsIgnoreCase(request.getParameter("genre_name"));
					}).collect(Collectors.toList()));
		}
		catch(ServiceException e)
		{
			return new ModelAndView("failMovie");
		}
	}
	
	@RequestMapping("/updateBoxoffice")
	public ModelAndView changeBoxoffice(HttpServletRequest request) {
		try
		{
			double boxoffice=Double.parseDouble(""+request.getParameter("boxoffice"));
			int id=Integer.parseInt(""+request.getParameter("id"));
			movieService.updateBoxOffice(con, boxoffice, id);
			return new ModelAndView("moviePage");
		}
		catch(ServiceException e)
		{
			return new ModelAndView("failMovie");
		}
	}
}

