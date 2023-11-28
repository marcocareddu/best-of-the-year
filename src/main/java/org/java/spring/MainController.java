package org.java.spring;

import java.util.Arrays;
import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class MainController {

	@GetMapping("/")
	@ResponseBody
	public String index(Model model) {
		String name = "Marco";
		model.addAttribute("username", name);
		return "<h1>Best of the year by " + name + "</h1>";
	}

	private List<Movie> getBestMovies() {
		return Arrays.asList(new Movie(1, "Il signore degli anelli"), new Movie(2, "2001: Odissea nello spazio"),
				new Movie(3, "Kill Bill"), new Movie(4, "V per Vendetta"));
	}

	private List<Song> getBestSongs() {
		return Arrays.asList(new Song(1, "Il suicidio del samurai"), new Song(2, "Voglio una pelle splendida"),
				new Song(3, "Vengo dalla luna"), new Song(4, "Giant steps"));
	}

	@GetMapping("/movies")
	public String getMovies(Model model) {

		List<Movie> movies = getBestMovies();
		String moviesList = "";

		for (int i = 0; i < movies.size(); i++) {
			Movie movie = movies.get(i);
			moviesList += movie.getId() + " - ";
			moviesList += movie.getTitle();

			if (i < movies.size() - 1) {
				moviesList += ", ";
			}
		}

		model.addAttribute("moviesList", moviesList);

		return "movies";
	}

	@GetMapping("/songs")
	public String getSongs(Model model) {

		List<Song> songs = getBestSongs();
		String songsList = "";

		for (int i = 0; i < songs.size(); i++) {
			Song song = songs.get(i);
			songsList += song.getId() + " - ";
			songsList += song.getTitle();

			if (i < songs.size() - 1) {
				songsList += ", ";
			}
		}
		model.addAttribute("songsList", songsList);
		return "songs";
	}

	@GetMapping("/movies/{id}")
	public String movie(Model model, @PathVariable int id) {

		String movieTitle = "";

		List<Movie> movies = getBestMovies();

		for (Movie movie : movies) {
			if (movie.getId() == id) {
				movieTitle = movie.getTitle();
				break;
			}
		}
	    model.addAttribute("movieTitle", movieTitle);
	    
	    return "movie";
	}

	@GetMapping("/songs/{id}")
	public String song(Model model, @PathVariable int id) {

		String songTitle = "";

		List<Song> songs = getBestSongs();

		for (Song song : songs) {
			if (song.getId() == id) {
				songTitle = song.getTitle();
				break;
			}
		}
	    model.addAttribute("songTitle", songTitle);
	    
	    return "song";
	}
}