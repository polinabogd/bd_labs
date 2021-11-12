package bgd.controller.implementations;

import bgd.controller.AbstractController;
import bgd.model.entity.Address;
import bgd.service.implementations.AddressService;


import java.sql.SQLException;
import java.util.List;

public class AddressController implements AbstractController<Address> {
    AddressService service = new AddressService();

    @Override
    public List<Address> findAll() throws SQLException {
        return service.findAll();
    }

    @Override
    public void create(Address entity) throws SQLException {
        service.create(entity);
    }

    @Override
    public Address findById(Integer id) throws SQLException {
        return service.findById(id);
    }

    @Override
    public void update(Integer id, Address entity) throws SQLException {
        service.update(id, entity);
    }

    @Override
    public void delete(String login) throws SQLException {
        service.delete(login);
    }
}
