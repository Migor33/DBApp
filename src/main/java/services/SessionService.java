package services;

import entityes.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repos.SessionRepository;

import java.util.Date;
import java.util.List;

@Service
public class SessionService {

    @Autowired
    private SessionRepository sessionRepository;


    public List<Session> getAllAfterDate(Date date) {
        return sessionRepository.getAllAfterDate(date);
    }
}
