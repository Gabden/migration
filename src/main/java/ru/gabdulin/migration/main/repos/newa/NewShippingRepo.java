package ru.gabdulin.migration.main.repos.newa;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.gabdulin.migration.main.models.newer.address.ShippingAddress;

public interface NewShippingRepo extends JpaRepository<ShippingAddress, Long> {
}
