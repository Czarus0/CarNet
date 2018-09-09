package pl.czarek.carnet.data.entity;

import javax.persistence.*;

@Entity
@Table(name = "CAR")
public class Car {
    @Id
    @Column(name = "CAR_ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long carId;
    @Column(name = "CAR_DEALER_ID")
    private long carDealerId;
    @Column(name = "MAKE")
    private String make;
    @Column(name = "MODEL")
    private String model;
    @Column(name = "YEAR_OF_PRODUCTION")
    private String yearOfProduction;
    @Column(name = "USED")
    private long used;
    @Column(name = "PRICE")
    private long price;
    @Column(name = "FUEL")
    private Fuel fuel;
    @Column(name = "ENGINE")
    private float engine;
    @Column(name = "AIR_CONDITIONING")
    private boolean airConditioning;
    @Column(name = "DATE_POSTED")
    private String datePosted;
    @Column(name = "DATE_SOLD")
    private String dateSold;
    @Column(name = "CAR_IMAGE")
    private String carImage;

    public long getCarId() {
        return carId;
    }

    public void setCarId(long carId) {
        this.carId = carId;
    }

    public long getCarDealerId() {
        return carDealerId;
    }

    public void setCarDealerId(long carDealerId) {
        this.carDealerId = carDealerId;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getYearOfProduction() {
        return yearOfProduction;
    }

    public void setYearOfProduction(String yearOfProduction) {
        this.yearOfProduction = yearOfProduction;
    }

    public long getUsed() {
        return used;
    }

    public void setUsed(long used) {
        this.used = used;
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    public Fuel getFuel() {
        return fuel;
    }

    public void setFuel(Fuel fuel) {
        this.fuel = fuel;
    }

    public float getEngine() {
        return engine;
    }

    public void setEngine(float engine) {
        this.engine = engine;
    }

    public boolean isAirConditioning() {
        return airConditioning;
    }

    public void setAirConditioning(boolean airConditioning) {
        this.airConditioning = airConditioning;
    }

    public String getDatePosted() {
        return datePosted;
    }

    public void setDatePosted(String datePosted) {
        this.datePosted = datePosted;
    }

    public String getDateSold() {
        return dateSold;
    }

    public void setDateSold(String dateSold) {
        this.dateSold = dateSold;
    }

    public String getCarImage() {
        return carImage;
    }

    public void setCarImage(String carImage) {
        this.carImage = carImage;
    }
}
