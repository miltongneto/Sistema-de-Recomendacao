package model;

import java.util.List;

public class Movie {
	
	private String title;
	private String director;
	private String actor;
	private List<String> genres;
	private List<String> keywords;
	private int scoreIMDB;
	private double likes;
	private int year;
	private double ranking;
	
	public Movie() {
		
	}

	public Movie(String title, List<String> genre, int score, int year) {
		this.title = title;
		this.genres = genre;
		this.scoreIMDB = score;
		this.year = year;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public List<String> getGenres() {
		return genres;
	}

	public void setGenres(List<String> genre) {
		this.genres = genre;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public String getDirector() {
		return director;
	}

	public void setDirector(String director) {
		this.director = director;
	}

	public String getActor() {
		return actor;
	}

	public void setActor(String actor) {
		this.actor = actor;
	}

	public List<String> getKeywords() {
		return keywords;
	}

	public void setKeywords(List<String> keywords) {
		this.keywords = keywords;
	}

	public int getScoreIMDB() {
		return scoreIMDB;
	}

	public void setScoreIMDB(int score) {
		this.scoreIMDB = score;
	}

	public double getLikes() {
		return likes;
	}

	public void setLikes(double likes) {
		this.likes = likes;
	}

	public double getRanking() {
		return ranking;
	}

	public void setRanking(double ranking) {
		this.ranking = ranking;
	}

}
