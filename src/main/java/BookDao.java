import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class BookDao {
    private static String READ_ALL = "select * from books";
    private static String CREATE = "insert into books (name,description,price,ISBN,category_id) values (?,?,?,?,?)";
    private static String READ_BY_ID = "select * from books where id =?";
    private static String UPDATE_BY_ID = "update books set name=? where id = ?";
    private static String DELETE_BY_ID = "delete from books where id=?";
    private static String SELECT_PRICE = "select * from books where price > ?";

    private Connection connection;
    private PreparedStatement preparedStatement;

    public BookDao(Connection connection) {
        this.connection = connection;
    }

    public void insert(Book book) throws SQLException {
        preparedStatement = connection.prepareStatement(CREATE);
        preparedStatement.setString(1, book.getName());
        preparedStatement.setString(2, book.getDescription());
        preparedStatement.setDouble(3, book.getPrice());
        preparedStatement.setString(4, book.getISBN());
        preparedStatement.setInt(5, book.getCategory_id());
        preparedStatement.executeUpdate();
    }

    public Book read(int id) throws SQLException {
        preparedStatement = connection.prepareStatement(READ_BY_ID);
        preparedStatement.setInt(1, id);
        ResultSet result = preparedStatement.executeQuery();
        result.next();
        return BookMapper.map(result);
    }

    public void update(int id, String rename) throws SQLException {
        preparedStatement = connection.prepareStatement(UPDATE_BY_ID);
        preparedStatement.setString(1, rename);
        preparedStatement.setInt(2, id);
        preparedStatement.executeUpdate();
    }

    public void delete(int id) throws SQLException {
        preparedStatement = connection.prepareStatement(DELETE_BY_ID);
        preparedStatement.setInt(1, id);
        preparedStatement.executeUpdate();
    }

    public List<Book> price(int price) throws SQLException {
        List<Book> listOfBook = new ArrayList<>();
        preparedStatement = connection.prepareStatement(SELECT_PRICE);
        preparedStatement.setInt(1, price);
        ResultSet result = preparedStatement.executeQuery();
        while (result.next()) {
            listOfBook.add(BookMapper.map(result));
        }
        return listOfBook;
    }

    public  List<Book> readAll() throws SQLException {
        List<Book> listOfBook = new ArrayList<>();
        preparedStatement = connection.prepareStatement(READ_ALL);
        ResultSet result = preparedStatement.executeQuery();
        while (result.next()) {
            listOfBook.add(BookMapper.map(result));
        }
        return listOfBook;
    }
}
