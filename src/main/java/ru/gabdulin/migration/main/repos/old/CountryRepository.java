package ru.gabdulin.migration.main.repos.old;


import org.springframework.data.jpa.repository.JpaRepository;
import ru.gabdulin.migration.main.models.old.details.Country;

import java.util.List;

public interface CountryRepository extends JpaRepository<Country, Long> {
    List<Country> findCountriesByCountryEquals(String country);
}
