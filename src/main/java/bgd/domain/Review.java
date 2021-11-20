package bgd.domain;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name="trip_item_review")
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

    public Review() {
    }

    @Id
    @Column(name="id_item_review")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Basic
    @Column(name="review_text")
    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    @Basic
    @Column(name="id_item")
    public Integer getItemID() {
        return itemID;
    }

    public void setItemID(Integer itemID) {
        this.itemID = itemID;
    }

    @Basic
    @Column(name="user_id")
    public Integer getUserID() {
        return userID;
    }

    public void setUserID(Integer userID) {
        this.userID = userID;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Review review = (Review) o;
        return id.equals(review.id) && Objects.equals(comment, review.comment) && itemID.equals(review.itemID) && userID.equals(review.userID);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, comment, itemID, userID);
    }

    @Override
    public String toString() {
        return "Review{" +
                "id=" + id +
                ", comment='" + comment + '\'' +
                ", itemID=" + itemID +
                ", userID=" + userID +
                '}';
    }
}
