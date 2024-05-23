package ma.xproce.gestionmontre.services;

import lombok.AllArgsConstructor;
import ma.xproce.gestionmontre.entities.client;
import ma.xproce.gestionmontre.repositories.clientRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service //c'est-à-dire une classe qui contient la logique métier
@AllArgsConstructor

public class clientServiceImpl implements clientService {

    private clientRepository clientRepository; // pour interagir avec la base de données.
    @Override
    public client saveclient(client client) {
        return clientRepository.save(client);
    }

    @Override
    public client updateclient(client client) {
        return clientRepository.save(client);
    }

    @Override
    public void deleteclientById(Long id) {
        clientRepository.deleteById(id);
    }

    @Override
    public void deleteAllclients() {
        clientRepository.deleteAll();
    }

    @Override
    public client getclientById(Long id) {
        return clientRepository.findById(id).get();
    }

    @Override
    public List<client> getAllclients() {
        return clientRepository.findAll();
    }

    //Modification a faire pour la pagination
    @Override
    public Page<client> getAllclientByPage(int page, int size) {
        return clientRepository.findAll(PageRequest.of(page, size));
    }
}
