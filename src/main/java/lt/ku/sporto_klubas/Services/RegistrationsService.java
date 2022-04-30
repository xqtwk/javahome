package lt.ku.sporto_klubas.Services;

import lt.ku.sporto_klubas.Entities.Registrations;
import lt.ku.sporto_klubas.Repositories.RegistrationsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RegistrationsService {
    @Autowired
    RegistrationsRepository registrationsRepository;
    public List<Registrations> getRegistrations(){
        return registrationsRepository.findAll();
    }
    public Registrations getRegistration(Integer id){
        return registrationsRepository.getById(id);
    }
    public Registrations add(Registrations registration){
        return registrationsRepository.save(registration);
    }
    public Registrations update(Registrations registrations){
        Registrations old = this.getRegistration(registrations.getId());
        registrationsRepository.save(old);
        return old;
    }
    public void delete(Integer id){
        registrationsRepository.deleteById(id);
    }
}
