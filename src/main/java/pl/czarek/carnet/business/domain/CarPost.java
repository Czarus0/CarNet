package pl.czarek.carnet.business.domain;

import pl.czarek.carnet.contraints.NotNone;

import javax.validation.constraints.*;

public class CarPost {
    @Min(value = 1, message = "Nie wybrano salonu")
    private long carDealerId;
    @Size(min = 2, max = 20, message = "Marka musi zawierać od 2 do 20 znaków")
    private String make;
    @Size(min = 2, max = 20, message = "Model musi zawierać od 2 do 20 znaków")
    private String model;
    @Max(value = 2018, message = "Nie można dać roku produkcji większego niż 2018")
    @Min(value = 1900, message = "Nie można dać roku produkcji mniejszego niż 1900")
    private String yearOfProduction;
    @Size(min = 1, max = 9, message = "Przebieg musi zawierać od 1 do 9 cyfr")
    private String used;
    @Size(min = 1, max = 9, message = "Cena musi zawierać od 1 do 9 cyfr")
    private String price;
    @NotNone(message = "Nie może zostać niewybrana wartość")
    private String fuel;
    @Pattern(regexp = "[0-9]+.[0-9]", message = "Wartość musi być np. 1.1")
    private String engine;
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

    public String getUsed() {
        return used;
    }

    public void setUsed(String used) {
        this.used = used;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getFuel() {
        return fuel;
    }

    public void setFuel(String fuel) {
        this.fuel = fuel;
    }

    public String getEngine() {
        return engine;
    }

    public void setEngine(String engine) {
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
