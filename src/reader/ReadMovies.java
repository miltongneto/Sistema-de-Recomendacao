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
		String[] genres = info[2].split(",");
		
		movie.setTitle(info[0]);
		movie.setYear(Integer.parseInt(info[1]));	
		movie.setGenre(Arrays.asList(genres));
		movie.setRate(Double.parseDouble(info[3]));
		return movie;
	}
}
