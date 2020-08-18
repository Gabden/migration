package ru.gabdulin.migration.main.repos.newa;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.gabdulin.migration.main.models.newer.product.ProductDetails;

public interface NewProductDetailsRepo extends JpaRepository<ProductDetails, Long> {
}
