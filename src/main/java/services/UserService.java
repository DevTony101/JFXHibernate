package services;

import entities.User;
import java.util.Calendar;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import lombok.NoArgsConstructor;
import org.hibernate.Hibernate;
import repositories.UserRepository;

/**
 *
 * @author Tony Manjarres
 */
@NoArgsConstructor
public class UserService {

    private final UserRepository repo = UserRepository.getInstance();

    public static UserService getInstance() {
        return UserServiceHolder.INSTANCE;
    }

    private static class UserServiceHolder {

        private static final UserService INSTANCE = new UserService();
    }

    public void saveUser(String fname, String lname, String username, String status) {
        User user = new User();
        user.setFirstName(fname);
        user.setLastName(lname);
        user.setUsername(username);
        user.setCivilStatus(status);
        user.setDate(Calendar.getInstance().getTime());
        user.setVerified(Boolean.TRUE);
        repo.save(user);
    }

    public void updateUser(User user) {
        repo.update(user);
    }

    public User getUserById(Long id) {
        Optional<User> op = repo.getById(id);
        User user = null;
        if (op.isPresent()) {
            user = op.get();
        }
        return user;
    }

    public List<User> getAllUsers() {
        return new LinkedList<>(repo.getAll());
    }

}
