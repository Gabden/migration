package ru.gabdulin.migration.main.repos.old;


import org.springframework.data.jpa.repository.JpaRepository;
import ru.gabdulin.migration.main.models.old.Product;
import ru.gabdulin.migration.main.models.old.ProductImage;

import java.util.ArrayList;

public interface ProductImageRepository extends JpaRepository<ProductImage, Long> {
//    ProductImage findProductImageByProduct(Product product);
    ArrayList<ProductImage> findProductImageByProduct(Product product);
}
