package bgd.controller.implementations;

import bgd.controller.AbstractController;
import bgd.model.entity.Rating;
import bgd.service.implementations.RatingService;

import java.sql.SQLException;
import java.util.List;

public class RatingController implements AbstractController<Rating> {
    RatingService service = new RatingService();

    @Override
    public List<Rating> findAll() throws SQLException {
        return service.findAll();
    }

    @Override
    public void create(Rating entity) throws SQLException {
        service.create(entity);
    }

    @Override
    public Rating findById(Integer id) throws SQLException {
        return service.findById(id);
    }

    @Override
    public void update(Integer id, Rating entity) throws SQLException {
        service.update(id, entity);
    }

    @Override
    public void delete(String login) throws SQLException {
        service.delete(login);
    }
}
