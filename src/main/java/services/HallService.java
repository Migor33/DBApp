package services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repos.HallRepository;

@Service
public class HallService {

    @Autowired
    private HallRepository hallRepository;

}


