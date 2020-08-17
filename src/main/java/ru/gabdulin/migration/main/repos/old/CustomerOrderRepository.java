package ru.gabdulin.migration.main.repos.old;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;
import ru.gabdulin.migration.main.models.old.Customer;
import ru.gabdulin.migration.main.models.old.CustomerOrder;
import ru.gabdulin.migration.main.models.old.cart.Cart;

import java.util.List;

public interface CustomerOrderRepository extends PagingAndSortingRepository<CustomerOrder, Long> {
    Page<CustomerOrder> findAllByCustomer(Customer customer, Pageable pageable);
    List<CustomerOrder> findCustomerOrderByCart(Cart cart);

    List<CustomerOrder> findCustomerOrdersByStatus(String status);
}
