package lt.ku.sporto_klubas.Controller;


import lt.ku.sporto_klubas.Entities.Clients;
import lt.ku.sporto_klubas.Services.ClientsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;


@Controller
@RequestMapping("/clients")
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
        return "clients";
    }
    @GetMapping("/new")
    public String clientNew(Model model){
        model.addAttribute(model.addAttribute("client", new Clients()));
        return "new_client";
    }
    @PostMapping("/new")
    public String addClient(@Valid @ModelAttribute(value = "client") Clients client, BindingResult result, @RequestParam("name") String name, @RequestParam("surname") String surname, @RequestParam("email") String email,
                            @RequestParam("phone")String phone){
        if (result.hasErrors()){
            //model.addAttribute(model.addAttribute("client", new Clients()));
            //model.addAttribute("client", clientsService.getClients(client.getId()));
            return "new_client";
        }else{
        client.setName(name);
        client.setPhone(phone);
        client.setEmail(email);
        client.setSurname(surname);
        //Clients c = new Clients(name,surname,email,phone);
        clientsService.addClients(client);
        return "redirect:/clients/";}
    }
    @GetMapping("/update")
    public String clientNew(@RequestParam("id") Integer id, Model model){
        model.addAttribute("client",clientsService.getClients(id));
        return "update_clients";
    }
    @PostMapping("/update")
    public String clientUpdate(@ModelAttribute Clients c){
        clientsService.updateClients(c);
        return "redirect:/clients/";
    }
    @GetMapping("/delete")
    public String clientDelete(Model model, @RequestParam("id") Integer id){
        clientsService.deleteClients(id);
        return "redirect:/clients/";
    }



}
