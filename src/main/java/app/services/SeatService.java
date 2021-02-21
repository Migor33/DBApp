package app.services;

import app.entityes.Seat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Service;
import app.repos.SeatRepository;

@Service
@Configurable
public class SeatService {

    @Autowired
    private SeatRepository seatRepository;

    public Seat getSeat(Integer seatId) {
        return seatRepository.findById(seatId).get();
    }

}
