package util;

public enum Genres {
	
	ACTION("Action", 0),
	ADVENTURE("Adventure", 1),
	FANTASY("Fantasy", 2),
	SCI_FI("Sci-Fi", 3),
	THRILLER("Thriller", 4),
	DOCUMENTARY("Documentary", 5),
	ROMANCE("Romance", 6),
	ANIMATION("Animation", 7),
	COMEDY("Comedy", 8),
	FAMILY("Family", 9),
	MUSICAL("Musical", 10),
	MYSTERY("Mystery", 11),
	WESTERN("Western", 12),
	DRAMA("Drama", 13),
	HISTORY("History", 14),
	SPORT("Sport", 15),
	CRIME("Crime", 16),
	HORROR("Horror", 17),
	WAR("War", 18),
	BIOGRAPHY("Biography", 19),
	MUSIC("Music", 20),
	GAME_SHOW("Game-Show", 21),
	REALITY_TV("Reality-TV", 22),
	NEWS("News", 23),
	SHORT("Short", 24),
	FILM_NOIR("Film-Noir", 25);
	
	private String name;
	private Integer code;
	
	private Genres(String name, Integer code) {
		this.name = name;
		this.code = code;
	}
	
	public Integer getCode() {
		return this.code;
	}
	
	public String getName() {
		return this.name;
	}
}
