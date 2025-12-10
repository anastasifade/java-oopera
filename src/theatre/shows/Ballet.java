package theatre.shows;

import theatre.people.Actor;
import theatre.people.Director;
import theatre.people.Person;

import java.util.List;
import java.util.Objects;

public class Ballet extends Musical {

    private final Person choreographer;

    public Ballet(String title, int duration, Director director,
                  List<Actor> actors, Person composer, String libretto, Person choreographer) {

        super(title, duration, director, actors, composer, libretto);
        this.choreographer = choreographer;

    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Ballet ballet = (Ballet) obj;
        if (!super.equals(ballet)) return false;
        return Objects.equals(choreographer, ballet.choreographer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), choreographer);
    }
}
