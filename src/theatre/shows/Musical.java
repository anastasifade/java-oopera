package theatre.shows;

import theatre.people.Actor;
import theatre.people.Director;
import theatre.people.Person;

import java.util.List;
import java.util.Objects;

public class Musical extends Show {

    private final Person composer;
    private final String libretto;

    public Musical(String title, int duration, Director director,
                   List<Actor> actors, Person composer, String libretto) {

        super(title, duration, director, actors);
        this.composer = composer;
        this.libretto = libretto;

    }

    public String getLibretto() {
        return libretto;
    }

    @Override
    public String toString() {
        return (" '" + getTitle() + "'.\nДлительность: " + getDuration() + " мин. "
                + "Режиссер: " + getDirector().getLastName()
                + ". Композитор: " + composer.getLastName() + ".\nЛибретто: " + getLibretto() + ".\n" + printActors());
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Musical musical = (Musical) obj;
        if (!super.equals(musical)) return false;
        return Objects.equals(composer, musical.composer) && Objects.equals(libretto, musical.libretto);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), composer, libretto);
    }
}
