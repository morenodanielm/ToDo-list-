package com.daniel.todoapp.persistence.repository;

import com.daniel.todoapp.persistence.entity.Task;
import com.daniel.todoapp.persistence.entity.TaskStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TaskRepository extends JpaRepository<Task, Long> {

    public List<Task> findAllByTaskStatus(TaskStatus status);

    @Modifying
    @Query(value = "UPDATE task SET finished = true WHERE id=:id", nativeQuery = true)
    public void markTaskAsFinished(@Param("id") Long id);
}
