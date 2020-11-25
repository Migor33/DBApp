package entityes;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Hall {
    @Id
    @Column(name="holl_id")
    private Integer hollId;
    @OneToMany(cascade = CascadeType.ALL,
            fetch = FetchType.LAZY,
            mappedBy = "hall")
    private List<Seat> seats = new ArrayList<>();
    @OneToMany(cascade = CascadeType.ALL,
            fetch = FetchType.LAZY,
            mappedBy = "hall")
    private List<Session> sessions = new ArrayList<>();

    public Integer getHollId() {
        return hollId;
    }

    public void setHollId(Integer hollId) {
        this.hollId = hollId;
    }

    public List<Seat> getSeats() {
        return seats;
    }

    public void setSeats(List<Seat> seats) {
        this.seats = seats;
    }

    public List<Session> getSessions() {
        return sessions;
    }

    public void setSessions(List<Session> sessions) {
        this.sessions = sessions;
    }
}
