package solodev.jchristy.task_manager_api.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import solodev.jchristy.task_manager_api.entity.Task;
import solodev.jchristy.task_manager_api.repository.TaskRepository;

@Service
public class TaskService {
    private final TaskRepository taskRepository;

    @Autowired
    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    public Task saveTask(Task task) {
        return taskRepository.save(task);
    }

    public List<Task> getAllTasks() {
        return taskRepository.findAll();
    }

    public Optional<Task> getTaskById(Long id) {
        return taskRepository.findById(id);
    }

    public Task updateTask(Long id, Task updatedTask) {
        Optional<Task> existingTask = taskRepository.findById(id);
        if (existingTask.isPresent()) {
            Task task = existingTask.get();
            task.setTitle(updatedTask.getTitle());
            task.setDescription(updatedTask.getDescription());
            task.setCompleted(updatedTask.getCompleted());
            task.setDueDate(updatedTask.getDueDate());
            return taskRepository.save(task);
        }
        else {
            throw new RuntimeException("Task not found");
        }
    }

    public void deleteTask(Long id) {
        taskRepository.deleteById(id);
    }
}
