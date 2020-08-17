package ru.gabdulin.migration.main.repos.old;


import org.springframework.data.jpa.repository.JpaRepository;
import ru.gabdulin.migration.main.models.old.address.BillingAddress;

public interface BillingAddressRepository extends JpaRepository<BillingAddress, Long> {
}
