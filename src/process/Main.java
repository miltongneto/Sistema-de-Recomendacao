/**
 * 
 */
package process;


import java.util.ArrayList;
import java.util.List;

import model.Movie;
import model.User;
import reader.ReadMovies;
import util.Genres;

public class Main {
	
	public static void main(String[] args) {
		User user = new User();
		System.out.println("Selecione os gêreneros de seu interesse:");
		System.out.println("1 - Action");
		
		
		List<String> preferences = new ArrayList<String>();
		preferences.add(Genres.ACTION.getName());
		preferences.add(Genres.ADVENTURE.getName());
		preferences.add(Genres.COMEDY.getName());
		user.setPreferences(preferences);
		user.setName("Allan");
		
		ReadMovies readMovies = new ReadMovies("filmes.tsv");
		List<Movie> movies = readMovies.read();
		Recommendation recommendation = new Recommendation(user, movies);

		System.out.println(movies.size());
		for(int i = 0; i < Genres.values().length; i++) {
			System.out.println(Genres.values()[i].getCode() + " - " + Genres.values()[i].getName());
		}
	}
	
}
