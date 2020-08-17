package ru.gabdulin.migration.main.repos.old;


import org.springframework.data.jpa.repository.JpaRepository;
import ru.gabdulin.migration.main.models.old.details.ProductType;

import java.util.List;

public interface TypeRepository extends JpaRepository<ProductType, Long> {
    List<ProductType> findProductTypesByTypeEquals(String type);
}
