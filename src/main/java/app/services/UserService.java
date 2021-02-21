package app.services;

import app.entityes.User;
import app.repos.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    UserRepository userRepository;

    public User login(String name,String password) {
        return userRepository.findByNameAndPassword(name,password);
    }
}
