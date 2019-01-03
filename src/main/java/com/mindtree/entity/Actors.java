package com.mindtree.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Actors {

	@GeneratedValue
	@Id
	private int id;
	private String name;
	private int age;
	private String gender;
	
	@OneToMany(cascade=CascadeType.ALL,fetch=FetchType.LAZY)
	private List<Movie> movies;

	public Actors(int id, String name, int age, String gender, List<Movie> movies) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.gender = gender;
		this.movies = movies;
	}

	public Actors() {
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

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public List<Movie> getMovies() {
		return movies;
	}

	public void setMovies(List<Movie> movies) {
		this.movies = movies;
	}

	@Override
	public String toString() {
		return "Actors [id=" + id + ", name=" + name + ", age=" + age + ", gender=" + gender + ", movies=" + movies
				+ "]";
	}
}
