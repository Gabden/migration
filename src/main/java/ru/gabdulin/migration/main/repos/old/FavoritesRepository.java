package ru.gabdulin.migration.main.repos.old;


import org.springframework.data.jpa.repository.JpaRepository;
import ru.gabdulin.migration.main.models.old.Favorites;

public interface FavoritesRepository extends JpaRepository<Favorites, Long> {
}
