package ru.gabdulin.migration.main.repos.newa;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.gabdulin.migration.main.models.newer.UserDetailsDescription;

public interface UserDescriptionRepo extends JpaRepository<UserDetailsDescription, Long> {
}
