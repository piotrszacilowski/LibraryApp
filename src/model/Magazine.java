package model;

public class Magazine extends Publication {
    private int month;
    private int day;
    private String language;

    public Magazine(String title, int year, String publisher, int month, int day, String language) {
        super(title, year, publisher);
        this.month = month;
        this.day = day;
        this.language = language;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public void printInfo() {
        String info = getTitle() + "; " + getPublisher() + "; " + getYear() + " - " + month + " - " + day + " " + language;
        System.out.println(info);
    }
}
