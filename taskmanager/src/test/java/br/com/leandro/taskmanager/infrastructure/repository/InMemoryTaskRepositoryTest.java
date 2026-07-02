package br.com.leandro.taskmanager.infrastructure.repository;

import br.com.leandro.taskmanager.domain.TaskRepository;
import br.com.leandro.taskmanager.domain.TaskRepositoryTest;

class InMemoryTaskRepositoryTest extends TaskRepositoryTest {

    private InMemoryTaskRepository repository;

    @Override
    protected TaskRepository createRepository() {
        return new InMemoryTaskRepository();
    }
}