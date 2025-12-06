package solodev.jchristy.task_manager_api.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import solodev.jchristy.task_manager_api.entity.Task;

@Repository
public interface TaskRepository extends JpaRepository<Task, Long> {

}
