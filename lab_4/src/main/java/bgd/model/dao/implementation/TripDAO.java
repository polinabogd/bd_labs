package bgd.model.dao.implementation;

import bgd.model.dao.AbstractDAO;
import bgd.model.entity.Address;
import bgd.model.entity.Trip;
import bgd.persistant.ConnectionManager;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TripDAO implements AbstractDAO<Trip> {
    private static final String GET_ALL = "SELECT * FROM student_project.trip_item";
    private static final String GET_BY_ID = "SELECT * FROM student_project.trip_item WHERE id=?";
    private static final String CREATE = "INSERT student_project.trip_item" +
            "(`type`, `name`, `addressID`) VALUES (?, ?, ?)";
    private static final String UPDATE = "UPDATE student_project.trip_item" +
            "SET type=?, name=?, addressID=?" + " WHERE id=?";
    private static final String DELETE = "DELETE FROM student_project.trip_item WHERE id=?";

    @Override
    public List<Trip> findAll() throws SQLException {
        List<Trip> trips = new ArrayList<>();
        try(PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(GET_ALL)) {
            System.out.println(statement);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Trip trip = new Trip(
                        resultSet.getInt("id_item"),
                        resultSet.getString("item_category"),
                        resultSet.getString("name"),
                        resultSet.getInt("id_adress")
                );
                trips.add(trip);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return trips;
    }

    @Override
    public Trip findById(Integer id) throws SQLException {
        Trip trip = null;
        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(GET_BY_ID)) {
            statement.setInt(1, id);
            System.out.println(statement);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                trip = new Trip(
                        resultSet.getInt("id"),
                        resultSet.getString("type"),
                        resultSet.getString("name"),
                        resultSet.getInt("addressID")
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return trip;
    }

    @Override
    public void create(Trip trip) throws SQLException {
        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(CREATE)) {
            statement.setString(1, String.valueOf(trip.getName()));
            statement.setString(2, String.valueOf(trip.getType()));
            statement.setString(3, String.valueOf(trip.getAddressID()));
            statement.executeUpdate();
            System.out.println(statement);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Integer id, Trip trip) throws SQLException {
        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(UPDATE)) {
            statement.setString(1, String.valueOf(trip.getName()));
            statement.setString(2, String.valueOf(trip.getType()));
            statement.setString(3, String.valueOf(trip.getAddressID()));
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
