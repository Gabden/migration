package ru.gabdulin.migration.main.repos.old;


import org.springframework.data.jpa.repository.JpaRepository;
import ru.gabdulin.migration.main.models.old.admin.SalesEvents;

public interface SaleEventsRepository extends JpaRepository<SalesEvents, Long> {
}
