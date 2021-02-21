package app.entityes;

import javax.persistence.*;

@Entity
@Table(name = "tickers")
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="ticket_Id")
    private Integer ticketId;
    @ManyToOne
    @JoinColumn(name="seat_id")
    private Seat seat;
    @ManyToOne
    @JoinColumn(name="session_Id")
    private Session session;


    public Integer getTicketId() {
        return ticketId;
    }

    public void setTicketId(Integer ticketId) {
        this.ticketId = ticketId;
    }

    public Seat getSeat() {
        return seat;
    }

    public void setSeat(Seat seat) {
        this.seat = seat;
    }

    public Session getSession() {
        return session;
    }

    public void setSession(Session session) {
        this.session = session;
    }

}
