package pl.czarek.carnet.business.domain;

public class CarDealerGet {
    private long carDealerId;
    private String nameOfFirm;
    private String phoneNumber;
    private String openFrom;
    private String openTo;
    private String carDealerImage;
    private long addressId;
    private String street;
    private String numberHome;
    private String postCode;
    private String city;
    private String country;

    public long getCarDealerId() {
        return carDealerId;
    }

    public void setCarDealerId(long carDealerId) {
        this.carDealerId = carDealerId;
    }

    public String getNameOfFirm() {
        return nameOfFirm;
    }

    public void setNameOfFirm(String nameOfFirm) {
        this.nameOfFirm = nameOfFirm;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getOpenFrom() {
        return openFrom;
    }

    public void setOpenFrom(String openFrom) {
        this.openFrom = openFrom;
    }

    public String getOpenTo() {
        return openTo;
    }

    public void setOpenTo(String openTo) {
        this.openTo = openTo;
    }

    public String getCarDealerImage() {
        return carDealerImage;
    }

    public void setCarDealerImage(String carDealerImage) {
        this.carDealerImage = carDealerImage;
    }

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
