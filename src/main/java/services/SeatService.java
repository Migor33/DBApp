package services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repos.SeatRepository;

@Service
public class SeatService {

    @Autowired
    private SeatRepository seatRepository;
}
