package com.mindtree.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Genre {

	@GeneratedValue
	@Id
	private int id;
	private String name;
	
	@OneToMany(cascade=CascadeType.ALL,fetch=FetchType.LAZY)
	private List<Movie> movie;
	
	public Genre(int id, String name, List<Movie> movie) {
		super();
		this.id = id;
		this.name = name;
		this.movie = movie;
	}

	public Genre() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Movie> getMovie() {
		return movie;
	}

	public void setMovie(List<Movie> movie) {
		this.movie = movie;
	}

	@Override
	public String toString() {
		return "Genere [id=" + id + ", name=" + name + ", movie=" + movie + "]";
	}
	
}
	