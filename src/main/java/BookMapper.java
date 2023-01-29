import java.sql.ResultSet;
import java.sql.SQLException;

public class BookMapper {
    public static Book map(ResultSet result) throws SQLException {
        int id = result.getInt("id");
        String name = result.getString("name");
        String description = result.getString("description");
        double price = result.getDouble("price");
        String ISBN = result.getString("ISBN");
        int category_id = result.getInt("category_id");

        return new Book(id,name,description,price, ISBN, category_id);
    }
}
