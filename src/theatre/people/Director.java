package theatre.people;

import java.util.Objects;

public class Director extends Person {

    private final int showCount;

    public Director(String firstName, String lastName, Gender gender, int showCount) {
        super(firstName, lastName, gender);
        this.showCount = showCount;
    }

    @Override
    public String toString() {
        return super.toString() + ", количество поставленных спектаклей: " + showCount;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Director director = (Director) obj;
        if (!super.equals(director)) return false;
        return showCount == director.showCount;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), showCount);
    }
}
