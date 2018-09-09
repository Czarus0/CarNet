package pl.czarek.carnet.business.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.czarek.carnet.business.domain.CarInCarDealer;
import pl.czarek.carnet.business.domain.SmallInfoCar;
import pl.czarek.carnet.data.entity.Car;
import pl.czarek.carnet.data.entity.CarDealer;
import pl.czarek.carnet.data.repository.CarDealerRepository;
import pl.czarek.carnet.data.repository.CarRepository;

import java.util.*;

@Service
public class CarService {
    private CarRepository carRepository;
    private CarDealerRepository carDealerRepository;

    @Autowired
    public CarService(CarRepository carRepository, CarDealerRepository carDealerRepository) {
        this.carRepository = carRepository;
        this.carDealerRepository = carDealerRepository;
    }

    public CarInCarDealer getDetailCarInformation(Long carId) {
        Car car = this.carRepository.findByCarId(carId);
        CarInCarDealer carInCarDealer = new CarInCarDealer();

        carInCarDealer.setCarId(car.getCarId());
        carInCarDealer.setMake(car.getMake());
        carInCarDealer.setModel(car.getModel());
        carInCarDealer.setYearOfProduction(car.getYearOfProduction());
        carInCarDealer.setUsed(car.getUsed());
        carInCarDealer.setPrice(car.getPrice());
        carInCarDealer.setFuel(car.getFuel());
        carInCarDealer.setEngine(car.getEngine());
        carInCarDealer.setAirConditioning(car.isAirConditioning());
        carInCarDealer.setDatePosted(car.getDatePosted());
        carInCarDealer.setDateSold(car.getDateSold());
        carInCarDealer.setCarImage(car.getCarImage());

        CarDealer carDealer = this.carDealerRepository.findByCarDealerId(car.getCarDealerId());
        if(carDealer != null) {
            carInCarDealer.setCarDealerId(car.getCarDealerId());
            carInCarDealer.setNameOfFirm(carDealer.getNameOfFirm());
            carInCarDealer.setPhoneNumber(carDealer.getPhoneNumber());
            carInCarDealer.setOpenFrom(carDealer.getOpenFrom());
            carInCarDealer.setOpenTo(carDealer.getOpenTo());
        }

        return carInCarDealer;
    }

    public List<SmallInfoCar> getSmallInfoCars(String make, String model) {
        List<SmallInfoCar> smallInfoCars = new ArrayList<>();

        if(make != null && model != null) {
            List<Car> cars = this.carRepository.findByMakeAndModel(make, model);
            cars.forEach(car -> {
                SmallInfoCar smallInfoCar = setAllDataSmallInfoCar(car);
                smallInfoCars.add(smallInfoCar);
            });
        } else if(make != null) {
            List<Car> cars = this.carRepository.findByMake(make);
            cars.forEach(car -> {
                SmallInfoCar smallInfoCar = setAllDataSmallInfoCar(car);
                smallInfoCars.add(smallInfoCar);
            });
        } else {
            Iterable<Car> cars = this.carRepository.findAll();
            cars.forEach(car -> {
                SmallInfoCar smallInfoCar = setAllDataSmallInfoCar(car);
                smallInfoCars.add(smallInfoCar);
            });
        }

        return smallInfoCars;
    }

    public List<String> getAllMakes() {
        Set<String> makes = new HashSet<>();
        Iterable<Car> cars = this.carRepository.findAll();
        cars.forEach(car -> makes.add(car.getMake()));

        return List.copyOf(makes);
    }

    public List<String> getAllModelInMake(String make) {
        Set<String> models = new HashSet<>();
        Iterable<Car> cars = this.carRepository.findByMake(make);
        cars.forEach(car -> models.add(car.getModel()));

        return List.copyOf(models);
    }

    private SmallInfoCar setAllDataSmallInfoCar(Car car) {
        SmallInfoCar smallInfoCar = new SmallInfoCar();
        smallInfoCar.setCarId(car.getCarId());
        smallInfoCar.setMake(car.getMake());
        smallInfoCar.setModel(car.getModel());
        smallInfoCar.setYearOfProduction(car.getYearOfProduction());
        smallInfoCar.setPrice(car.getPrice());
        smallInfoCar.setCarDealerId(car.getCarDealerId());
        CarDealer carDealer = this.carDealerRepository.findByCarDealerId(car.getCarDealerId());

        if(carDealer != null)
            smallInfoCar.setCarDealerName(carDealer.getNameOfFirm());

        return smallInfoCar;
    }
}
