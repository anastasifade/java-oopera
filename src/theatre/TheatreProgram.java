// метод для хранения списка спекталей и списка лиц, задействованных в их постановке

package theatre;

import theatre.people.*;
import theatre.shows.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TheatreProgram {

    // список людей, задействованных в постановке спектаклей
    private final Map<Job, List<Person>> people;
    // список спектаклей по жанрам
    private final Map<ShowType, List<Show>> shows;

    public TheatreProgram() {
        people = new HashMap<>();
        shows = new HashMap<>();
    }

    public void addPerson(Job job, Person person) {
        if (job == null || person == null) {
            return;
        }

        if (people.containsKey(job)){
            if (people.get(job).contains(person)) {
                return;
            }
            people.get(job).add(person);
            return;
        }

        people.put(job, new ArrayList<>());
        people.get(job).add(person);
    }

    public void addShow(ShowType type, Show show) {
        if (type == null || show == null) {
            return;
        }

        if (shows.containsKey(type)) {
            if (shows.get(type).contains(show)) {
                return;
            }
            shows.get(type).add(show);
            return;
        }

        shows.put(type, new ArrayList<>());
        shows.get(type).add(show);
    }

    public Person getPerson(Job job, String lastName) {
        if (!people.containsKey(job)) {
            return null;
        }
        for (Person person : people.get(job)) {
            if (person.getLastName().equals(lastName)) {
                return person;
            }
        }
        return null;
    }

    public Show getShow(ShowType type, String title) {
        if (!shows.containsKey(type)) {
            return null;
        }
        for (Show show : shows.get(type)) {
            if (show.getTitle().equals(title)) {
                return show;
            }
        }
        return null;
    }

    // вывод на экран данных о спекталях и списка участвующих в нмх актеров
    public void printShows() {
        for (ShowType showType : shows.keySet()) {
            String type = showType.getType();
            for (Show show : shows.get(showType)) {
                System.out.println(type + " " + show);
                System.out.println();
            }
        }
    }

}
