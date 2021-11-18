package bgd.model.dao.implementation;

import bgd.model.dao.AbstractDAO;
import bgd.model.entity.Rating;
import bgd.model.entity.Trip;
import bgd.persistant.ConnectionManager;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RatingDAO implements AbstractDAO<Rating> {
    private static final String GET_ALL = "SELECT * FROM student_project.trip_item_rating";
    private static final String GET_BY_ID = "SELECT * FROM student_project.trip_item_rating WHERE id_trip_item_rating=?";
    private static final String CREATE = "INSERT student_project.trip_item_rating" +
            "(`stars_for_placement`, `stars_for_prices`, `stars_in_general`, `id_item`) VALUES (?, ?, ?, ?)";
    private static final String UPDATE = "UPDATE student_project.trip_item_rating " +
            "SET stars_for_placement=?, stars_for_prices=?, stars_in_general=?, id_item=? WHERE id_trip_item_rating=?";
    private static final String DELETE = "DELETE FROM student_project.trip_item_rating WHERE id_trip_item_rating=?";

    @Override
    public List<Rating> findAll() throws SQLException {
        List<Rating> ratings = new ArrayList<>();
        try(PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(GET_ALL)) {
            System.out.println(statement);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Rating rating = new Rating(
                        resultSet.getInt("id_trip_item_rating"),
                        resultSet.getInt("stars_for_placement"),
                        resultSet.getInt("stars_for_prices"),
                        resultSet.getInt("stars_in_general"),
                        resultSet.getInt("id_item")
                );
                ratings.add(rating);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ratings;
    }

    @Override
    public Rating findById(Integer id) throws SQLException {
        Rating rating = null;
        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(GET_BY_ID)) {
            statement.setInt(1, id);
            System.out.println(statement);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                rating = new Rating(
                        resultSet.getInt("id_trip_item_rating"),
                        resultSet.getInt("stars_for_placement"),
                        resultSet.getInt("stars_for_prices"),
                        resultSet.getInt("stars_in_general"),
                        resultSet.getInt("id_item")
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rating;
    }

    @Override
    public void create(Rating rating) throws SQLException {
        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(CREATE)) {
            statement.setString(1, String.valueOf(rating.getStarsForPlacement()));
            statement.setString(2, String.valueOf(rating.getStarsForPrices()));
            statement.setString(3, String.valueOf(rating.getStarsInGeneral()));
            statement.setString(4, String.valueOf(rating.getItemID()));
            statement.executeUpdate();
            System.out.println(statement);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Integer id, Rating rating) throws SQLException {
        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(UPDATE)) {
            statement.setInt(1, rating.getStarsForPlacement());
            statement.setInt(2, rating.getStarsForPrices());
            statement.setInt(3, rating.getStarsInGeneral());
            statement.setInt(4, rating.getItemID());
            statement.setInt(5, rating.getId());
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
