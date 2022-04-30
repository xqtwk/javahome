package lt.ku.sporto_klubas.Services;

import lt.ku.sporto_klubas.Entities.Workouts;
import lt.ku.sporto_klubas.Repositories.WorkoutsRepository;
import org.hibernate.jdbc.Work;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class WorkoutsService {
    @Autowired
    WorkoutsRepository workoutsRepository;
    public List<Workouts> getWorkouts() {
        return workoutsRepository.findAll();
    }
    public Workouts getWorkout(Integer id) {
        return workoutsRepository.getById(id);
    }
    public Workouts add(Workouts  workout) {
        return workoutsRepository.save(workout);
    }
    public Workouts update(Workouts workout) {
        Workouts old = this.getWorkout(workout.getId());
        old.setName(workout.getName());
        old.setDate(workout.getDate());
        old.setPlaces(workout.getPlaces());
        old.setLocation(workout.getLocation());
        workoutsRepository.save(old);
        return old;
    }
    public void delete(Integer id) {
       workoutsRepository.deleteById(id);
    }
}
