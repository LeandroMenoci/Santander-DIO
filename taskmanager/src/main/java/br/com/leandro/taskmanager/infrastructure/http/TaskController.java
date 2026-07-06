package br.com.leandro.taskmanager.infrastructure.http;

import br.com.leandro.taskmanager.application.CreateTaskUseCase;
import br.com.leandro.taskmanager.application.input.CreateTaskInput;
import br.com.leandro.taskmanager.infrastructure.http.request.CreateTaskRequest;
import br.com.leandro.taskmanager.infrastructure.http.request.response.TaskReponse;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Optional;

@RestController
@RequestMapping("/tasks")
public class TaskController {

    private final CreateTaskUseCase createTaskUseCase;

    public TaskController(CreateTaskUseCase createTaskUseCase) {
        this.createTaskUseCase = createTaskUseCase;
    }

    @PostMapping
    TaskReponse create(@RequestBody CreateTaskRequest request) {
        var input = request.toInput();
        var output = createTaskUseCase.execute(input);
        return TaskReponse.from(output);

    }
}
