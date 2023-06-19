import java.util.ArrayList;
import java.util.List;

public class ShowManager {
    List<MovieShow> movieShowList;

    public ShowManager()
    {
        this.movieShowList = new ArrayList<>();
    }

    public void addShow(MovieShow movieShow)
    {
        this.movieShowList.add(movieShow);
    }

    public void removeShow(MovieShow movieShow)
    {
        this.movieShowList.remove(movieShow);
    }

    public List<MovieShow> getMoviesFromMovie(String moviesName)
    {
        List<MovieShow> ans = new ArrayList<>();
        for(int i =0;i<this.movieShowList.size();i++) {
            if (this.movieShowList.get(i).movie.movieName == moviesName)
                ans.add(this.movieShowList.get(i));
        }
        return ans;
    }
}
