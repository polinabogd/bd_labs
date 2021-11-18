package bgd.controller.implementations;

import bgd.controller.AbstractController;
import bgd.model.entity.Trip;
import bgd.service.implementations.TripService;

import java.sql.SQLException;
import java.util.List;

public class TripController implements AbstractController<Trip> {
    TripService service = new TripService();

    @Override
    public List<Trip> findAll() throws SQLException {
        return service.findAll();
    }

    @Override
    public void create(Trip entity) throws SQLException {
        service.create(entity);
    }

    @Override
    public Trip findById(Integer id) throws SQLException {
        return service.findById(id);
    }

    @Override
    public void update(Integer id, Trip entity) throws SQLException {
        service.update(id, entity);
    }

    @Override
    public void delete(Integer id) throws SQLException {
        service.delete(id);
    }
}
