package app.entityes;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "sessions")
public class Session {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="session_Id")
    private Integer session_Id;
    @Column(name="date")
    private Date date;
    @Column(name="price_common")
    private double priceCommon;
    @Column(name="price_VIP")
    private double priceVIP;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "film_id")
    private Film film;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "hall_id")
    private Hall hall;
    @OneToMany(cascade = CascadeType.ALL,
            fetch = FetchType.EAGER,
            mappedBy = "session")
    private List<Ticket> tickets = new ArrayList<>();

    public List<Ticket> getTickets() {
        return tickets;
    }

    public void setTickets(List<Ticket> tickets) {
        this.tickets = tickets;
    }

    public Hall getHall() {
        return hall;
    }

    public void setHall(Hall hall) {
        this.hall = hall;
    }

    public Film getFilm() {
        return film;
    }

    public void setFilm(Film film) {
        this.film = film;
    }

    public double getPriceCommon() {
        return priceCommon;
    }

    public void setPriceCommon(double priceCommon) {
        this.priceCommon = priceCommon;
    }

    public double getPriceVIP() {
        return priceVIP;
    }

    public void setPriceVIP(double priceVIP) {
        this.priceVIP = priceVIP;
    }

    public Integer getSession_Id() {
        return session_Id;
    }

    public void setSession_Id(Integer session_Id) {
        this.session_Id = session_Id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

}
