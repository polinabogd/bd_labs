package bgd.domain;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name="trip_item_rating")
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

    public Rating() {
    }

    @Id
    @Column(name="id_trip_item_rating")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Basic
    @Column(name="stars_for_placement")
    public Integer getStarsForPlacement() {
        return starsForPlacement;
    }

    public void setStarsForPlacement(Integer starsForPlacement) {
        this.starsForPlacement = starsForPlacement;
    }

    @Basic
    @Column(name="stars_for_prices")
    public Integer getStarsForPrices() {
        return starsForPrices;
    }

    public void setStarsForPrices(Integer starsForPrices) {
        this.starsForPrices = starsForPrices;
    }

    @Basic
    @Column(name="stars_in_general")
    public Integer getStarsInGeneral() {
        return starsInGeneral;
    }

    public void setStarsInGeneral(Integer starsInGeneral) {
        this.starsInGeneral = starsInGeneral;
    }

    @Basic
    @Column(name="id_item")
    public Integer getItemID() {
        return itemID;
    }

    public void setItemID(Integer itemID) {
        this.itemID = itemID;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Rating rating = (Rating) o;
        return id.equals(rating.id) && Objects.equals(starsForPlacement, rating.starsForPlacement) && Objects.equals(starsForPrices, rating.starsForPrices) && Objects.equals(starsInGeneral, rating.starsInGeneral) && itemID.equals(rating.itemID);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, starsForPlacement, starsForPrices, starsInGeneral, itemID);
    }

    @Override
    public String toString() {
        return "Rating{" +
                "id=" + id +
                ", starsForPlacement=" + starsForPlacement +
                ", starsForPrices=" + starsForPrices +
                ", starsInGeneral=" + starsInGeneral +
                ", itemID=" + itemID +
                '}';
    }
}
