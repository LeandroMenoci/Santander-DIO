package br.com.leandro.taskmanager.application;

import br.com.leandro.taskmanager.application.input.CreateTaskInput;
import br.com.leandro.taskmanager.application.output.TaskOutput;
import br.com.leandro.taskmanager.domain.Task;
import br.com.leandro.taskmanager.domain.TaskRepository;
import org.springframework.stereotype.Service;

@Service
public class CreateTaskUserCase {

    private final TaskRepository repository;

    public CreateTaskUserCase(TaskRepository repository) {
        this.repository = repository;
    }

    public TaskOutput execute(CreateTaskInput input) {
        var task = new Task(input.title(), input.description());
        var saved = repository.save(task);
        return TaskOutput.from(task);
    }
}
