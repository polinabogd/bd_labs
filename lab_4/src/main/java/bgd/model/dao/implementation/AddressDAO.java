package bgd.model.dao.implementation;

import bgd.model.dao.AbstractDAO;
import bgd.model.entity.Address;
import bgd.persistant.ConnectionManager;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AddressDAO implements AbstractDAO<Address> {
    private static final String GET_ALL = "SELECT * FROM student_project.item_adress";
    private static final String GET_BY_ID = "SELECT * FROM student_project.item_adress WHERE id_adress=?";
    private static final String CREATE = "INSERT student_project.item_adress" +
            "(`country`, `region`, `settlement`, `street`, `house`) VALUES (?, ?, ?, ?, ?)";
    private static final String UPDATE = "UPDATE student_project.item_adress" +
            " SET country=?, region=?, settlement=?, street=?, house=? WHERE id_adress=?";
    private static final String DELETE = "DELETE FROM student_project.item_adress WHERE id_adress=?";

    @Override
    public List<Address> findAll() throws SQLException {
        List<Address> addresses = new ArrayList<>();
        try(PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(GET_ALL)) {
            System.out.println(statement);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                Address address = new Address(
                        resultSet.getInt("id_adress"),
                        resultSet.getString("country"),
                        resultSet.getString("region"),
                        resultSet.getString("settlement"),
                        resultSet.getString("street"),
                        resultSet.getInt("house")
                );
                addresses.add(address);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return addresses;
    }

    @Override
    public Address findById(Integer id) throws SQLException {
        Address address = null;
        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(GET_BY_ID)) {
            statement.setInt(1, id);
            System.out.println(statement);
            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                address = new Address(
                        resultSet.getInt("id_adress"),
                        resultSet.getString("country"),
                        resultSet.getString("region"),
                        resultSet.getString("settlement"),
                        resultSet.getString("street"),
                        resultSet.getInt("house")
                );
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return address;
    }

    @Override
    public void create(Address address) throws SQLException {
        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(CREATE)) {
            statement.setString(1, String.valueOf(address.getCountry()));
            statement.setString(2, String.valueOf(address.getRegion()));
            statement.setString(3, String.valueOf(address.getSettlement()));
            statement.setString(4, String.valueOf(address.getStreet()));
            statement.setString(5, String.valueOf(address.getHouse()));
            statement.executeUpdate();
            System.out.println(statement);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void update(Integer id, Address address) throws SQLException {
        try (PreparedStatement statement = ConnectionManager.getConnection().prepareStatement(UPDATE)) {
            statement.setString(1, address.getCountry());
            statement.setString(2, address.getRegion());
            statement.setString(3, address.getSettlement());
            statement.setString(4, address.getStreet());
            statement.setInt(5, address.getHouse());
            statement.setInt(6, address.getId());
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
