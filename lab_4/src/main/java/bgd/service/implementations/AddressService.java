package bgd.service.implementations;

import bgd.model.dao.implementation.AddressDAO;
import bgd.model.entity.Address;
import bgd.service.AbstractService;

import java.sql.SQLException;
import java.util.List;

public class AddressService implements AbstractService<Address> {
    private final AddressDAO dao = new AddressDAO();

    @Override
    public List<Address> findAll() throws SQLException {
        return dao.findAll();
    }

    @Override
    public Address findById(Integer id) throws SQLException {
        return dao.findById(id);
    }

    @Override
    public void create(Address entity) throws SQLException {
        dao.create(entity);
    }

    @Override
    public void update(Integer id, Address entity) throws SQLException {
        dao.update(id, entity);
    }

    @Override
    public void delete(Integer id) throws SQLException {
        dao.delete(id);
    }
}