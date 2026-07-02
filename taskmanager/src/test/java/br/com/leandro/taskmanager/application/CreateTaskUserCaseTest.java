package br.com.leandro.taskmanager.application;

import br.com.leandro.taskmanager.application.input.CreateTaskInput;
import br.com.leandro.taskmanager.application.output.TaskOutput;
import br.com.leandro.taskmanager.domain.Task;
import br.com.leandro.taskmanager.domain.TaskRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
class CreateTaskUserCaseTest {

    @Mock
    TaskRepository repository;

    @InjectMocks
    CreateTaskUserCase useCase;

    @Test
    void should_create_task_seccessfully() {
        // given
        var input = new CreateTaskInput("Estudar Java", Optional.of("Final da aula"));

        when(repository.save(any(Task.class)))
                .thenAnswer(invocation -> invocation.getArgument(0));

        // when
        TaskOutput output = useCase.execute(input);

        // then
        assertNotNull(output);
        assertNotNull(output.id());
        assertEquals("Estudar Java", output.title());
        assertEquals(Optional.of("Final da aula"), output.description());

        verify(repository, times(1)).save(any(Task.class));
    }

}