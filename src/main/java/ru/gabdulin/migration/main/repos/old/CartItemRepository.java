package ru.gabdulin.migration.main.repos.old;


import org.springframework.data.repository.CrudRepository;
import ru.gabdulin.migration.main.models.old.cart.CartItem;

public interface CartItemRepository extends CrudRepository<CartItem,Long> {
    void deleteCartItemByProductId(Long id);
}
