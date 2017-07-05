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
		
		List<String> preferences = new ArrayList<String>();
		preferences.add(Genres.ACTION.getName());
		preferences.add(Genres.ADVENTURE.getName());
		preferences.add(Genres.COMEDY.getName());
		user.setPreferences(preferences);
		user.setName("Allan");
		
		ReadMovies readMovies = new ReadMovies("filmes.tsv");
		List<Movie> movies = readMovies.read();
		System.out.println(movies.size());
	}
}
