package lt.ku.sporto_klubas.Repositories;

import lt.ku.sporto_klubas.Entities.Workouts;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WorkoutsRepository extends JpaRepository<Workouts, Integer> {
}
