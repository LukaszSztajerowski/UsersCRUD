package UserDAO;

import org.mindrot.jbcrypt.BCrypt;

import java.sql.*;
import java.util.Arrays;
import java.util.Scanner;


public class UserDAO {

    public static final String CREATE_USER_QUERY ="INSERT INTO users(username, email, password) VALUES (?, ?, ?)";
    public static final String READ_ONE_ROW = "Select * from users where id = ?";
    public static final String UPDATE_ROW = "Update users set email = ?, username = ?, password = ? where id = ?";
    public static final String DELETE = "delete from users where id = ?";
    public static final String FIND_ALL = "select * from users";

    public static String hashPassword(String password) {
        return BCrypt.hashpw(password, BCrypt.gensalt());
    }

    public User create(User user) {
        try (Connection conn = DbUtil.getConnection()) {
            PreparedStatement statement =
                    conn.prepareStatement(CREATE_USER_QUERY, Statement.RETURN_GENERATED_KEYS);
            statement.setString(1, user.getUserName());
            statement.setString(2, user.getEmail());
            statement.setString(3, hashPassword(user.getPassword()));
            statement.executeUpdate();
            //Pobieramy wstawiony do bazy identyfikator, a następnie ustawiamy id obiektu user.
            ResultSet resultSet = statement.getGeneratedKeys();
            if (resultSet.next()) {
                user.setId(resultSet.getInt(1));
            }
            return user;
        } catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    public User read (int userId){
        try(Connection conn = DbUtil.getConnection()){
            PreparedStatement preparedStatement = conn.prepareStatement(READ_ONE_ROW);
            preparedStatement.setInt(1, userId);
            preparedStatement.executeQuery();
            ResultSet resultSet = preparedStatement.getResultSet();
            User user = new User();
            if (resultSet.next()){
                user.setId(resultSet.getInt("id"));
                user.setUserName(resultSet.getString("username"));
                user.setEmail(resultSet.getString("email"));
                user.setPassword(hashPassword(resultSet.getString("password")));
                return user;
            }else return user;

        }catch(SQLException e){
            e.printStackTrace();
            return null;
        }
    }

    public void update(User user){
        try (Connection conn = DbUtil.getConnection()){
            PreparedStatement statement = conn.prepareStatement(UPDATE_ROW);
            statement.setString(1, user.getUserName());
            statement.setString(2, user.getEmail());
            statement.setString(3, this.hashPassword(user.getPassword()));
            statement.setInt(4, user.getId());
            statement.executeUpdate();
        }catch(SQLException e){
            e.printStackTrace();
        }
    }

    public void delete(int userId){
        try(Connection conn = DbUtil.getConnection()){
            PreparedStatement preparedStatement = conn.prepareStatement(DELETE);
            preparedStatement.setInt(1,userId);
            preparedStatement.executeUpdate();
        }catch (SQLException e){
            e.printStackTrace();
        }
    }

    public User[] findAll() {

        User[] users = new User[0];
        try (Connection conn = DbUtil.getConnection()) {
            PreparedStatement preparedStatement = conn.prepareStatement(FIND_ALL);
            preparedStatement.executeQuery();
            ResultSet resultSet = preparedStatement.getResultSet();
            users = new User[0];
            while (resultSet.next()) {
                User user = new User();
                user.setId(resultSet.getInt("id"));
                user.setUserName(resultSet.getString("username"));
                user.setEmail(resultSet.getString("email"));
                user.setPassword(resultSet.getString("password"));
                users = addToArray(user, users);
            }
            return users;


        } catch (SQLException e) {
            e.printStackTrace();
            return users;
        }
    }

    private User[] addToArray(User u, User[] users) {
        User[] tmpUsers = Arrays.copyOf(users, users.length + 1); // Tworzymy kopię tablicy powiększoną o 1.
        tmpUsers[users.length] = u; // Dodajemy obiekt na ostatniej pozycji.
        return tmpUsers;
    }
}
