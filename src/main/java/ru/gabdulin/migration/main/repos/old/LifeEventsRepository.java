package ru.gabdulin.migration.main.repos.old;


import org.springframework.data.jpa.repository.JpaRepository;
import ru.gabdulin.migration.main.models.old.admin.LifeEvents;

public interface LifeEventsRepository extends JpaRepository<LifeEvents, Long> {
    LifeEvents findByNameOfEvent(String nameOfEvent);
}
