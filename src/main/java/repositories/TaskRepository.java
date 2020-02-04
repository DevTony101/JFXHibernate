/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package repositories;

import entities.Task;
import java.util.List;
import java.util.Optional;
import lombok.Cleanup;
import lombok.NoArgsConstructor;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.jboss.logging.Logger;
import static repositories.DAORepository.FACTORY;

/**
 *
 * @author Tony Manjarres
 */
@NoArgsConstructor
public class TaskRepository implements DAORepository<Task> {
    
    private static final Logger LOG = Logger.getLogger(TaskRepository.class);
    
    public static TaskRepository getInstance() {
        return TaskRepositoryHolder.INSTANCE;
    }

    @Override
    public void save(Task obj) {
        @Cleanup
        Session session = FACTORY.openSession();
        Transaction trans = session.beginTransaction();
        try {
            session.save(obj);
            LOG.info("Task saved succesfully");
        } catch (Exception e) {
            LOG.error("Error: " + e.getMessage());
        } finally {
            trans.commit();
        }
    }

    @Override
    public void update(Task obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete(Task obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Optional<Task> getById(Long id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Task> getAll() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    private static class TaskRepositoryHolder {

        private static final TaskRepository INSTANCE = new TaskRepository();
    }
}
