/**
 * 
 */
package process;


import java.util.List;

import model.Movie;
import model.User;
import reader.ReadMovies;

public class Main {
	
	public static void main(String[] args) {
		User user = new User();
		System.out.println("Selecione os gêreneros de seu interesse:");
		
		ReadMovies readMovies = new ReadMovies("filmes.txt");
		List<Movie> movies = readMovies.read();
		System.out.println(movies.size());
	}
}
