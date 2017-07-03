package model;

import java.util.List;

public class Movie {
	
	private String title;
	private List<String> genre;
	private double rate;
	private int year;
	
	public Movie() {
		
	}

	public Movie(String title, List<String> genre, double rate, int year) {
		this.title = title;
		this.genre = genre;
		this.rate = rate;
		this.year = year;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public List<String> getGenre() {
		return genre;
	}

	public void setGenre(List<String> genre) {
		this.genre = genre;
	}

	public double getRate() {
		return rate;
	}

	public void setRate(double rate) {
		this.rate = rate;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

}
