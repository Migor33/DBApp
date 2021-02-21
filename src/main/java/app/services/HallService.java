package app.services;

import app.entityes.Hall;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Service;
import app.repos.HallRepository;

@Service
@Configurable
public class HallService {

    @Autowired
    private HallRepository hallRepository;

    public Hall getHall(Integer id) {
        return hallRepository.findById(id).get();
    }
}


