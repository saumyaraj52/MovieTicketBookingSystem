import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Movie {
    String movieName;
    Integer duration;
    Integer price;

    public Movie(String movieName,Integer duration,Integer price)
    {
        this.movieName = movieName;
        this.duration = duration;
        this.price = price;
    }
}
