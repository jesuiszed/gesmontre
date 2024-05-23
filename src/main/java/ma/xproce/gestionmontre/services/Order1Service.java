package ma.xproce.gestionmontre.services;

import ma.xproce.gestionmontre.entities.Order1;
import org.springframework.data.domain.Page;

import java.util.List;

public interface Order1Service {
    Order1 saveOrder1(Order1 order1); //"Create" pour créer un nouveau client s'il nexiste pas id
    Order1 updateOrder1(Order1 order1);//"Update"
    void deleteOrder1ById(Long id);//"Delete by id"
    void deleteAllOrder1();//"Delete All"
    Order1 getOrder1ById(Long id); //"Read by id"
    List<Order1> getAllOrder1();//"Read All"
    //Modification a faire pour la pagination
    Page<Order1> getAllOrder1ByPage(int page, int size);
}
