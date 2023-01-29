import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws SQLException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        BookDao bookDao = new BookDao(ConnectionUtils.openConnection());

        System.out.println("*********** Insert book ***********");
        Book  newBook = new Book("Одного разу в Голлівуді","Опис відсутній",145.00,"978-617-585-234-7",1);
        bookDao.insert(newBook);
        newBook = new Book("Мистецтво війни","Опис відсутній",160.00,"978-617-679-145-4",2);
        bookDao.insert(newBook);
        newBook = new Book("Ромео і Джульєтта","Опис відсутній",120.00,"978-089-0008-24-9",3);
        bookDao.insert(newBook);
        bookDao.readAll().forEach(System.out::println);
        System.out.println("************************************************\n");

        System.out.println("*********** Select all ***********");
        bookDao.readAll().forEach(System.out::println);
        System.out.println("************************************************\n");

        System.out.println("*********** Select by id ***********");
        System.out.println(bookDao.read(3));
        System.out.println("************************************************\n");

        System.out.println("*********** Select book, where price > ***********");
        bookDao.price(120).forEach(System.out::println);
        System.out.println("************************************************\n");

        System.out.println("*********** Update book ***********");
        bookDao.update(1," В Голлівуді" );
        bookDao.readAll().forEach(System.out::println);
        System.out.println("************************************************\n");

        System.out.println("*********** Delete book ***********");
        bookDao.delete(2);
        bookDao.readAll().forEach(System.out::println);
        System.out.println("************************************************\n");

        System.out.println("*********** Insert book ***********");
        newBook = new Book("Ромео і Джульєтта","Опис відсутній",120.00,"978-089-0008-24-9",2);
        bookDao.insert(newBook);
        bookDao.readAll().forEach(System.out::println);
        System.out.println("************************************************\n");
    }
}