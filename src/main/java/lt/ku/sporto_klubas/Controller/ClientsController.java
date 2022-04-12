package lt.ku.sporto_klubas.Controller;


import lt.ku.sporto_klubas.Entities.Clients;
import lt.ku.sporto_klubas.Services.ClientsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
public class ClientsController {
    @Autowired
    //ClientsRepository clientsRepository;
    ClientsService clientsService;
    @GetMapping("/")
    public String index(Model model){

       /* Group informatikai = new Group( "informatikai", 2029);
                groupRepository.save(informatikai);*/
        /*Clients ClientOne = new Clients("Darius", "Gyrenas", "Darius.Gyrenas2003@gmail.com","+370609611193");
        clientsRepository.save(ClientOne);
        for (Clients c:clientsRepository.findAll()){
            System.out.println(c.getName() + " "+ c.getSurname() + " " + c.getEmail() + " " + c.getPhone());
        }*/
        model.addAttribute("clients", clientsService.getAllClients());
        return "index";
    }
    @GetMapping("/new_client")
    public String clientNew(Model model){
        return "new_client";
    }
    @PostMapping("/new_client")
    public String addClient(@RequestParam("name") String name, @RequestParam("surname") String surname, @RequestParam("email") String email,
    @RequestParam("phone")String phone){
        Clients c = new Clients(name,surname,email,phone);
        clientsService.addClients(c);
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
