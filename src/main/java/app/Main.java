package app;

import app.controllers.ApplicationContextHolder;
import app.entityes.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import app.services.FilmServices;
import app.services.SessionService;
import app.services.TicketService;
import org.springframework.stereotype.Controller;

import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

@SpringBootApplication
@Configurable
public class Main {

    public static User user;

    public static void main(String[] args) {
        SpringApplication.run(Main.class, args);
    }
}
