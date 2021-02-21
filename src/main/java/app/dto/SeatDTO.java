package app.dto;

import app.entityes.Seat;
import app.entityes.Session;

import javax.persistence.criteria.CriteriaBuilder;
import java.util.List;
import java.util.stream.Collectors;

public class SeatDTO {
    public Integer seatId;
    public Integer place_num;
    public Integer row_num;
    public boolean isfree;


    public static SeatDTO[][] getDTOS(Session session) {
        SeatDTO[][] seatDTOS = new SeatDTO[7][];
        for (int i = 0; i < 3; i++) {
            seatDTOS[i] =new SeatDTO[2];
        }
        for (int i = 3; i < 7; i++) {
            seatDTOS[i] = new SeatDTO[1];
        }
        for (Seat seat :
                session.getHall().getSeats()) {
            seatDTOS[seat.getRow_num() - 1][seat.getPlace_num() - 1] = getDTO(seat,session);
        }
        return seatDTOS;
    }

    public static SeatDTO getDTO(Seat seat, Session session) {
        SeatDTO seatDTO = new SeatDTO();
        seatDTO.seatId = seat.getSeatId();
        seatDTO.place_num = seat.getPlace_num();
        seatDTO.row_num = seat.getRow_num();
        seatDTO.isfree = session.getTickets().stream().filter(ticket -> (ticket.getSeat().getPlace_num() == seat.getPlace_num() && ticket.getSeat().getRow_num() == seat.getRow_num())).collect(Collectors.toList()).size() == 0;
        return seatDTO;
    }

    public Integer getPlace_num() {
        return place_num;
    }

    public void setPlace_num(Integer place_num) {
        this.place_num = place_num;
    }

    public Integer getRow_num() {
        return row_num;
    }

    public void setRow_num(Integer row_num) {
        this.row_num = row_num;
    }

    public boolean isIsfree() {
        return isfree;
    }

    public void setIsfree(boolean isfree) {
        this.isfree = isfree;
    }

    public Integer getSeatId() {
        return seatId;
    }

    public void setSeatId(Integer seatId) {
        this.seatId = seatId;
    }
}
