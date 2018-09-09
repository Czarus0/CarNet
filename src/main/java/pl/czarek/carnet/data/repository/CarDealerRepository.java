package pl.czarek.carnet.data.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import pl.czarek.carnet.data.entity.CarDealer;

@Repository
public interface CarDealerRepository extends PagingAndSortingRepository<CarDealer, Long> {
    CarDealer findByCarDealerId(Long carDealerId);
}
