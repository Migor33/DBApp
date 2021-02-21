package app.services;

import app.entityes.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.stereotype.Service;
import app.repos.SessionRepository;

import java.util.Date;
import java.util.List;

@Service
@Configurable
public class SessionService {

    @Autowired
    private SessionRepository sessionRepository;


    public List<Session> getAllAfterDate(Date date) {
        return sessionRepository.getAllAfterDate(date);
    }

    public Session getSession(Integer id) {
        return sessionRepository.findById(id).get();
    }

    public Session saveSession(Session session) {
        return sessionRepository.save(session);
    }

    public void remove(Session t) {
        sessionRepository.delete(t);
    }
}
