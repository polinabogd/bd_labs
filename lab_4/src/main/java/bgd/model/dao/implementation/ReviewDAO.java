package bgd.model.dao.implementation;

import bgd.model.dao.AbstractDAO;
import bgd.model.entity.Review;
import bgd.persistant.ConnectionManager;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ReviewDAO implements AbstractDAO<Review> {
    private static final String GET_ALL = "SELECT * FROM student_project.trip_item_review";
    private static final String GET_BY_ID = "SELECT * FROM student_project.trip_item_review WHERE id=?";
    private static final String CREATE = "INSERT student_project.trip_item_review" +
            "(`comment`, `itemID`, `userID`) VALUES (?, ?, ?)";
    private static final String UPDATE = "UPDATE student_project.trip_item_review" +
            "SET comment=?, itemID=?, userID=?" + " WHERE id=?";
    private static final String DELETE = "DELETE FROM student_project.trip_item_review WHERE id=?";

    @Override
    public List<Review> findAll() throws SQLException {
        List<Review> reviews = new ArrayList<>();
        try(PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(GET_ALL)) {
            System.out.println(statement);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Review review = new Review(
                        resultSet.getInt("id_item_review"),
                        resultSet.getString("review_text"),
                        resultSet.getInt("id_item"),
                        resultSet.getInt("user_id")
                );
                reviews.add(review);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return reviews;
    }

    @Override
    public Review findById(Integer id) throws SQLException {
        Review review = null;
        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(GET_BY_ID)) {
            statement.setInt(1, id);
            System.out.println(statement);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                review = new Review(
                        resultSet.getInt("id"),
                        resultSet.getString("comment"),
                        resultSet.getInt("itemID"),
                        resultSet.getInt("userID")
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return review;
    }

    @Override
    public void create(Review review) throws SQLException {
        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(CREATE)) {
            statement.setString(1, String.valueOf(review.getComment()));
            statement.setString(2, String.valueOf(review.getItemID()));
            statement.setString(3, String.valueOf(review.getUserID()));
            statement.executeUpdate();
            System.out.println(statement);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Integer id, Review review) throws SQLException {
        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(UPDATE)) {
            statement.setString(1, String.valueOf(review.getComment()));
            statement.setString(2, String.valueOf(review.getItemID()));
            statement.setString(3, String.valueOf(review.getUserID()));
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
