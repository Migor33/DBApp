package services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import repos.SessionRepository;

@Service
public class SessionService {

    @Autowired
    private SessionRepository sessionRepository;
}
