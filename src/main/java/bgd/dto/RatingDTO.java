package bgd.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RatingDTO {
    private Integer id;
    private Integer starsForPlacement;
    private Integer starsForPrices;
    private Integer starsInGeneral;
    private Integer itemID;
}
