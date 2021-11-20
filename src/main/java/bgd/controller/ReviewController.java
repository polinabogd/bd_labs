package bgd.controller;

import bgd.domain.Review;
import bgd.dto.ReviewDTO;
import bgd.mapper.AbstractMapper;
import bgd.mapper.ReviewMapper;
import bgd.service.AbstractService;
import bgd.service.ReviewService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping(value = "/reviews")
@RestController
@AllArgsConstructor
public class ReviewController extends AbstractController<Review, ReviewDTO, Integer> {
    private final ReviewService reviewService;
    private final ReviewMapper reviewMapper;


    @Override
    protected AbstractService<Review, Integer> getService() {
        return reviewService;
    }

    @Override
    protected AbstractMapper<Review, ReviewDTO> getMapper() {
        return reviewMapper;
    }
}
