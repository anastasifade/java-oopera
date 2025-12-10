package theatre.shows;

import theatre.people.Actor;
import theatre.people.Director;
import theatre.people.Person;

import java.util.List;
import java.util.Objects;

public class Opera extends Musical {

    private final int choirSize;

    public Opera(String title, int duration, Director director,
                  List<Actor> actors, Person composer, String libretto, int choirSize) {

        super(title, duration, director, actors, composer, libretto);
        this.choirSize = choirSize;

    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Opera opera = (Opera) obj;
        if (!super.equals(opera)) return false;
        return choirSize == opera.choirSize;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), choirSize);
    }
}
