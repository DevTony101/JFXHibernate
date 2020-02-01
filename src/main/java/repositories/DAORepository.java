package repositories;

import java.util.List;
import java.util.Optional;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import utils.*;

/**
 *
 * @author Tony Manjarres
 * @param <T> Entity for which this repository is going to define the database
 * operations
 */
public interface DAORepository<T> {

    SessionFactory FACTORY = new Configuration().configure(Constants.HIBERNATE_XML).buildSessionFactory();

    void save(T obj);

    void update(T obj);

    void delete(T obj);

    Optional<T> getById(Long id);

    List<T> getAll();
}
