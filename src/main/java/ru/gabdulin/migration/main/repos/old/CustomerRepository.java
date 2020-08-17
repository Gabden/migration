package ru.gabdulin.migration.main.repos.old;


import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import ru.gabdulin.migration.main.models.old.Customer;

public interface CustomerRepository extends PagingAndSortingRepository<Customer, Long> {
    Customer findCustomerByCustomerName(String name);
    Page<Customer> findCustomersByCustomerPhone(String phone, Pageable pageable);

}
