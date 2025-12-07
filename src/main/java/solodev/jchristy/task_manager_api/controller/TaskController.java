package solodev.jchristy.task_manager_api.controller;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import solodev.jchristy.task_manager_api.entity.Task;
import solodev.jchristy.task_manager_api.service.TaskService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1")
public class TaskController {

    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    // Create a new task.

    @PostMapping("/task")
    public ResponseEntity<Task> saveTask(@RequestBody Task task) {
        Task newTask = taskService.saveTask(task);
        return ResponseEntity.ok(newTask);
    }

    // Get all tasks.
     
    @GetMapping("/tasks")
    public List<Task> getAllTasks() {
        return taskService.getAllTasks();
    }

    // Get a task by ID.
    
    @GetMapping("/tasks/{id}")
    public ResponseEntity<Task> getTaskById(@PathVariable Long id) {
        Optional<Task> task = taskService.getTaskById(id);
        return task.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Update a task by ID.
     
    @PutMapping("/tasks/{id}")
    public ResponseEntity<Task> updateTask(@PathVariable Long id, @RequestBody Task task) {
        Task updatedTask = taskService.updateTask(id, task);
        return ResponseEntity.ok(updatedTask);
    }

    // Delete a task by ID.
     
    @DeleteMapping("/tasks/{id}")
    public ResponseEntity<String> deleteTask(@PathVariable Long id) {
        taskService.deleteTask(id);
        return ResponseEntity.ok("Task deleted successfully");
    }
}