package one.digitalinovation.labpadroesspringmaven.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import one.digitalinovation.labpadroesspringmaven.model.Cliente;
import one.digitalinovation.labpadroesspringmaven.service.ClienteService;

@RestController
@RequestMapping("clientes")
public class ClienteRestController {
		@Autowired
		private ClienteService clienteService;
		
		@GetMapping("/all")
		public ResponseEntity<Iterable<Cliente>> buscarTodos(){
			return ResponseEntity.ok(clienteService.buscarTodos());		
		}

		@GetMapping("/{id}")
		public ResponseEntity<Cliente> buscarPorId(@PathVariable Long id){
			return ResponseEntity.ok(clienteService.buscarPorId(id));
		}
		
		@PostMapping
		public ResponseEntity<Cliente> inserir( @RequestBody Cliente cliente){
				clienteService.inserir(cliente);
				return ResponseEntity.ok(cliente);		
		}
		
	   @PostMapping("/cadastro")
	    public String cadastrar(@RequestBody Cliente cliente) {
	        // Lógica para cadastrar o cliente
		   clienteService.cadastrar(cliente);
	        return "redirect:/index.html"; // Redireciona de volta para a lista de clientes após o cadastro
	    }
		@PutMapping("/{id}")
		public ResponseEntity<Cliente> atualizar(@PathVariable Long id, @RequestBody Cliente cliente){
			clienteService.atualizar(id, cliente);
			return ResponseEntity.ok(cliente);
		}
		
		@DeleteMapping("/{id}")
		public ResponseEntity<Void> deletar(@PathVariable Long id){
			clienteService.deletar(id);		
			return ResponseEntity.ok().build();
		}
		
}
