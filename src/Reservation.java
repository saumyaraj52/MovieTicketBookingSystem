public class Reservation {
    MovieShow movieShow;
    Seat seat;
    Bill bill;
    ReservationStatus reservationStatus;
    public Reservation(MovieShow movieShow,Seat seat,Bill bill,ReservationStatus reservationStatus)
    {
        this.movieShow = movieShow;
        this.bill = bill;
        this.seat = seat;
        this.reservationStatus = reservationStatus;
    }

    public Integer getBill()
    {
        return this.movieShow.movie.price;
    }

    public boolean makePayment()
    {
        this.bill.payment.paymentStatus = PaymentStatus.SUCCESS;
        this.bill.billStatus = BillStatus.SUCCESS;
        this.reservationStatus = ReservationStatus.SUCCESS;
        return true;
    }
}
