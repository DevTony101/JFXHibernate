package repositories;

import entities.User;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import lombok.Cleanup;
import lombok.NoArgsConstructor;
import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.jboss.logging.Logger;

/**
 *
 * @author Tony Manjarres
 */
@NoArgsConstructor
public class UserRepository implements DAORepository<User> {

    private static final Logger LOG = Logger.getLogger(UserRepository.class);

    public static UserRepository getInstance() {
        return UserRepository.UserRepositoryHolder.INSTANCE;
    }

    private static class UserRepositoryHolder {

        private static final UserRepository INSTANCE = new UserRepository();
    }

    @Override
    public void save(User obj) {
        @Cleanup
        Session session = FACTORY.openSession();
        Transaction trans = session.beginTransaction();
        try {
            session.save(obj);
            LOG.info("User saved succesfully");
        } catch (Exception e) {
            LOG.error("Error: " + e.getMessage());
        } finally {
            trans.commit();
        }
    }

    @Override
    public void update(User obj) {
        @Cleanup
        Session session = FACTORY.openSession();
        Transaction trans = session.beginTransaction();
        try {
            session.update(obj);
            LOG.info("User updated succesfully");
        } catch (Exception e) {
            LOG.error("Error: " + e.getMessage());
        } finally {
            trans.commit();
        }
    }

    @Override
    public void delete(User obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Optional<User> getById(Long id) {
        @Cleanup
        Session session = FACTORY.openSession();
        Transaction trans = session.beginTransaction();
        String jpql = "SELECT u FROM User u WHERE u.id = :id";
        User user = session.createQuery(jpql, User.class).setParameter("id", id).getSingleResult();
        Hibernate.initialize(user.getTasks());
        trans.commit();
        return Optional.of(user);
    }

    @Override
    public List<User> getAll() {
        @Cleanup
        Session session = FACTORY.openSession();
        Transaction trans = session.beginTransaction();
        List<User> users = new LinkedList<>();
        try {
            String jpql = "SELECT u FROM User u";
            users.addAll(session.createQuery(jpql, User.class).getResultList());
            LOG.info("Retrieving all users...");
        } catch (Exception e) {
            LOG.error("Error: " + e.getMessage());
        } finally {
            trans.commit();
        }

        return users;
    }

}
