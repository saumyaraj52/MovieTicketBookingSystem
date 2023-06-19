import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class MovieHall {
    List<Seat> seatList;

    public MovieHall()
    {
        this.seatList = new ArrayList<>(100);
        for(int i=0;i<101;i++)
        {
            this.seatList.add(new Seat(i,SeatStatus.FREE));
        }
    }
}
