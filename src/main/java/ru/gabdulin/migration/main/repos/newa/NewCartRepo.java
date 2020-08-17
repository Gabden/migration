package ru.gabdulin.migration.main.repos.newa;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.gabdulin.migration.main.models.newer.cart.Cart;

public interface NewCartRepo extends JpaRepository<Cart, Long> {
}
