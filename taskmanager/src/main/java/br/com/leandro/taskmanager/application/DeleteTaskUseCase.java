package br.com.leandro.taskmanager.application;

import br.com.leandro.taskmanager.domain.TaskId;
import br.com.leandro.taskmanager.domain.TaskNotFoundException;
import br.com.leandro.taskmanager.domain.TaskRepository;
import org.springframework.stereotype.Service;

@Service
public class DeleteTaskUseCase {
    private final TaskRepository repository;

    public DeleteTaskUseCase(TaskRepository repository) {
        this.repository = repository;
    }

    public void execute(TaskId taskId) {
        if(repository.findById(taskId).isEmpty()) {
            throw new TaskNotFoundException(taskId);
        }

        repository.delete(taskId);
    }
}
