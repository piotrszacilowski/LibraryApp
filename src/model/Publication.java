package model;

import java.util.Objects;

public abstract class Publication {

    private String title;
    private int year;
    private String publisher;

    public Publication(String title, int year, String publisher) {
        this.title = title;
        this.year = year;
        this.publisher = publisher;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getPublisher() {
        return publisher;
    }

    public void setPublisher(String publisher) {
        this.publisher = publisher;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Publication that = (Publication) o;
        return year == that.year &&
                Objects.equals(title, that.title) &&
                Objects.equals(publisher, that.publisher);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, year, publisher);
    }

    @Override
    public String toString() {
        return title + "; " + year + "; " + publisher;
    }
}
