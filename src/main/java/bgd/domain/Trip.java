package bgd.domain;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "trip_item")
public class Trip {
    private Integer id;
    private String type;
    private String name;
    private Integer addressID;

    public Trip(Integer id, String type, String name,
                Integer addressID) {
        this.id = id;
        this.type = type;
        this.name = name;
        this.addressID = addressID;
    }

    public Trip(String type, String name, Integer addressID) {
        this(null, type, name, addressID);
    }

    public Trip() {
    }

    @Id
    @Column(name="id_item")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Basic
    @Column(name="item_category")
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Basic
    @Column(name = "name")
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name="id_adress")
    public Integer getAddressID() {
        return addressID;
    }

    public void setAddressID(Integer addressID) {
        this.addressID = addressID;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Trip trip = (Trip) o;
        return id.equals(trip.id) && type.equals(trip.type) && name.equals(trip.name) && addressID.equals(trip.addressID);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, type, name, addressID);
    }

    @Override
    public String toString() {
        return "Trip{" +
                "id=" + id +
                ", type='" + type + '\'' +
                ", name='" + name + '\'' +
                ", addressID=" + addressID +
                '}';
    }
}
