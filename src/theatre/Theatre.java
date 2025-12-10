package theatre;

import theatre.people.*;
import theatre.shows.*;

import java.util.ArrayList;

public class Theatre {

    // в методе main представлено пошаговое выполнение ТЗ
    public static void main(String[] args) {

        // создание афишы театра
        TheatreProgram theatre = new TheatreProgram();

        // шаг 1 - создать трёх актеров и двух режиссёров, а также одного автора музыки и одного хореографа
        createPeople(theatre);

        // шаг 2 - создать три спектакля: обычный, оперный и балет
        // шаг 3 - распределите актеров по спектаклям
        createShows(theatre);

        // шаг 4 - вывести на экран список актеров для каждого спектакля
        theatre.printShows();

        // шаг 5 - заменить актёра в одном из спектаклей на актёра из другого спектакля,
        //         ещё раз выведите для него список актёров.
        Show show = theatre.getShow(ShowType.BALLET, "Лебединое озеро");
        replaceActor(theatre, show, "Уотсон", "Рэдклифф");
        System.out.println(show);
        System.out.println();

        // шаг 6 - попробовать заменить несуществующего актера
        replaceActor(theatre, show, "Рэдклифф", "Кларк");
        System.out.println(show);
        System.out.println();
    }

    private static void createPeople(TheatreProgram theatre) {
        theatre.addPerson(Job.ACTOR, new Actor("Эмма", "Уотсон", Gender.FEMALE, 165));
        theatre.addPerson(Job.ACTOR, new Actor("Дэниел", "Рэдклифф", Gender.MALE, 165));
        theatre.addPerson(Job.ACTOR, new Actor("Руперт", "Гринт", Gender.MALE, 173));

        theatre.addPerson(Job.DIRECTOR, new Director("Крис", "Коламбус", Gender.MALE, 2));
        theatre.addPerson(Job.DIRECTOR, new Director("Дэвид", "Йейтс", Gender.MALE, 1));

        theatre.addPerson(Job.COMPOSER, new Person("Джон", "Уильямс", Gender.MALE));

        theatre.addPerson(Job.CHOREOGRAPHER, new Person("Пол", "Харрис", Gender.MALE));
    }

    private static void createShows(TheatreProgram theatre) {
        Show classical = new Show("Гамлет", 120,
                (Director) theatre.getPerson(Job.DIRECTOR, "Коламбус"), new ArrayList<>());

        classical.addActor((Actor) theatre.getPerson(Job.ACTOR, "Уотсон"));
        classical.addActor((Actor) theatre.getPerson(Job.ACTOR, "Рэдклифф"));

        String balletLibretto = "[Много текста]";
        Ballet ballet = new Ballet("Лебединое озеро", 180,
                (Director) theatre.getPerson(Job.DIRECTOR, "Йейтс"), new ArrayList<>(),
                theatre.getPerson(Job.COMPOSER, "Уильямс"), balletLibretto,
                theatre.getPerson(Job.CHOREOGRAPHER, "Харрис"));

        ballet.addActor((Actor) theatre.getPerson(Job.ACTOR, "Рэдклифф"));
        ballet.addActor((Actor) theatre.getPerson(Job.ACTOR, "Гринт"));

        String operaLibretto = "[Много другого текста]";
        Opera opera = new Opera("Кармен", 105,
                (Director) theatre.getPerson(Job.DIRECTOR, "Коламбус"), new ArrayList<>(),
                theatre.getPerson(Job.COMPOSER, "Уильямс"), operaLibretto, 4);
        opera.addActor((Actor) theatre.getPerson(Job.ACTOR, "Уотсон"));
        opera.addActor((Actor) theatre.getPerson(Job.ACTOR, "Гринт"));

        theatre.addShow(ShowType.CLASSICAL, classical);
        theatre.addShow(ShowType.BALLET, ballet);
        theatre.addShow(ShowType.OPERA, opera);

        System.out.println();
    }

    private static void replaceActor(TheatreProgram theatre, Show show,
                                     String replacingActor, String actorToReplace){
        show.replaceActor((Actor) theatre.getPerson(Job.ACTOR,replacingActor), actorToReplace);
    }
}
