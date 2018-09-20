package pl.czarek.carnet.business.domain;

import pl.czarek.carnet.data.entity.Fuel;

import javax.validation.constraints.*;

public class CarPost {
    @Min(value = 1, message = "Nie wybrano salonu")
    private long carDealerId;
    @NotNull
    @Size(min = 2, max = 20)
    private String make;
    @NotNull
    @Size(min = 2, max = 20)
    private String model;
    @NotNull
    @Max(value = 2018)
    @Min(value = 1900)
    private String yearOfProduction;
    @NotNull
    @Min(value = 0)
    private long used;
    @NotNull
    @Min(value = 0)
    private long price;
    private Fuel fuel;
    @NotNull
    @DecimalMin(value = "0.0")
    private float engine;
    private boolean airConditioning;
    private String carImage;

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

    public String getCarImage() {
        return carImage;
    }

    public void setCarImage(String carImage) {
        this.carImage = carImage;
    }
}
