package location.repository;

import location.model.Country;

import java.util.List;

public interface CountryRepositoryCustom {
    public List<Country> findByNameContaining(String name);
}
