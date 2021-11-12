package bgd.model.entity;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Address {
    private Integer id;
    private String country;
    private String region;
    private String settlement;
    private String street;
    private Integer house;

    public Address(Integer id, String country, String region,
                   String settlement, String street, Integer house) {
        this.id = id;
        this.country = country;
        this.region = region;
        this.settlement = settlement;
        this.street = street;
        this.house = house;
    }

    public Address(String country, String region, String settlement, String street, Integer house) {
    }

    @Override
    public String toString() {
        return "\nAddress: id: " + id + " country: " + country + ", region: " + region + ", settlement: " + settlement +
                ", street: " + street + " house: " + house;
    }
}
