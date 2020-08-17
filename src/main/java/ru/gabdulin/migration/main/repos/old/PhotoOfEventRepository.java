package ru.gabdulin.migration.main.repos.old;


import org.springframework.data.jpa.repository.JpaRepository;
import ru.gabdulin.migration.main.models.old.admin.PhotoOfEvent;

import java.util.List;

public interface PhotoOfEventRepository extends JpaRepository<PhotoOfEvent, Long> {
    List<PhotoOfEvent> findByLifeEvents_Id(Long id);
    List<PhotoOfEvent> findAllByLifeEvents_Id(Long id);
}
