package com.mindtree.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Movie{

	@GeneratedValue
	@Id
	private int id;
	private String name;
	private double boxoffice;
	private String type;
	
	@ManyToOne
	private Actors actors;
	
	@ManyToOne
	private Genre genre;

	public Movie(int id, String name, double boxoffice, String type, Actors actors, Genre genere) {
		super();
		this.id = id;
		this.name = name;
		this.boxoffice = boxoffice;
		this.type = type;
		this.actors = actors;
		this.genre = genere;
	}

	public Movie() {
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

	public double getBoxoffice() {
		return boxoffice;
	}

	public void setBoxoffice(double boxoffice) {
		this.boxoffice = boxoffice;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public Actors getActors() {
		return actors;
	}

	public void setActors(Actors actors) {
		this.actors = actors;
	}

	public Genre getGenere() {
		return genre;
	}

	public void setGenere(Genre genere) {
		this.genre = genere;
	}

	@Override
	public String toString() {
		return "Movie [id=" + id + ", name=" + name + ", boxoffice=" + boxoffice + ", type=" + type + ", actors="
				+ actors + ", genere=" + genre + "]";
	}
}
