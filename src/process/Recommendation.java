package process;

import java.util.Comparator;
import java.util.List;

import model.Movie;
import model.User;

public class Recommendation {
	
	private User user;
	private List<Movie> movies;
	
	public Recommendation(User user, List<Movie> movies) {
		this.user = user;
		this.movies = movies;
	}
	
	public void firstRecommendation() {
		for(Movie movie : movies) {
			double ranking = movie.getRanking();// USER_RANKING * 7 + GENERO * 3;
			for(String preference : user.getPreferences()){
				if(movie.getGenres().contains(preference)) {
					ranking = ranking * 0.6 + 40;
				}
			}
			movie.setRanking(ranking);
		}
		orderByRanking();
	}
	
	public void recommendationByMovies(List<Movie> moviesLikes, List<Movie> moviesDislikes) {
		recommendation(moviesLikes, 20, 20, 0.90, 10);
		recommendation(moviesDislikes, 0, 0, 0.95, 0);
		
		orderByRanking();
	}
	
	public void recommendation(List<Movie> userMovies, double actor, double director, double keywordRanking1, int keywordRanking2) {
		for(Movie movieLike : userMovies) {
			for(Movie movie : movies) {
				double ranking = movie.getRanking();
				if(movie.getActor().equals(movieLike.getActor())) ranking = ranking * 0.8 + actor;
 				if(movie.getDirector().equals(movieLike.getDirector())) ranking = ranking * 0.8 + director;
 				
 				for(String keyword : movie.getKeywords()) {
 					for(String keywordMovieLike : movieLike.getKeywords()) {
 						if(keyword.equals(keywordMovieLike)) ranking = ranking * keywordRanking1 + keywordRanking2;
 					}
 				}
				
 				movie.setRanking(ranking);
			}
		}
	}
	
	
	public void orderByRanking() {
		movies.sort(new Comparator<Movie>() {

			@Override
			public int compare(Movie m1, Movie m2) {
				return Double.compare(m2.getRanking(), m1.getRanking());
			}
		});
	}
	
	public List<Movie> getMovies() {
		return this.movies;
	}
	
}
