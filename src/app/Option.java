package app;

public enum Option {
    EXIT(1,"wyjście z programu"),
    ADD_BOOK(2,"dodanie nowej książki"),
    ADD_MAGAZINE(3,"dodanie nowego magazynu"),
    PRINT_BOOKS(4,"wyświetl dostępne książki"),
    PRINT_MAGAZINES(5,"wyświetl dostępne magazyny");

    private final int value;
    private final String description;

    Option(int value, String description) {
        this.value = value;
        this.description = description;
    }

    public int getValue() {
        return value;
    }

    public String getDescription() {
        return description;
    }

    @Override
    public String toString() {
        return value + " - " + description;
    }

    static Option createFromInt(int option) {
        return Option.values()[option];
    }
}
