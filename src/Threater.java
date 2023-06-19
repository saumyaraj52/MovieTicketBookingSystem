import java.util.ArrayList;
import java.util.List;

public class Threater {
    List<MovieHall> movieHallList;
    List<Reservation> reservationList;

    ShowManager showManager;

    public Threater(int noOfList,ShowManager showManager)
    {
        this.movieHallList = new ArrayList<>(noOfList);
        for(int i=0;i<noOfList;i++)
        {
            this.movieHallList.add(new MovieHall());
        }
        this.reservationList = new ArrayList<>();
        this.showManager = showManager;
    }
    public List<Seat> getSeats(MovieShow movieShow)
    {
        List<Seat> seatList = new ArrayList<>();
        return seatList;
    }
    public Reservation makeReservation(MovieShow movieShow,Seat seat)
    {
        int billAmount = movieShow.movie.price;
        Bill bill= new Bill(billAmount,BillStatus.PENDIND,new Payment(PaymentStatus.PENDING));
        Reservation reservation = new Reservation(movieShow,seat,bill,ReservationStatus.PENDING);
        this.reservationList.add(reservation);
        return reservation;
    }
}
