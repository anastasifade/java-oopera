package theatre.shows;

public enum ShowType {
    CLASSICAL("Спекталь"),
    BALLET("Балет"),
    OPERA("Опера");

    private final String type;

    ShowType(String type) {
        this.type = type;
    }

    public String getType() {
        return this.type;
    }
}
