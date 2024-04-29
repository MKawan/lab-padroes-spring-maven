package one.digitalinovation.labpadroesspringmaven.model;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RepositoryCliente extends CrudRepository<Cliente, Long> {

}
