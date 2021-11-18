package bgd.service.implementations;

import bgd.model.dao.implementation.RatingDAO;
import bgd.model.entity.Rating;
import bgd.service.AbstractService;

import java.sql.SQLException;
import java.util.List;

public class RatingService implements AbstractService<Rating> {
    private final RatingDAO dao = new RatingDAO();

    @Override
    public List<Rating> findAll() throws SQLException {
        return dao.findAll();
    }

    @Override
    public Rating findById(Integer id) throws SQLException {
        return dao.findById(id);
    }

    @Override
    public void create(Rating entity) throws SQLException {
        dao.create(entity);
    }

    @Override
    public void update(Integer id, Rating entity) throws SQLException {
        dao.update(id, entity);
    }

    @Override
    public void delete(Integer id) throws SQLException {
        dao.delete(id);
    }
}
