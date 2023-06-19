import java.util.List;

public class Main {
    public static void main(String[] args) throws InterruptedException {

        System.out.println("Starting Ticket System");
        MovieController movieController = new MovieController();
        ThreatreController threatreController= new ThreatreController();

        Movie movieFirst = new Movie("Happy",100,10);
        Movie movieSecond = new Movie("Birthday",100,10);
        Movie movieThird= new Movie("To",100,10);
        Movie movieFourth = new Movie("You",100,10);
        Movie movieFifth = new Movie("New",100,20);
        Movie movieSixth = new Movie("Year",100,10);
        Movie movieSeventh = new Movie("Titanic",100,10);
        Movie movieEighth = new Movie("Smile",100,10);

        movieController.movieAdd("Bangalore",movieFirst);
        movieController.movieAdd("Bangalore",movieSecond);
        movieController.movieAdd("Bangalore",movieThird);
        movieController.movieAdd("Bangalore",movieFourth);
        movieController.movieAdd("Hyderabad",movieFifth);
        movieController.movieAdd("Hyderabad",movieSixth);
        movieController.movieAdd("Hyderabad",movieSeventh);
        movieController.movieAdd("Hyderabad",movieEighth);

        MovieHall movieHall1 = new MovieHall();
        MovieHall movieHall2 = new MovieHall();
        MovieHall movieHall3 = new MovieHall();
        MovieHall movieHall4 = new MovieHall();
        MovieHall movieHall5 = new MovieHall();
        MovieHall movieHall6 = new MovieHall();

        ShowManager showManager = new ShowManager();

        MovieShow movieShow1 = new MovieShow(movieFirst,movieHall1,10);
        MovieShow movieShow2 = new MovieShow(movieSecond,movieHall2,5);
        MovieShow movieShow3 = new MovieShow(movieFirst,movieHall3,3);
        showManager.addShow(movieShow1);
        showManager.addShow(movieShow2);
        showManager.addShow(movieShow3);

        ShowManager showManager1 = new ShowManager();

        MovieShow movieShow4 = new MovieShow(movieFourth,movieHall4,10);
        MovieShow movieShow5 = new MovieShow(movieFifth,movieHall5,5);
        MovieShow movieShow6 = new MovieShow(movieSixth,movieHall6,3);
        showManager1.addShow(movieShow4);
        showManager1.addShow(movieShow5);
        showManager1.addShow(movieShow6);



        Threater threater1 = new Threater(5,showManager);
        Threater threater2 = new Threater(5,showManager1);
        movieShow1.threater = threater1;
        movieShow2.threater = threater1;
        movieShow3.threater = threater1;
        movieShow4.threater = threater2;
        movieShow5.threater = threater2;
        movieShow6.threater = threater2;


        threatreController.addThreater("Bangalore",threater1);
        threatreController.addThreater("Bangalore",threater2);

        TicketBookingSystem ticketBookingSystem = new TicketBookingSystem(movieController,threatreController);

        List<MovieShow> getListOfMovieShows = ticketBookingSystem.getMovieShowFromCityAndMovie("Bangalore","Happy");
        System.out.println("Size : "+getListOfMovieShows.size());
        for(int i=0;i<getListOfMovieShows.size();i++)
        {
            System.out.println(getListOfMovieShows.get(i).movie.movieName);
        }
        MovieShow requiredMovieShow = getListOfMovieShows.get(0);

        Threater requiredThreater = requiredMovieShow.threater;

        List<Seat> seatList = threatreController.getSeats(requiredMovieShow);

        for(int i=0;i<seatList.size();i++)
        {
            System.out.println(seatList.get(i).id);
        }
        Seat seat = seatList.get(0);
        Reservation reservation = threatreController.makeReservation(requiredMovieShow,seat,requiredThreater);
        Integer billamount = reservation.getBill();
        Boolean paymentStatus = reservation.makePayment();
        seat.seatStatus =SeatStatus.RESERVED;

        System.out.println("Ticket Booking Success");

        Thread.sleep(10000);

    }
}