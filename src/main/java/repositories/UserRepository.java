package repositories;

import entities.User;
import java.util.List;
import java.util.Optional;
import lombok.Cleanup;
import lombok.NoArgsConstructor;
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(User obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Optional<User> getById(Long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<User> getAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
