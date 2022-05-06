package lt.ku.sporto_klubas.Services;

import org.springframework.beans.factory.annotation.Autowired;
import lt.ku.sporto_klubas.Entities.Clients;
import lt.ku.sporto_klubas.Repositories.ClientsRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ClientsService implements UserDetailsService {
    @Autowired
    ClientsRepository clientsRepository;

    public Clients addClients(Clients client){
        client.setPassword((new BCryptPasswordEncoder()).encode(client.getPassword()));
        return clientsRepository.save(client);
    }
    public Clients updateClients(Clients client){
        Clients old = clientsRepository.getById(client.getId());
        old.setName(client.getName());
        old.setSurname(client.getSurname());
        old.setEmail(client.getEmail());
        old.setPhone(client.getPhone());
        clientsRepository.save(old);
        return old;
    }
    public void deleteClients( Integer id){
        clientsRepository.deleteById(id);
    }
    public Clients getClients(Integer id){
        return clientsRepository.getById(id);
    }
    public List<Clients> getAllClients() { return clientsRepository.findAll(); }


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Clients client = clientsRepository.findByUsername(username);
        if (client==null) {
            throw new UsernameNotFoundException("Vartotojas nerastas");
        }
        return client;
    }
}
