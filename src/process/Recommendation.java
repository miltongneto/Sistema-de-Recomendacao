package process;

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

}
