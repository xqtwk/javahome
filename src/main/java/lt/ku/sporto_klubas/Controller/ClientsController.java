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
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.validation.Valid;


@Controller
public class ClientsController {


    @Autowired
    ClientsService clientsService;
    @GetMapping("/")
    public String index(Model model){
        /*Registrations r = new Registrations(clientsService.getClients(11),workoutsService.getWorkout(14));
        registrationsService.add(r);
        Workouts w = new Workouts("Fitnesas","30/04/2022",6,"sporto sale 1");
        workoutsService.add(w);*/
        model.addAttribute("clients", clientsService.getAllClients());
        return "index";
    }
    @GetMapping("/new_client")
    public String clientNew(Model model){
        return "new_client";
    }
    @PostMapping("/new_client")
    public String addClient(@Valid @ModelAttribute Clients client, BindingResult result, @RequestParam("name") String name, @RequestParam("surname") String surname, @RequestParam("email") String email,
                            @RequestParam("phone")String phone, Model model){
        if (result.hasErrors()){
            return "/new_client";
        }
        client.setName(name);
        client.setPhone(phone);
        client.setEmail(email);
        client.setSurname(surname);
        //Clients c = new Clients(name,surname,email,phone);
        clientsService.addClients(client);
        return "redirect:/";
    }
    @GetMapping("/update_clients")
    public String clientNew(@RequestParam("id") Integer id, Model model){
        model.addAttribute("client",clientsService.getClients(id));
        return "update_clients";
    }
    @PostMapping("/update_clients")
    public String clientUpdate(@ModelAttribute Clients c){
        clientsService.updateClients(c);
        return "redirect:/";
    }
    @GetMapping("/delete_client")
    public String clientDelete(Model model, @RequestParam("id") Integer id){
        clientsService.deleteClients(id);
        return "redirect:/";
    }



}
