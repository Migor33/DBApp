package entityes;

import javax.persistence.*;
import java.util.Date;
@Entity
public class Session {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="session_Id")
    private Integer session_Id;
    @Column(name="film_id")
    private Integer film_id;
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

    public Integer getFilm_id() {
        return film_id;
    }

    public void setFilm_id(Integer film_id) {
        this.film_id = film_id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return film.getName() + "  " + film.getGenre() + "\n" +
                date + "\n" +
                "Обычный билет: " + priceCommon + ", VIP: " + priceVIP;
    }
}
