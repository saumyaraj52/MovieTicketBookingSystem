import java.util.List;

public class TicketBookingSystem {
    MovieController movieController;
    ThreatreController threatreController;

    public TicketBookingSystem(MovieController movieController,ThreatreController threatreController)
    {
        this.movieController=movieController;
        this.threatreController=threatreController;
    }
    public List<Movie> getMovieFromCity(String city)
    {
        return this.movieController.getMoviesFromCity(city);
    }

    public List<Threater> getThreaterFromCity(String city)
    {
        return this.threatreController.getThreatersFromCity(city);
    }

    public List<MovieShow> getMovieShowFromCityAndMovie(String city,String movie)
    {
        return this.threatreController.getShowsFromMovie(city,movie);
    }
}
