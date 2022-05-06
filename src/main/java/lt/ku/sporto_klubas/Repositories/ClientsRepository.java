package lt.ku.sporto_klubas.Repositories;

import lt.ku.sporto_klubas.Entities.Clients;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientsRepository extends JpaRepository<Clients, Integer> {
    Clients findByUsername(String username);
}
