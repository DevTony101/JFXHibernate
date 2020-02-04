package services;

import entities.Task;
import entities.User;
import java.util.Date;
import lombok.NoArgsConstructor;
import repositories.TaskRepository;

/**
 *
 * @author Tony Manjarres
 */
@NoArgsConstructor
public class TaskService {

    private final TaskRepository repo = TaskRepository.getInstance();
    private final UserService uService = UserService.getInstance();

    public static TaskService getInstance() {
        return TaskServiceHolder.INSTANCE;
    }

    private static class TaskServiceHolder {

        private static final TaskService INSTANCE = new TaskService();
    }

    public void saveTask(String title, String description, Date deadline, Long id) {
        User user = uService.getUserById(id);
        Task task = new Task();
        task.setTitle(title);
        task.setDescription(description);
        task.setDeadline(deadline);
        task.setCompleted(Boolean.FALSE);
        task.setUser(user);
        repo.save(task);
        
        user.getTasks().add(task);
        uService.updateUser(user);
    }
}
