package theatre.shows;

import theatre.people.Actor;
import theatre.people.Director;
import theatre.people.Gender;

import java.util.List;
import java.util.Objects;

public class Show {

    private final String title;
    private final int duration;
    private final Director director;
    private final List<Actor> actors;

    public Show (String title, int duration, Director director, List<Actor> actors) {
        this.title = title;
        this.duration = duration;
        this.director = director;
        this.actors = actors;
    }

    public void addActor(Actor actor) {
        String added = "добавлен";
        if (actor.getGender() == Gender.FEMALE) added += "а";

        if (actor == null) {
            System.out.println("Объект 'актер' не может быть пустым.");
            return;
        }
        if (actors.contains(actor)) {
            System.out.printf("Актер %s уже %s в список ранее.\n", actor.getFullName(), added);
            return;
        }
        actors.add(actor);
        System.out.printf("%s успешно %s в список.\n", actor.getFullName(), added);
    }

    // метод для замены актера, где
    //    replacement - новый актер
    //    replacedLastName - фамилия актера, которого требуется заменить
    public void replaceActor(Actor replacement, String replacedLastName) {

        if (replacement == null) {
            System.out.println("Такого актера не существует.");
            return;
        }

        if (actors.contains(replacement)) {
            System.out.printf("%s уже участвует в постановке и не может заменить другого актера.\n",
                    replacement);
            return;
        }

        Actor replacedActor = getActor(replacedLastName);

        if (replacedActor == null) {
            System.out.println("Актер, которого вы пытаетесь заменить, не участвует в постановке - замена невозможна.");
            return;
        }

        actors.set(actors.indexOf(replacedActor), replacement);
        System.out.println("Замена успешно произведена.");
    }

    public String printActors() {
        String output = "Список актеров:\n";
        int counter = 1;
        for (Actor actor : actors) {
            output += String.format("%d. %s\n", counter, actor);
            counter++;
        }
        return output;
    }

    public String getTitle() {
        return this.title;
    }

    public int getDuration() {
        return this.duration;
    }

    public Director getDirector() {
        return this.director;
    }

    @Override
    public String toString() {
        return (" '" + title + "'.\nДлительность: " + duration + " мин. " +
                "Режиссер: " + director.getLastName() + ".\n" + printActors());
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Show show = (Show) obj;
        return (duration == show.duration
                && Objects.equals(title, show.title)
                && Objects.equals(director, show.director)
                && Objects.equals(actors, show.actors));
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, duration, director, actors);
    }

    // метод для поиска актера по фамилии
    private Actor getActor(String lastName) {
        for (Actor actor : actors) {
            if (actor.getLastName().equals(lastName)) return actor;
        }
        return null;
    }
}
