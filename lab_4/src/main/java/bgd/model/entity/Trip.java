package bgd.model.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
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

    @Override
    public String toString() {
        return "\nTrip: id: " + id + " type: " + type +
                ", name: " + name + ", addressID: " + addressID;
    }
}
