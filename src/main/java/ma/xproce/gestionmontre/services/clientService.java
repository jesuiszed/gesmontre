package ma.xproce.gestionmontre.services;

import ma.xproce.gestionmontre.entities.client;
import org.springframework.data.domain.Page;

import java.util.List;

public interface clientService {
    client saveclient(client client); //"Create" pour créer un nouveau client s'il nexiste pas id
    client updateclient(client client);//"Update"
    void deleteclientById(Long id);//"Delete by id"
    void deleteAllclients();//"Delete All"
    client getclientById(Long id); //"Read by id"
    List<client> getAllclients();//"Read All"
    //Modification a faire pour la pagination
    Page<client> getAllclientByPage(int page, int size);
}
