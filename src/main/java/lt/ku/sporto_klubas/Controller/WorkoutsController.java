package lt.ku.sporto_klubas.Controller;

import lt.ku.sporto_klubas.Entities.Workouts;
import lt.ku.sporto_klubas.Services.FileStorageService;
import lt.ku.sporto_klubas.Services.WorkoutsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

@Controller
@RequestMapping("/workouts")
public class WorkoutsController {
    @Autowired
    WorkoutsService workoutsService;
    @Autowired
    FileStorageService fileStorageService;
    @Autowired
    FileUploadController fileUploadController;
    @GetMapping("/")
    public String workouts(Model model){
        model.addAttribute("workouts", workoutsService.getWorkouts());
        return "workouts";
    }
    @GetMapping("/new")
    public String workoutNew(Model model){
        return "new_workout";
    }
    @PostMapping("/new")
    public String addWorkout(
            @RequestParam("name") String name,
            @RequestParam("date") String date,
            @RequestParam("places") Integer places,
            @RequestParam("location")String location,
            @RequestParam("description")MultipartFile description){
        Workouts c = new Workouts(name,date,places,location, description.getOriginalFilename());
        c = workoutsService.add(c);
        fileStorageService.store(description, c.getId().toString());
        return "redirect:/workouts/";
    }
    @GetMapping("/update/{id}")
    //public String workoutNew(@RequestParam("id") Integer id, Model model){
    public String workoutNew(@PathVariable("id") Integer id, Model model){
        model.addAttribute("workout",workoutsService.getWorkout(id));
        return "update_workout";
    }
    @PostMapping("/update/{id}")
    public String workoutUpdate(@PathVariable("id") Integer id, @ModelAttribute Workouts c, @RequestParam("description")MultipartFile description){
        c.setFilename(description.getOriginalFilename());
        fileStorageService.store(description, c.getId().toString());
        workoutsService.update(c);
        return "redirect:/workouts/";
    }
    @GetMapping("/delete/{id}")
    public String workoutDelete(@PathVariable("id") Integer id){
        workoutsService.delete(id);
        return "redirect:/workouts/";
    }
    @GetMapping("/description/{id}")
    @ResponseBody
    public ResponseEntity<Resource> getDescription(@PathVariable Integer id){
        Resource file = fileStorageService.loadFile(id.toString());
        Workouts w = workoutsService.getWorkout(id);
        return ResponseEntity
                .ok()
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\""+w.getFilename()+"\"")
                .body(file);
    }
}
