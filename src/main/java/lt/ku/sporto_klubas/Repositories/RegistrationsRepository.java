package lt.ku.sporto_klubas.Repositories;

import lt.ku.sporto_klubas.Entities.Registrations;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RegistrationsRepository extends JpaRepository<Registrations, Integer> {
}
