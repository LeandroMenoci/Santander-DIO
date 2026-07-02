package br.com.leandro.design_patterns.service.impl;

import br.com.leandro.design_patterns.model.Cliente;
import br.com.leandro.design_patterns.service.ClienteService;
import org.springframework.stereotype.Service;


@Service
public class ClienteServiceImpl implements ClienteService {
    //TODO Singleton: Injetar os componentes do Spring com @Autowired
    //TODO Strategy: Implementar os métodos definidos na interface
    //TODO Facade: Abstrair integrações com subsistemas, provendo uma interface simples


    @Override
    public Iterable<Cliente> buscarTodos() {
        return null;
    }

    @Override
    public Cliente buscarPorId(Long id) {
        return null;
    }

    @Override
    public void inserir(Cliente cliente) {

    }

    @Override
    public void atualizar(Long id, Cliente cliente) {

    }

    @Override
    public void deletar(Long id) {

    }
}
