package bgd.service.implementations;

import bgd.model.dao.implementation.TripDAO;
import bgd.model.entity.Trip;
import bgd.service.AbstractService;

import java.sql.SQLException;
import java.util.List;

public class TripService implements AbstractService<Trip> {
    private final TripDAO dao = new TripDAO();

    @Override
    public List<Trip> findAll() throws SQLException {
        return dao.findAll();
    }

    @Override
    public Trip findById(Integer id) throws SQLException {
        return dao.findById(id);
    }

    @Override
    public void create(Trip entity) throws SQLException {
        dao.create(entity);
    }

    @Override
    public void update(Integer id, Trip entity) throws SQLException {
        dao.update(id, entity);
    }

    @Override
    public void delete(Integer id) throws SQLException {
        dao.delete(id);
    }
}
