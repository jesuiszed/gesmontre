package ma.xproce.gestionmontre.services;

import lombok.AllArgsConstructor;
import ma.xproce.gestionmontre.entities.Order1;
import ma.xproce.gestionmontre.repositories.Order1Repository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service //c'est-à-dire une classe qui contient la logique métier
@AllArgsConstructor

public class Order1ServiceImpl implements Order1Service {
    private Order1Repository  order1Repository;

    @Override
    public Order1 saveOrder1(Order1 order1) {
        return order1Repository.save(order1);
    }

    @Override
    public Order1 updateOrder1(Order1 order1) {
        return order1Repository.save(order1);
    }

    @Override
    public void deleteOrder1ById(Long id) {

        order1Repository.deleteById(id);
    }

    @Override
    public void deleteAllOrder1() {

        order1Repository.deleteAll();
    }

    @Override
    public Order1 getOrder1ById(Long id) {
        return order1Repository.findById(id).get();
    }

    @Override
    public List<Order1> getAllOrder1() {
        return order1Repository.findAll();
    }

    //Modification a faire pour la pagination
    @Override
    public Page<Order1> getAllOrder1ByPage(int page, int size) {
        return order1Repository.findAll(PageRequest.of(page, size));
    }


}

