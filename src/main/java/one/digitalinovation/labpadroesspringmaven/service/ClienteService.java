package one.digitalinovation.labpadroesspringmaven.service;

import one.digitalinovation.labpadroesspringmaven.model.Cliente;

public interface ClienteService {
		Iterable<Cliente> buscarTodos();
		Cliente buscarPorId(Long id);
		void inserir(Cliente cliente);
		void atualizar(Long id, Cliente cliente);
		void deletar(Long id);
		void salvarClienteComCep(Cliente cliente);
		void cadastrar(Cliente cliente);
}
