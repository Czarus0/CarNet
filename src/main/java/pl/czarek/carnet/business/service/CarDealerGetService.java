package pl.czarek.carnet.business.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.czarek.carnet.business.domain.CarDealerGet;
import pl.czarek.carnet.data.entity.Address;
import pl.czarek.carnet.data.entity.Car;
import pl.czarek.carnet.data.entity.CarDealer;
import pl.czarek.carnet.data.repository.AddressRepository;
import pl.czarek.carnet.data.repository.CarDealerRepository;
import pl.czarek.carnet.data.repository.CarRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class CarDealerGetService {
    private CarRepository carRepository;
    private CarDealerRepository carDealerRepository;
    private AddressRepository addressRepository;

    @Autowired
    public CarDealerGetService(CarRepository carRepository, CarDealerRepository carDealerRepository,
                               AddressRepository addressRepository) {
        this.carRepository = carRepository;
        this.carDealerRepository = carDealerRepository;
        this.addressRepository = addressRepository;
    }

    public List<CarDealerGet> getCarDealers() {
        List<CarDealerGet> listOfCarDealerGet = new ArrayList<>();
        Iterable<CarDealer> carDealers = this.carDealerRepository.findAll();
        
        carDealers.forEach(carDealer -> listOfCarDealerGet.add(this.getCarDealerFromRepo(carDealer)));
        
        return listOfCarDealerGet;
    }

    public CarDealerGet getCarDealer(Long carDealerId) {
        return this.getCarDealerFromRepo(this.carDealerRepository.findByCarDealerId(carDealerId));
    }
    
    private CarDealerGet getCarDealerFromRepo(CarDealer carDealer) {
        CarDealerGet carDealerGet = new CarDealerGet();
        carDealerGet.setCarDealerId(carDealer.getCarDealerId());
        carDealerGet.setNameOfFirm(carDealer.getNameOfFirm());
        carDealerGet.setPhoneNumber(carDealer.getPhoneNumber());
        carDealerGet.setOpenFrom(carDealer.getOpenFrom());
        carDealerGet.setOpenTo(carDealer.getOpenTo());
        carDealerGet.setCarDealerImage(carDealer.getCarDealerImage());

        Address address = this.addressRepository.findByAddressId(carDealer.getAddressId());
        if(address != null) {
            carDealerGet.setAddressId(carDealer.getAddressId());
            carDealerGet.setStreet(address.getStreet());
            carDealerGet.setNumberHome(address.getNumberHome());
            carDealerGet.setPostCode(address.getPostCode());
            carDealerGet.setCity(address.getCity());
            carDealerGet.setCountry(address.getCountry());
        }

        return carDealerGet;
    }
    
    public List<Car> getCarsOfCarDealer(Long carDealerId) {
        return this.carRepository.findByCarDealerId(carDealerId);
    }
}
