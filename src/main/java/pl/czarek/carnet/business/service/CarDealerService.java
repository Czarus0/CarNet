package pl.czarek.carnet.business.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.czarek.carnet.business.domain.ShortInfoCarDealer;
import pl.czarek.carnet.data.entity.Address;
import pl.czarek.carnet.data.entity.Car;
import pl.czarek.carnet.data.entity.CarDealer;
import pl.czarek.carnet.data.repository.AddressRepository;
import pl.czarek.carnet.data.repository.CarDealerRepository;
import pl.czarek.carnet.data.repository.CarRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class CarDealerService {
    private CarRepository carRepository;
    private CarDealerRepository carDealerRepository;
    private AddressRepository addressRepository;

    @Autowired
    public CarDealerService(CarRepository carRepository, CarDealerRepository carDealerRepository,
                            AddressRepository addressRepository) {
        this.carRepository = carRepository;
        this.carDealerRepository = carDealerRepository;
        this.addressRepository = addressRepository;
    }

    public List<ShortInfoCarDealer> getShortenInfoAboutCarDealers() {
        List<ShortInfoCarDealer> shortInfoCarDealers = new ArrayList<>();
        Iterable<CarDealer> carDealers = this.carDealerRepository.findAll();
        carDealers.forEach(carDealer -> {
            ShortInfoCarDealer shortInfoCarDealer = getShortInfoCarDealerFromCarDealer(carDealer);
            shortInfoCarDealers.add(shortInfoCarDealer);
        });

        return shortInfoCarDealers;
    }

    public ShortInfoCarDealer getShortenInfoAboutCarDealer(Long carDealerId) {
        CarDealer carDealer = this.carDealerRepository.findByCarDealerId(carDealerId);
        return getShortInfoCarDealerFromCarDealer(carDealer);
    }

    public List<Car> getCarsBelongingToShortInfoCarDealer(Long carDealerId) {
        return this.carRepository.findByCarDealerId(carDealerId);
    }

    private ShortInfoCarDealer getShortInfoCarDealerFromCarDealer(CarDealer carDealer) {
        ShortInfoCarDealer shortInfoCarDealer = new ShortInfoCarDealer();
        shortInfoCarDealer.setCarDealerId(carDealer.getCarDealerId());
        shortInfoCarDealer.setNameOfFirm(carDealer.getNameOfFirm());
        shortInfoCarDealer.setPhoneNumber(carDealer.getPhoneNumber());
        shortInfoCarDealer.setOpenFrom(carDealer.getOpenFrom());
        shortInfoCarDealer.setOpenTo(carDealer.getOpenTo());
        shortInfoCarDealer.setCarDealerImage(carDealer.getCarDealerImage());

        Address address = this.addressRepository.findByAddressId(carDealer.getAddressId());
        if(address != null) {
            shortInfoCarDealer.setAddressId(carDealer.getAddressId());
            shortInfoCarDealer.setStreet(address.getStreet());
            shortInfoCarDealer.setNumberHome(address.getNumberHome());
            shortInfoCarDealer.setPostCode(address.getPostCode());
            shortInfoCarDealer.setCity(address.getCity());
            shortInfoCarDealer.setCountry(address.getCountry());
        }

        return shortInfoCarDealer;
    }
}
