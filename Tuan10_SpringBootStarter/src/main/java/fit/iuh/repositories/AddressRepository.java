package fit.iuh.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.rest.webmvc.RepositoryRestController;

import fit.iuh.entities.Address;

@RepositoryRestController
public interface AddressRepository extends JpaRepository<Address, Integer> {
	@Query(value="")
	List<Address> get
}
