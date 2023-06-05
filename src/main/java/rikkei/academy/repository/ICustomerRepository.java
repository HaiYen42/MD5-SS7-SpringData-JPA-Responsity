package rikkei.academy.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import rikkei.academy.model.Customer;
import rikkei.academy.model.Province;

public interface ICustomerRepository extends PagingAndSortingRepository<Customer, Long> {
    Iterable<Customer> findAllByProvince(Province province);
}
