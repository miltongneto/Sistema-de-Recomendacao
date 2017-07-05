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
		preferences.add(Genres.SCI_FI.getName());
		user.setPreferences(preferences);
		user.setName("Allan");
		
		ReadMovies readMovies = new ReadMovies("filmes.tsv");
		List<Movie> movies = readMovies.read();
		Recommendation recommendation = new Recommendation(user, movies);
		recommendation.firstRecommendation();
		
		for(int i = 0; i < 30 ; i++) {
			Movie movie = recommendation.getMovies().get(i);
			System.out.println(i + " Titulo " + movie.getTitle() + " Ranking " + movie.getRanking() + " Score IMDB " + movie.getScoreIMDB());
		}
		System.out.println("-------------------------------------------");
		List<Movie> moviesLikes = new ArrayList<>();
		moviesLikes.add(recommendation.getMovies().get(7));
		moviesLikes.add(recommendation.getMovies().get(11));
		recommendation.getMovies().remove(7);
		recommendation.getMovies().remove(11);
		
		List<Movie> moviesDislikes = new ArrayList<>();
		moviesDislikes.add(recommendation.getMovies().get(9));
		
		recommendation.recommendationByMovies(moviesLikes, moviesDislikes);
		for(int i = 0; i < 30 ; i++) {
			Movie movie = recommendation.getMovies().get(i);
			System.out.println(i + " Titulo " + movie.getTitle() + " Ranking " + movie.getRanking() + " Score IMDB " + movie.getScoreIMDB());
		}

	}
	
}
