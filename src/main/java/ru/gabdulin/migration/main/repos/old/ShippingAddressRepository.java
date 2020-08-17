package ru.gabdulin.migration.main.repos.old;


import org.springframework.data.jpa.repository.JpaRepository;
import ru.gabdulin.migration.main.models.old.address.ShippingAddress;

public interface ShippingAddressRepository extends JpaRepository<ShippingAddress, Long> {
}

