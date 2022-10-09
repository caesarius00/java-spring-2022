public class program {
    public static void main(String[] args) {
        Author aut = new Author("Adam Mickiewicz", "a.mickiewicz@gmail.c0m", Gender.MALE);

        System.out.println(aut.toString());


        aut.setEmail("a.mickiewicz@gmail.com");
        System.out.println(aut.getEmail());

        Book boo = new Book("Dziady", 21.99, aut);

        System.out.println(boo.toString());

    }
}
