package app.entityes;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "seats")
public class Seat {
    @Id
    @Column(name = "seat_Id")
    private Integer seatId;
    @Column(name="row_num")
    private Integer row_num;
    @Column(name="place_num")
    private Integer place_num;
    @ManyToOne
    @JoinColumn(name="hall_id")
    private Hall hall;
    @Column(name="place_type")
    private Integer placeType;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Seat seat = (Seat) o;
        return Objects.equals(seatId, seat.seatId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(seatId);
    }

    @OneToMany(cascade = CascadeType.ALL,
            fetch = FetchType.EAGER,
            mappedBy = "seat")
    private List<Ticket> tickets = new ArrayList<>();

    public List<Ticket> getTickets() {
        return tickets;
    }

    public void setTickets(List<Ticket> tickets) {
        this.tickets = tickets;
    }

    public Integer getSeatId() {
        return seatId;
    }

    public void setSeatId(Integer seatId) {
        this.seatId = seatId;
    }

    public Integer getRow_num() {
        return row_num;
    }

    public void setRow_num(Integer row_num) {
        this.row_num = row_num;
    }

    public Integer getPlace_num() {
        return place_num;
    }

    public void setPlace_num(Integer place_num) {
        this.place_num = place_num;
    }

    public Hall getHall() {
        return hall;
    }

    public void setHall(Hall hall) {
        this.hall = hall;
    }

    public Integer getPlaceType() {
        return placeType;
    }

    public void setPlaceType(Integer placeType) {
        this.placeType = placeType;
    }

}
