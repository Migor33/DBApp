package app.controllers;

import app.Main;
import app.dto.SeatDTO;
import app.entityes.Film;
import app.entityes.Session;
import app.entityes.Ticket;
import app.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.Comparator;
import java.util.Date;
import java.util.stream.Collectors;

@Controller
@CrossOrigin("localhost:8080")
public class AppController {
    @Autowired
    UserService userService;
    @Autowired
    FilmServices filmServices;
    @Autowired
    SessionService sessionService;
    @Autowired
    SeatService seatService;
    @Autowired
    TicketService ticketService;
    @Autowired
    HallService hallService;

    @GetMapping("/start")
    public   String startPage(Model model) {
        return "start";
    }

    @GetMapping("/login")
    public String login(@RequestParam String name,@RequestParam String password) {
        Main.user = userService.login(name,password);
        if (Main.user == null) {
            return "error";
        } else {
            return "workpage";
        }
    }

    @GetMapping("/workpage")
    public String workpgae() {
        if (Main.user == null) {
            return "error";
        } else {
            return "workpage";
        }
    }

    @GetMapping("/filmlist")
    public String filmList(ModelMap model) {
        if (Main.user != null) {
            model.put("films",filmServices.getAll());
            model.put("admin",Main.user.isAdmin());
            return "filmslist";
        } else {
            return "error";
        }
    }

    @GetMapping("/film")
    public String filmPage(@RequestParam Integer filmId , ModelMap model) {
        if (Main.user != null) {
            Film film = filmServices.getFilm(filmId);
            if (!Main.user.isAdmin()) {
                film.setSessions(film.getSessions().stream().filter(session -> session.getDate().after(new Date())).collect(Collectors.toList()));
            }
            film.getSessions().sort(new Comparator<Session>() {
                @Override
                public int compare(Session o1, Session o2) {
                    return o1.getDate().compareTo(o2.getDate());
                }
            });
            model.put("admin",Main.user.isAdmin());
            model.put("film",film);
            return "film";
        } else {
            return "error";
        }
    }

    @GetMapping("/ses")
    public String session(ModelMap model, @RequestParam Integer sessionId) {
        if (Main.user != null) {
            Session session = sessionService.getSession(sessionId);
            model.put("ses",session);
            SeatDTO[][] seatDTOS = SeatDTO.getDTOS(session);
            model.put("seatDTOS", seatDTOS);
            return "session";
        } else {
            return "error";
        }
    }

    @GetMapping("/makeTicket")
    public String makeTicket(ModelMap model,@RequestParam Integer sessionId,@RequestParam Integer seatId) {
        if (Main.user != null) {
            Session session = sessionService.getSession(sessionId);
            Ticket ticket = new Ticket();
            ticket.setSeat(seatService.getSeat(seatId));
            ticket.setSession(session);
            ticketService.addTicket(ticket);
            return "makeTicket";
        } else {
            return "error";
        }
    }

    @GetMapping("/makeFilm")
    public String makeFilm(ModelMap model, @RequestParam String name, @RequestParam String genre) {
        Film film = new Film();
        film.setName(name);
        film.setGenre(genre);
        filmServices.save(film);
        return "filmSaved";
    }

    @GetMapping("/makeSession")
    public String makeSeans(ModelMap model,@RequestParam Integer filmId,@RequestParam Date date,@RequestParam Integer hallId,@RequestParam Double price,@RequestParam Double VIPprice){
        Session session = new Session();
        session.setDate(date);
        session.setFilm(filmServices.getFilm(filmId));
        session.setHall(hallService.getHall(hallId));
        session.setPriceCommon(price);
        session.setPriceVIP(VIPprice);
        sessionService.saveSession(session);
        return "SessionSaved";
    }

    @GetMapping("/removeFilm")
    public String removeFilm(ModelMap model,@RequestParam Integer filmId) {
        Film film = filmServices.getFilm(filmId);
        for (Session s:
             film.getSessions()) {
            for (Ticket t:
                 s.getTickets()) {
                ticketService.remove(t);
            }
            sessionService.remove(s);
        }
        filmServices.remove(film);
        return "removeFilm";
    }

    @GetMapping("/removeSession")
    public String removeSes(ModelMap model, @RequestParam Integer sessionId) {
        Session s = sessionService.getSession(sessionId);
        for (Ticket t:
                s.getTickets()) {
            ticketService.remove(t);
        }
        sessionService.remove(s);
        return "removeSession";
    }
}
