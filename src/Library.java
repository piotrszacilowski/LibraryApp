public class Library {
    public static void main(String[] args) {
        final String appName = "Biblioteka v0.3";

        Book book1 = new Book("W pustyni i w puszczy","Henryk Sienkiewicz",2010,296,"Greg","9788373271890");

        System.out.println(appName);
        System.out.println("Książki dostępne w bibliotece:");
        book1.printInfo();
    }
}
