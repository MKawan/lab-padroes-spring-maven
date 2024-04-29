package one.digitalinovation.labpadroesspringmaven.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import one.digitalinovation.labpadroesspringmaven.model.Cliente;
import one.digitalinovation.labpadroesspringmaven.model.Endereco;
import one.digitalinovation.labpadroesspringmaven.model.RepositoryCliente;
import one.digitalinovation.labpadroesspringmaven.model.RepositoryEndereco;
import one.digitalinovation.labpadroesspringmaven.service.ClienteService;
import one.digitalinovation.labpadroesspringmaven.service.ViaCepService;

@Service
public class ClienteServiceImpl implements ClienteService{
	@Autowired
	private RepositoryCliente repositoryCliente;
	@Autowired
	private RepositoryEndereco repositoryEndereco;
	@Autowired
	private ViaCepService viaCepService;
	
	@Override
	public Iterable<Cliente> buscarTodos() {
		// TODO Auto-generated method stub
		return repositoryCliente.findAll();
	}

	@Override
	public Cliente buscarPorId(Long id) {
		// TODO Auto-generated method stub
		Optional<Cliente> cliente = repositoryCliente.findById(id);
		return cliente.get();
	}

	@Override
	public void inserir(Cliente cliente) {
		// TODO Auto-generated method stub
		salvarClienteComCep(cliente);
	}
	@Override
	public void cadastrar(Cliente cliente) {
		// TODO Auto-generated method stub
		salvarClienteComCep(cliente);
	}

	@Override
	public void atualizar(Long id, Cliente cliente) {
		// TODO Auto-generated method stub
		Optional<Cliente> clientedBdOptional = repositoryCliente.findById(id);
		if(clientedBdOptional.isPresent()) {
			salvarClienteComCep(cliente);
		}
	}

	@Override
	public void deletar(Long id) {
		// TODO Auto-generated method stub
		repositoryCliente.deleteById(id);
	}
	
	@Override
	public void 	salvarClienteComCep(Cliente cliente) {
		String cep = cliente.getEndereco().getCep();
		Endereco endereco = repositoryEndereco.findById(cep).orElseGet(() -> {
			Endereco novoEndereco= viaCepService.consutarCep(cep)	;
			repositoryEndereco.save(novoEndereco);
			return novoEndereco;			
		});
		cliente.setEndereco(endereco);
		repositoryCliente.save(cliente);
	}
		
}
