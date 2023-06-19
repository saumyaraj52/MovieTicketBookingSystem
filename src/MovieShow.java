public class MovieShow {
    Movie movie;
    MovieHall movieHallId;
    Integer StartTime;
    Threater threater;

    public MovieShow(Movie movie, MovieHall movieHallId, Integer startTime) {
        this.movie = movie;
        this.movieHallId = movieHallId;
        this.StartTime = startTime;
    }
}
