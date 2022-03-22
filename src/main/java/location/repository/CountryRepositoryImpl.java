package location.repository;

import location.model.Country;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.EntityManager;
import javax.persistence.criteria.*;
import java.util.List;

public class CountryRepositoryImpl implements CountryRepositoryCustom {

    private static final Logger log = LoggerFactory.getLogger(CountryRepositoryImpl.class);
    @Autowired
    private EntityManager entityManager;
    @Override
    public List<Country> findByNameContaining(String name) {


        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Country> q = cb.createQuery(Country.class);
        Root<Country> country = q.from(Country.class);
        //Root<Order> order = q.from(Country.class);
        //q.select(country.get("name").<Country>get("name"));
        q.select(country).where(cb.like(country.get("name"), name));

        //CriteriaQuery<Country> query = cb.createQuery(Country.class);

        //Path<String> countryNamePath = country.get("name");
        log.info("*********************************************");
        log.info("country: " + country.toString());
        log.info("name: " + name);

        //query.select(country).where(cb.like(countryNamePath, name));

        return entityManager.createQuery(q).getResultList();
    }
}
