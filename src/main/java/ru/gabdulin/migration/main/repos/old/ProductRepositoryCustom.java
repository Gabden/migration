package ru.gabdulin.migration.main.repos.old;


import org.springframework.data.jpa.repository.JpaRepository;
import ru.gabdulin.migration.main.models.old.Product;

import java.util.List;

public interface ProductRepositoryCustom extends JpaRepository<Product,Long> {
    List<Product> findByproductCategory(String category);
}
