package bgd.model.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Review {
    private Integer id;
    private String  comment;
    private Integer itemID;
    private Integer userID;

    public Review(Integer id, String comment, Integer itemID,
                  Integer userID) {
        this.id = id;
        this.comment = comment;
        this.itemID = itemID;
        this.userID = userID;
    }

    public Review(String comment, Integer itemID, Integer userID) {
        this(null, comment, itemID, userID);
    }

    @Override
    public String toString() {
        return "\nReview: id: " + id + " comment: " + comment +
                ", itemID: " + itemID + ", userID: " + userID;
    }
}
