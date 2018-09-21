package pl.czarek.carnet.business.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.czarek.carnet.business.domain.CarPost;
import pl.czarek.carnet.data.entity.Car;
import pl.czarek.carnet.data.entity.Fuel;
import pl.czarek.carnet.data.repository.CarRepository;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Service
public class CarPostService {
    private CarRepository carRepository;

    @Autowired
    public CarPostService(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    public void saveCar(CarPost carPost) {
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        DecimalFormat df = new DecimalFormat("#.#");
        df.setRoundingMode(RoundingMode.HALF_UP);

        Car newCar = new Car();
        newCar.setCarDealerId(carPost.getCarDealerId());
        newCar.setMake(carPost.getMake());
        newCar.setModel(carPost.getModel());
        newCar.setYearOfProduction(carPost.getYearOfProduction());
        newCar.setUsed(Integer.parseInt(carPost.getUsed()));
        newCar.setPrice(Integer.parseInt(carPost.getPrice()));
        newCar.setEngine(((float) Math.round(Float.parseFloat(carPost.getEngine()) * 10)) / 10);
        newCar.setFuel(Fuel.valueOf(carPost.getFuel()));
        newCar.setAirConditioning(carPost.isAirConditioning());
        if(carPost.getCarImage().equals(""))
            newCar.setCarImage(null);
        else
            newCar.setCarImage(carPost.getCarImage());
        newCar.setDatePosted(LocalDate.now().format(dateTimeFormatter));

        carRepository.save(newCar);
    }
}
