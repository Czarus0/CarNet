package pl.czarek.carnet.business.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.czarek.carnet.business.domain.CarGet;
import pl.czarek.carnet.data.entity.Car;
import pl.czarek.carnet.data.entity.CarDealer;
import pl.czarek.carnet.data.repository.CarDealerRepository;
import pl.czarek.carnet.data.repository.CarRepository;

import java.util.*;

@Service
public class CarGetService {
    private CarRepository carRepository;
    private CarDealerRepository carDealerRepository;

    @Autowired
    public CarGetService(CarRepository carRepository, CarDealerRepository carDealerRepository) {
        this.carRepository = carRepository;
        this.carDealerRepository = carDealerRepository;
    }

    public CarGet getCar(Long carId) {
        return this.getCarFromRepo(carId);
    }

    public List<CarGet> getCarsByMakeOrModel(String make, String model) {
        List<CarGet> listOfCarGet = new ArrayList<>();

        if(make != null && model != null) {
            List<Car> cars = this.carRepository.findByMakeAndModel(make, model);
            cars.forEach(car -> {
                CarGet carGet = getCarFromRepo(car.getCarId());
                listOfCarGet.add(carGet);
            });
        } else if(make != null) {
            List<Car> cars = this.carRepository.findByMake(make);
            cars.forEach(car -> {
                CarGet carGet = getCarFromRepo(car.getCarId());
                listOfCarGet.add(carGet);
            });
        } else {
            Iterable<Car> cars = this.carRepository.findAll();
            cars.forEach(car -> {
                CarGet carGet = getCarFromRepo(car.getCarId());
                listOfCarGet.add(carGet);
            });
        }

        return listOfCarGet;
    }

    public List<String> getAllMakes() {
        Set<String> makes = new HashSet<>();
        Iterable<Car> cars = this.carRepository.findAll();
        cars.forEach(car -> makes.add(car.getMake()));


        return new ArrayList<>(makes);
    }

    public List<String> getAllModelInMake(String make) {
        Set<String> models = new HashSet<>();
        Iterable<Car> cars = this.carRepository.findByMake(make);
        cars.forEach(car -> models.add(car.getModel()));

        return new ArrayList<>(models);
    }


    private CarGet getCarFromRepo(Long carId) {
        Car car = this.carRepository.findByCarId(carId);
        CarGet carGet = new CarGet();

        carGet.setCarId(car.getCarId());
        carGet.setMake(car.getMake());
        carGet.setModel(car.getModel());
        carGet.setYearOfProduction(car.getYearOfProduction());
        carGet.setUsed(car.getUsed());
        carGet.setPrice(car.getPrice());
        carGet.setFuel(car.getFuel());
        carGet.setEngine(car.getEngine());
        carGet.setAirConditioning(car.isAirConditioning());
        carGet.setDatePosted(car.getDatePosted());
        carGet.setDateSold(car.getDateSold());
        carGet.setCarImage(car.getCarImage());

        CarDealer carDealer = this.carDealerRepository.findByCarDealerId(car.getCarDealerId());
        if(carDealer != null) {
            carGet.setCarDealerId(car.getCarDealerId());
            carGet.setNameOfFirm(carDealer.getNameOfFirm());
            carGet.setPhoneNumber(carDealer.getPhoneNumber());
            carGet.setOpenFrom(carDealer.getOpenFrom());
            carGet.setOpenTo(carDealer.getOpenTo());
        }

        return carGet;
    }
}
