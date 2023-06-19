import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MovieController {
    Map<String, List<Movie>> mapOfMovies;
    List<Movie> allMovies;

    public MovieController()
    {
        this.mapOfMovies = new HashMap<>();
        this.allMovies = new ArrayList<>();
    }
    public void movieAdd(String city,Movie movie)
    {
        List<Movie> movieList = this.mapOfMovies.getOrDefault(city,new ArrayList<>());
        movieList.add(movie);
        this.mapOfMovies.put(city,movieList);
        this.allMovies.add(movie);
    }

    public void removeMovie(String city)
    {
        //
    }

    public List<Movie> getMoviesFromCity(String city)
    {
        List<Movie> movieList = this.mapOfMovies.getOrDefault(city,new ArrayList<>());
        return movieList;
    }
}
