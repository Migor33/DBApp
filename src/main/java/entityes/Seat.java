package entityes;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Seat {
    @Id
    @Column(name = "seat_Id")
    private Integer seeatId;
    @Column(name="row_num")
    private Integer row_num;
    @Column(name="place_num")
    private Integer place_num;
    @ManyToOne
    @JoinColumn(name="hall_id")
    private Hall hall;
    @Column(name="place_type")
    private Integer placeType;



    public Integer getSeeatId() {
        return seeatId;
    }

    public void setSeeatId(Integer seeatId) {
        this.seeatId = seeatId;
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
