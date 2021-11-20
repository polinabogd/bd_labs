package bgd.controller;

import bgd.domain.Rating;
import bgd.dto.RatingDTO;
import bgd.mapper.AbstractMapper;
import bgd.mapper.RatingMapper;
import bgd.service.AbstractService;
import bgd.service.RatingService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping(value = "/ratings")
@RestController
@AllArgsConstructor
public class RatingController extends AbstractController<Rating, RatingDTO, Integer> {
    private final RatingService ratingService;
    private final RatingMapper ratingMapper;

    @Override
    protected AbstractService<Rating, Integer> getService() {
        return ratingService;
    }

    @Override
    protected AbstractMapper<Rating, RatingDTO> getMapper() {
        return ratingMapper;
    }
}
