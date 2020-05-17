package app;

import exception.NoSuchOptionException;
import io.ConsolePrinter;
import io.DataReader;
import model.Book;
import model.Library;
import model.Magazine;
import model.Publication;

import java.util.InputMismatchException;

public class LibraryControl {

    private ConsolePrinter printer = new ConsolePrinter();
    private DataReader dataReader = new DataReader(printer);
    private Library library = new Library();

    public void controlLoop() {
        Option option;

        do {
            printOptions();
            option = getOption();
            switch (option) {
                case ADD_BOOK:
                    addBook();
                    break;
                case ADD_MAGAZINE:
                    addMagazine();
                    break;
                case PRINT_BOOKS:
                    printBooks();
                    break;
                case PRINT_MAGAZINES:
                    printMagazine();
                    break;
                case EXIT:
                    exit();
                    break;
                default:
                    printer.printLine("Nie ma takiej opcji, wprowadź ponownie.");
            }
        } while (option != Option.EXIT);
    }

    private Option getOption() {
        boolean optionOk = false;
        Option option = null;
        while (!optionOk) {
            try {
                option = Option.createFromInt(dataReader.getInt());
                optionOk = true;
            } catch (NoSuchOptionException e) {
                printer.printLine(e.getMessage());
            } catch (InputMismatchException e) {
                printer.printLine("Wprowadzono złą wartość, spróbuj ponownie.");
            }
        }
        return option;
    }

    private void printMagazine() {
        Publication[] publications = library.getPublications();
        printer.printMagazine(publications);
    }

    private void addMagazine() {
        try {
            Magazine magazine = dataReader.readAndCreateMagazine();
            library.addMagazine(magazine);
        } catch (InputMismatchException e) {
            printer.printLine("Niepoprawny typ danych, spróbuj ponownie.");
        } catch (ArrayIndexOutOfBoundsException e) {
            printer.printLine("Osiągnięto limit pojemności bibioteki, nie można dodać kolejnego magazynu.");
        }
    }

    private void addBook() {
        try {
            Book book = dataReader.readAndCreateBook();
            library.addBook(book);
        } catch (InputMismatchException e) {
            printer.printLine("Niepoprawny typ danych, spróbuj ponownie.");
        } catch (ArrayIndexOutOfBoundsException e) {
            printer.printLine("Osiągnięto limit pojemności bibioteki, nie można dodać kolejnej książki.");
        }
    }

    private void printBooks() {
        Publication[] publications = library.getPublications();
        printer.printBooks(publications);
    }

    private void exit() {
        printer.printLine("Koniec programu!");
        dataReader.close();
    }

    private void printOptions() {
        printer.printLine("Wybierz opcję: ");
        for (Option option : Option.values()) {
            printer.printLine(option.toString());
        }
    }

    private enum Option {
        EXIT(0,"wyjście z programu"),
        ADD_BOOK(1,"dodanie nowej książki"),
        ADD_MAGAZINE(2,"dodanie nowego magazynu"),
        PRINT_BOOKS(3,"wyświetl dostępne książki"),
        PRINT_MAGAZINES(4,"wyświetl dostępne magazyny");

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

        static Option createFromInt(int option) throws NoSuchOptionException {
            try {
                return Option.values()[option];
            } catch (ArrayIndexOutOfBoundsException e) {
                throw new NoSuchOptionException("Brak opcji o id: " + option);
            }
        }
    }
}
