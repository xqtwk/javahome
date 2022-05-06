package lt.ku.sporto_klubas.Controller;

import lt.ku.sporto_klubas.Entities.Clients;
import lt.ku.sporto_klubas.Entities.Registrations;
import lt.ku.sporto_klubas.Entities.Workouts;
import lt.ku.sporto_klubas.Services.ClientsService;
import lt.ku.sporto_klubas.Services.RegistrationsService;
import lt.ku.sporto_klubas.Services.WorkoutsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/registrations")
public class RegistrationsController {
    @Autowired
    RegistrationsService registrationsService;
    @Autowired
    WorkoutsService workoutsService;
    @Autowired
    ClientsService clientsService;
    @GetMapping("/")
    public String registrations(Model model){
        model.addAttribute("registrations", registrationsService.getRegistrations());
        return "registrations";
    }
    @GetMapping("/new")
    public String registrationNew(Model model){
        model.addAttribute("workouts", workoutsService.getWorkouts());
        model.addAttribute("clients", clientsService.getAllClients());
        return "new_registration";
    }
    @PostMapping("/new")
    public String addRegistration(@ModelAttribute Registrations registration,    @RequestParam("client") Clients client, @RequestParam("workout") Workouts workout){
        registration.setClients(client);
        registration.setWorkout(workout);
        registration.setRegistration_date();
        registrationsService.add(registration);
        return "redirect:/registrations/";
    }
    @GetMapping("/delete")
    public String registrationDelete(Model model, @RequestParam("id") Integer id){
        registrationsService.delete(id);
        return "redirect:/registrations/";
    }

}
