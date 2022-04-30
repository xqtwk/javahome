package lt.ku.sporto_klubas.Controller;

import lt.ku.sporto_klubas.Entities.Workouts;
import lt.ku.sporto_klubas.Services.WorkoutsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class WorkoutsController {
    @Autowired
    WorkoutsService workoutsService;
    @GetMapping("/workouts")
    public String workouts(Model model){
        model.addAttribute("workouts", workoutsService.getWorkouts());
        return "workouts";
    }
    @GetMapping("/new_workout")
    public String workoutNew(Model model){
        return "new_workout";
    }
    @PostMapping("/new_workout")
    public String addWorkout(
            @RequestParam("name") String name, @RequestParam("date") String date, @RequestParam("places") Integer places,
                             @RequestParam("location")String location){
        Workouts c = new Workouts(name,date,places,location);
        workoutsService.add(c);
        return "redirect:/workouts";
    }
    @GetMapping("/update_workout")
    public String workoutNew(@RequestParam("id") Integer id, Model model){
        model.addAttribute("workout",workoutsService.getWorkout(id));
        return "update_workout";
    }
    @PostMapping("/update_workout")
    public String workoutUpdate(@ModelAttribute Workouts c){
        workoutsService.update(c);
        return "redirect:/workouts";
    }
    @GetMapping("/delete_workout")
    public String workoutDelete(Model model, @RequestParam("id") Integer id){
        workoutsService.delete(id);
        return "redirect:/workouts";
    }
}
