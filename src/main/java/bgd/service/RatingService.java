package bgd.service;

import bgd.domain.Rating;
import bgd.repository.RatingRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class RatingService extends AbstractService<Rating, Integer> {
    public RatingRepository ratingRepository;

    @Override
    protected JpaRepository<Rating, Integer> getRepository() {
        return ratingRepository;
    }
}