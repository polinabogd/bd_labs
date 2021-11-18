package bgd.model.dao.implementation;

import bgd.model.dao.AbstractDAO;
import bgd.model.entity.User;
import bgd.persistant.ConnectionManager;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDAO implements AbstractDAO<User> {
    private static final String GET_ALL = "SELECT * FROM student_project.trip_advisor_user";
    private static final String GET_BY_ID = "SELECT * FROM student_project.trip_advisor_user WHERE id=?";
    private static final String CREATE = "INSERT student_project.trip_advisor_user" +
            "(`surname`, `name`, `email`, `security_login`) VALUES (?, ?, ?, ?)";
    private static final String UPDATE = "UPDATE student_project.trip_advisor_user " +
            "SET surname=?, name=?, email=?, security_login=? WHERE id=?";
    private static final String DELETE = "DELETE FROM student_project.trip_advisor_user WHERE id=?";

    @Override
    public List<User> findAll() throws SQLException {
        List<User> users = new ArrayList<>();
        try(PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(GET_ALL)) {
                System.out.println(statement);
                ResultSet resultSet = statement.executeQuery();
                while (resultSet.next()) {
                    User user = new User(
                            resultSet.getInt("id"),
                            resultSet.getString("surname"),
                            resultSet.getString("name"),
                            resultSet.getString("email"),
                            resultSet.getString("security_login")
                    );
                    users.add(user);
                }
        } catch (Exception e) {
                e.printStackTrace();
        }
        return users;
    }

    @Override
    public User findById(Integer id) throws SQLException {
        User user = null;
        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(GET_BY_ID)) {
            statement.setInt(1, id);
            System.out.println(statement);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                user = new User(
                        resultSet.getInt("id"),
                        resultSet.getString("surname"),
                        resultSet.getString("name"),
                        resultSet.getString("email"),
                        resultSet.getString("security_login")
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return user;
    }

        @Override
        public void create(User user) throws SQLException {
            try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(CREATE)) {
                statement.setString(1, String.valueOf(user.getSurname()));
                statement.setString(2, String.valueOf(user.getName()));
                statement.setString(3, String.valueOf(user.getEmail()));
                statement.setString(4, String.valueOf(user.getSecurityLogin()));
                statement.executeUpdate();
                System.out.println(statement);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        @Override
        public void update(Integer id, User user) throws SQLException {
            try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(UPDATE)) {
                statement.setString(1, user.getSurname());
                statement.setString(2, user.getName());
                statement.setString(3, user.getEmail());
                statement.setString(4, user.getSecurityLogin());
                statement.setInt(5, user.getId());
                statement.executeUpdate();
                System.out.println(statement);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        @Override
        public void delete(Integer id) throws SQLException {
            try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(DELETE)) {
                statement.setInt(1, id);
                System.out.println(statement);
                statement.executeUpdate();
            } catch (Exception e) {
                e.printStackTrace();
            }
    }

}
