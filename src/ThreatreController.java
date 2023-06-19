import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ThreatreController {
    Map<String, List<Threater>> mapOfThreaters;
    List<Threater> allThreaters;

    public ThreatreController()
    {
        this.mapOfThreaters = new HashMap<>();
        this.allThreaters = new ArrayList<>();
    }
    public void addThreater(String city,Threater threater)
    {
        List<Threater> threaterList = this.mapOfThreaters.getOrDefault(city,new ArrayList<>());
        threaterList.add(threater);
        this.mapOfThreaters.put(city,threaterList);
        this.allThreaters.add(threater);
    }

    public List<Threater> getThreatersFromCity(String city)
    {
        List<Threater> threaterList = this.mapOfThreaters.getOrDefault(city,new ArrayList<>());
        return threaterList;
    }

    public List<Threater> getAllThreaters() {
        return allThreaters;
    }

    public List<MovieShow> getShowsFromMovie(String city,String movie)
    {
        System.out.println("Get Movie Shows Now for cit "+city+"  movie "+movie);
        List<Threater> threaterList = this.mapOfThreaters.getOrDefault(city,new ArrayList<>());
        System.out.println("size of threaterList "+threaterList.size());
        List<MovieShow> returnList = new ArrayList<>();
        int n = threaterList.size();
        for(int i=0;i<n;i++)
        {
            returnList.addAll(threaterList.get(i).showManager.getMoviesFromMovie(movie));
        }
        return returnList;
    }

    public List<Seat> getSeats(MovieShow movieShow)
    {
        List<Seat> seatList = new ArrayList<>();
        Threater threater = movieShow.threater;
        MovieHall movieHall = movieShow.movieHallId;
        for(int i=0;i<movieHall.seatList.size();i++)
        {
            if(movieHall.seatList.get(i).seatStatus == SeatStatus.FREE) {
                seatList.add(movieHall.seatList.get(i));
            }
        }
        return seatList;
    }
    public Reservation makeReservation(MovieShow movieShow,Seat seat,Threater threater)
    {
        int billAmount = movieShow.movie.price;
        Bill bill= new Bill(billAmount,BillStatus.PENDIND,new Payment(PaymentStatus.PENDING));
        Reservation reservation = new Reservation(movieShow,seat,bill,ReservationStatus.PENDING);
        threater.reservationList.add(reservation);
        return reservation;
    }
}
