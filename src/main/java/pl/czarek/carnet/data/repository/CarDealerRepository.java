package pl.czarek.carnet.data.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import pl.czarek.carnet.data.entity.CarDealer;

import java.util.List;

@Repository
public interface CarDealerRepository extends PagingAndSortingRepository<CarDealer, Long> {
    CarDealer findByCarDealerId(Long carDealerId);
    CarDealer findByNameOfFirm(String nameOfFirm);
}
