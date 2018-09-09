package pl.czarek.carnet.business.domain;

public class SmallInfoCar {
    private long carId;
    private String make;
    private String model;
    private String yearOfProduction;
    private long price;
    private long carDealerId;
    private String carDealerName;

    public long getCarId() {
        return carId;
    }

    public void setCarId(long carId) {
        this.carId = carId;
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

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    public long getCarDealerId() {
        return carDealerId;
    }

    public void setCarDealerId(long carDealerId) {
        this.carDealerId = carDealerId;
    }

    public String getCarDealerName() {
        return carDealerName;
    }

    public void setCarDealerName(String carDealerName) {
        this.carDealerName = carDealerName;
    }
}
