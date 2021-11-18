package bgd.model.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Rating {
    private Integer id;
    private Integer starsForPlacement;
    private Integer starsForPrices;
    private Integer starsInGeneral;
    private Integer itemID;

    public Rating(Integer id, Integer starsForPlacement, Integer starsForPrices,
                  Integer starsInGeneral, Integer itemID) {
        this.id = id;
        this.starsForPlacement = starsForPlacement;
        this.starsForPrices = starsForPrices;
        this.starsInGeneral = starsInGeneral;
        this.itemID = itemID;
    }

    public Rating(Integer starsForPlacement, Integer starsForPrices, Integer starsInGeneral, Integer itemID) {
        this(null, starsForPlacement, starsForPrices, starsInGeneral, itemID);
    }

    @Override
    public String toString() {
        return "\nRating: id: " + id + " starsForPlacement: " + starsForPlacement +
                ", starsForPrices: " + starsForPrices + ", starsInGeneral: " + starsInGeneral +
                ", itemID: " + itemID;
    }
}
