package ru.gabdulin.migration.main.repos.old;


import org.springframework.data.jpa.repository.JpaRepository;
import ru.gabdulin.migration.main.models.old.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
