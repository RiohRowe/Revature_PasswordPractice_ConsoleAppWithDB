package DBInterface.service;

import java.util.List;

import com.revature.model.Movie;
import com.revature.repository.MovieRepositoryImpl;

/*
 * This is the service layer of our application. Its purpose is to allow
 * us to separate our application's concerns. For example, the data
 * layer exists solely to interact with our database -- and nothing more.
 * Any business logic that we would like to implement that IS NOT related
 * to the retrieval/insertion of data should go here.
 */
public class MovieService {

	public List<Movie> getAllMovies(){
		return new MovieRepositoryImpl().getAllMovies();
	}
	
	public void insertMovie(Movie m) {
		new MovieRepositoryImpl().insertMovie(m);
	}
}
