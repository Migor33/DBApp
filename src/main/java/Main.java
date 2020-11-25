import entityes.Film;
import entityes.Seat;
import entityes.Session;
import org.springframework.beans.factory.annotation.Autowired;
import services.FilmServices;

import java.util.List;
import java.util.Scanner;

public class Main {

    @Autowired
    private static FilmServices filmServices;


    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Добро пожаловать, чем могу помочь");
            System.out.println("Выберите действие");
            System.out.println("1 - просмотреть список вильмов");
            System.out.println("2 - просмотреть расписание сеансов");
            System.out.println("3 - выход");
            Integer t = scanner.nextInt()
            if (t == 1) {
                List<Film> films = filmServices.getAll();
                System.out.println("Выберите фильм");
                for (int i = 0; i < films.size(); i++) {
                    System.out.println((i+1) + ". " + films.get(i));
                }
                if (t > 0 && t <= films.size()) {
                    System.out.println("У фильма '"+films.get(t-1).getName() + "' имеются следующие сеансы");
                    List<Session> sessions = films.get(t-1).getSessions();
                    for (int i = 0; i < sessions.size(); i++) {
                        System.out.println((i+1) + ". " + sessions.get(i));
                    }
                    System.out.println("Выбирите сеанс");
                    t = scanner.nextInt();
                    if (t > 0 && t < sessions.size()) {
                        List<Seat> seats = sessions.get(t).getHall().getSeats();
                    }
                }

            } else if (t == 2) {

            } else {
                break;
            }
        }
    }
}
