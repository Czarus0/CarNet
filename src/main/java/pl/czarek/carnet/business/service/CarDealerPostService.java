package pl.czarek.carnet.business.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.czarek.carnet.business.domain.CarDealerPost;
import pl.czarek.carnet.business.domain.CarPost;
import pl.czarek.carnet.data.entity.Address;
import pl.czarek.carnet.data.entity.Car;
import pl.czarek.carnet.data.entity.CarDealer;
import pl.czarek.carnet.data.entity.Fuel;
import pl.czarek.carnet.data.repository.AddressRepository;
import pl.czarek.carnet.data.repository.CarDealerRepository;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
public class CarDealerPostService {
    private CarDealerRepository carDealerRepository;
    private AddressRepository addressRepository;

    @Autowired
    public CarDealerPostService(CarDealerRepository carDealerRepository, AddressRepository addressRepository) {
        this.carDealerRepository = carDealerRepository;
        this.addressRepository = addressRepository;
    }

    public long saveCarDealer(CarDealerPost carDealerPost) {
        CarDealer newCarDealer = new CarDealer();
        newCarDealer.setNameOfFirm(carDealerPost.getNameOfFirm());

        if(carDealerPost.isHasPhoneNumber())
            newCarDealer.setPhoneNumber(carDealerPost.getPhoneNumber());

        newCarDealer.setOpenFrom(carDealerPost.getOpenFrom());
        newCarDealer.setOpenTo(carDealerPost.getOpenTo());

        Address newAddress = new Address();
        newAddress.setStreet(carDealerPost.getStreet());
        newAddress.setNumberHome(carDealerPost.getNumberHome());
        newAddress.setPostCode(carDealerPost.getPostCode());
        newAddress.setCity(carDealerPost.getCity());
        newAddress.setCountry(carDealerPost.getCountry());

        addressRepository.save(newAddress);

        newCarDealer.setAddressId(newAddress.getAddressId());
        carDealerRepository.save(newCarDealer);

        return newCarDealer.getCarDealerId();
    }

    public CarDealer getCarDealerByNameOfFirm(String nameOfFirm) {
        return carDealerRepository.findByNameOfFirm(nameOfFirm);
    }

//    public void updateImageCar(Long carId, String path) {
//        Car updateCar = carRepository.findByCarId(carId);
//        updateCar.setCarImage(path);
//
//        carRepository.save(updateCar);
//    }
}
