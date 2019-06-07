package pl.czarek.carnet.data.entity;

import javax.persistence.*;

@Entity
@Table(name = "ADDRESS")
public class Address {
    @Id
    @Column(name = "ADDRESS_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long addressId;
    @Column(name = "STREET")
    private String street;
    @Column(name = "NUMBER_HOME")
    private String numberHome;
    @Column(name = "POST_CODE")
    private String postCode;
    @Column(name = "CITY")
    private String city;
    @Column(name = "COUNTRY")
    private String country;

    public long getAddressId() {
        return addressId;
    }

    public void setAddressId(long addressId) {
        this.addressId = addressId;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getNumberHome() {
        return numberHome;
    }

    public void setNumberHome(String numberHome) {
        this.numberHome = numberHome;
    }

    public String getPostCode() {
        return postCode;
    }

    public void setPostCode(String postCode) {
        this.postCode = postCode;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
