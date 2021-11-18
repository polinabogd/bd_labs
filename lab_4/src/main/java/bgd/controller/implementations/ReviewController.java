package bgd.controller.implementations;

import bgd.controller.AbstractController;
import bgd.model.entity.Review;
import bgd.service.implementations.ReviewService;

import java.sql.SQLException;
import java.util.List;

public class ReviewController implements AbstractController<Review> {
    ReviewService service = new ReviewService();

    @Override
    public List<Review> findAll() throws SQLException {
        return service.findAll();
    }

    @Override
    public void create(Review entity) throws SQLException {
        service.create(entity);
    }

    @Override
    public Review findById(Integer id) throws SQLException {
        return service.findById(id);
    }

    @Override
    public void update(Integer id, Review entity) throws SQLException {
        service.update(id, entity);
    }

    @Override
    public void delete(Integer id) throws SQLException {
        service.delete(id);
    }
}
