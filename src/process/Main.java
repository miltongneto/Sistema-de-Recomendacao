/**
 * 
 */
package process;


import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;

import model.Movie;
import model.User;
import reader.ReadMovies;
import util.Genres;

public class Main {
	
	public static void main(String[] args) {
		User user = new User();
		Scanner in=new Scanner(System.in);
		List<Integer>listEscolhidos=new ArrayList<>();
		List<Integer>listLike=new ArrayList<>();
		List<Integer>listDislike=new ArrayList<>();
		
		for(int i = 3; i < Genres.values().length; i= i+4) {
			int j = i-1;
			int w = i-2;
			int z = i-3;
			System.out.print(Genres.values()[z].getCode() + " - " + Genres.values()[z].getName() + "		");
			System.out.print(Genres.values()[w].getCode() + " - " + Genres.values()[w].getName() + "		");
			System.out.print(Genres.values()[j].getCode() + " - " + Genres.values()[j].getName() + "		");
			System.out.println(Genres.values()[i].getCode() + " - " + Genres.values()[i].getName());
			if(i == 23){
				System.out.print(Genres.values()[24].getCode() + " - " + Genres.values()[24].getName() + "		");
				System.out.println(Genres.values()[25].getCode() + " - " + Genres.values()[25].getName());
			}
		}
		System.out.println();
		
		System.out.println("Digite o número correspondente ao gênero desejado:");
		String escolhidos = "s";
		
		while(escolhidos.equalsIgnoreCase("s")){
			String aux = in.nextLine();
			int aux2 = Integer.parseInt(aux);
			listEscolhidos.add(aux2);
			System.out.println("Deseja escolher outro gênero? s/n");
			escolhidos = in.nextLine();
			if(escolhidos.equalsIgnoreCase("n")) break;
			System.out.println("Digite o número correspondente ao gênero desejado:");
		}
		
		List<String> preferences = new ArrayList<String>();
		for(int i=0;i<listEscolhidos.size();i++){
			int aux=listEscolhidos.get(i);
			preferences.add(Genres.values()[aux].getName());
			System.out.println(Genres.values()[aux].getName());
		}
		
		user.setPreferences(preferences);
		user.setName("Allan");
		
		ReadMovies readMovies = new ReadMovies("dbmovies.tsv");
		List<Movie> movies = readMovies.read();
		Recommendation recommendation = new Recommendation(user, movies);
		recommendation.firstRecommendation();
		
		for(int i = 0; i < 30 ; i++) {
			Movie movie = recommendation.getMovies().get(i);
			System.out.println(i + " Titulo " + movie.getTitle() + " Ranking " + movie.getRanking() + " Score IMDB " + movie.getScoreIMDB());
		}
		
		String likes="s";
		System.out.println("Digite o número do filme que deseja dar like:");
		while(likes.equalsIgnoreCase("s")){
			String aux = in.nextLine();
			int aux2 = Integer.parseInt(aux);
			listLike.add(aux2);
			System.out.println("Deseja escolher outro filme? s/n");
			likes = in.nextLine();
			if(likes.equalsIgnoreCase("n")) break;
			System.out.println("Digite o número do filme que deseja dar like");
		}
		
		String dislikes="s";
		System.out.println("Digite o número do filme que deseja retirar:");
		while(dislikes.equalsIgnoreCase("s")){
			String aux = in.nextLine();
			int aux2 = Integer.parseInt(aux);
			listDislike.add(aux2);
			System.out.println("Deseja escolher outro filme? s/n");
			dislikes = in.nextLine();
			if(dislikes.equalsIgnoreCase("n")) break;
			System.out.println("Digite o número do filme que deseja retirar:");
		}
		
		System.out.println("-------------------------------------------");
		
		List<Integer> index = new ArrayList<Integer>();
		index.addAll(listLike);
		index.addAll(listDislike);
		
		List<Movie> moviesLikes = new ArrayList<>();
		for(int i=0; i < listLike.size();i++){
			int aux = listLike.get(i);
			moviesLikes.add(recommendation.getMovies().get(aux));
			//recommendation.getMovies().remove(aux);
		}
		
		List<Movie> moviesDislikes = new ArrayList<>();
		
		for(int i=0; i < listDislike.size();i++){
			int aux = listDislike.get(i);
			moviesDislikes.add(recommendation.getMovies().get(aux));
			//recommendation.getMovies().remove(aux);
		}
		
		index.sort(new Comparator<Integer>() {

			@Override
			public int compare(Integer o1, Integer o2) {
				return o1.compareTo(o2);
			}
		});
		for(int i =index.size()-1; i==0;i-- ){
			int aux = index.get(i);
			recommendation.getMovies().remove(aux);
		}
			
		recommendation.recommendationByMovies(moviesLikes, moviesDislikes);
		for(int i = 0; i < 30 ; i++) {
			Movie movie = recommendation.getMovies().get(i);
			System.out.println(i + " Titulo " + movie.getTitle() + " Ranking " + movie.getRanking() + " Score IMDB " + movie.getScoreIMDB());
		}
		in.close();

	}
	
}
