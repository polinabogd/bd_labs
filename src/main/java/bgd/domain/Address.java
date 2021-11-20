package bgd.domain;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name="item_adress")
public class Address {
    private Integer id;
    private String country;
    private String region;
    private String settlement;
    private String street;
    private Integer house;

    public Address(String country, String region, String settlement, String street, Integer house) {
        this(null, country, region, settlement, street, house);
    }

    @Id
    @Column(name="id_adress")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Basic
    @Column(name="country")
    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    @Basic
    @Column(name="region")
    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    @Basic
    @Column(name="settlement")
    public String getSettlement() {
        return settlement;
    }

    public void setSettlement(String settlement) {
        this.settlement = settlement;
    }

    @Basic
    @Column(name="street")
    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    @Basic
    @Column(name="house")
    public Integer getHouse() {
        return house;
    }

    public void setHouse(Integer house) {
        this.house = house;
    }

    public Address() {
    }

    public Address(Integer id, String country, String region,
                   String settlement, String street, Integer house) {
        this.id = id;
        this.country = country;
        this.region = region;
        this.settlement = settlement;
        this.street = street;
        this.house = house;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Address address = (Address) o;
        return id.equals(address.id) && country.equals(address.country) && region.equals(address.region) && settlement.equals(address.settlement) && street.equals(address.street) && house.equals(address.house);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, country, region, settlement, street, house);
    }

    @Override
    public String toString() {
        return "Address{" +
                "id=" + id +
                ", country='" + country + '\'' +
                ", region='" + region + '\'' +
                ", settlement='" + settlement + '\'' +
                ", street='" + street + '\'' +
                ", house=" + house +
                '}';
    }
}
