package theatre.people;

import java.util.Objects;

public class Actor extends Person {

    private final int height;
    private final String title;

    public Actor(String firstName, String lastName, Gender gender, int height) {
        super(firstName, lastName, gender);
        this.height = height;
        this.title = getTitle(gender);
    }

    @Override
    public String toString() {
        return this.title + " " + super.toString() + " (" + height + " см)";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Actor actor = (Actor) obj;
        if (!super.equals(actor)) return false;
        return height == actor.height;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), height);
    }

    private String getTitle(Gender gender){
        switch(gender){
            case MALE -> {
                return "Актер";
            }
            case FEMALE -> {
                return "Актриса";
            }
        }
        return null;
    }
}
