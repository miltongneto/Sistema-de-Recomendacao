package reader;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import model.Movie;

public class ReadMovies {
	
	private String path;
	
	public ReadMovies(String path) {
		this.path = path;
	}
	
	public List<Movie> read() {
		List<Movie> movies = new ArrayList<>();
		BufferedReader br;
		
		try {
			br = new BufferedReader(new FileReader(path));
			while(br.ready()) {
				movies.add(parseStringToMovie(br.readLine()));
			}
			br.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return movies;
	}
	
	private static Movie parseStringToMovie(String line) {
		Movie movie = new Movie();
		String[] info = line.split("\t");
		String[] genres = info[1].split(";");
		String[] keywords = info[4].split(";");
		
		movie.setDirector(info[0]);
		movie.setGenres(Arrays.asList(genres));
		movie.setActor(info[2]);
		movie.setTitle(info[3]);
		movie.setKeywords(Arrays.asList(keywords));
		movie.setYear(Integer.parseInt(!info[5].isEmpty() ? info[5] : "0"));
		movie.setScoreIMDB(Integer.parseInt(info[6]));
		movie.setLikes((double) Double.parseDouble(info[7]) / 3490);
		movie.setRanking((movie.getScoreIMDB() * 8 + movie.getLikes()*2)/10);
		return movie;
	}
}
