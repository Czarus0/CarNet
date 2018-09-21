package pl.czarek.carnet.data.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import pl.czarek.carnet.data.entity.Car;

import java.util.List;

@Repository
public interface CarRepository extends PagingAndSortingRepository<Car, Long> {
    Car findByCarId(Long CarId);
    List<Car> findByCarDealerId(Long carDealerId);
    List<Car> findByMake(String make);
    List<Car> findByMakeAndModel(String make, String model);
}
