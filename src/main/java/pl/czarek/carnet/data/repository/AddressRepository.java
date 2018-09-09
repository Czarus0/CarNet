package pl.czarek.carnet.data.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;
import pl.czarek.carnet.data.entity.Address;

@Repository
public interface AddressRepository extends PagingAndSortingRepository<Address, Long> {
    Address findByAddressId(Long addressId);
}
