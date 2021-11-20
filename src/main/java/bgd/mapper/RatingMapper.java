package bgd.mapper;

import bgd.domain.Rating;
import bgd.dto.RatingDTO;
import org.springframework.stereotype.Component;

@Component
public class RatingMapper extends AbstractMapper<Rating, RatingDTO>{
    @Override
    public RatingDTO mapObjectToDto(Rating rating) {
        if (rating == null) return null;

        RatingDTO.RatingDTOBuilder ratingDtoBuilder = RatingDTO.builder();
        ratingDtoBuilder.id(rating.getId());
        ratingDtoBuilder.starsForPlacement(rating.getStarsForPlacement());
        ratingDtoBuilder.starsForPrices(rating.getStarsForPrices());
        ratingDtoBuilder.starsInGeneral(rating.getStarsInGeneral());
        ratingDtoBuilder.itemID(rating.getItemID());

        return ratingDtoBuilder.build();
    }
}