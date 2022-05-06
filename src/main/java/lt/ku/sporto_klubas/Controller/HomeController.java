package lt.ku.sporto_klubas.Controller;

import lt.ku.sporto_klubas.Entities.Clients;
import lt.ku.sporto_klubas.Services.ClientsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
@Controller
public class HomeController {
    @Autowired
    ClientsService clientsService;
    @GetMapping("/")
    public String home() {
        //Clients client = new Clients("usr", "wbd", "omgs@gmail.com", "+123","owner","123");
        //client.setType("admin");
        //clientsService.addClients(client);
        return "home";
    }
}
