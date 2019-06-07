package pl.czarek.carnet.data.entity;

import javax.persistence.*;

@Entity
@Table(name = "CAR_DEALER")
public class CarDealer {
    @Id
    @Column(name = "CAR_DEALER_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long carDealerId;
    @Column(name = "NAME_OF_FIRM")
    private String nameOfFirm;
    @Column(name = "ADDRESS_ID")
    private long addressId;
    @Column(name = "PHONE_NUMBER")
    private String phoneNumber;
    @Column(name = "OPEN_FROM")
    private String openFrom;
    @Column(name = "OPEN_TO")
    private String openTo;
    @Column(name = "CAR_DEALER_IMAGE")
    private String carDealerImage;

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

    public long getAddressId() {
        return addressId;
    }

    public void setAddressId(long addressId) {
        this.addressId = addressId;
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
}
