package ma.xproce.gestionmontre.services;

import lombok.AllArgsConstructor;
import ma.xproce.gestionmontre.entities.OrderDetail;
import ma.xproce.gestionmontre.repositories.OrderDetailRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service //c'est-à-dire une classe qui contient la logique métier
@AllArgsConstructor

public class OrderDetailServiceImpl implements OrderDetailService {
    private OrderDetailRepository orderDetailRepository;

    @Override
    public OrderDetail saveOrderDetail(OrderDetail orderDetail) {
        return orderDetailRepository.save(orderDetail);
    }

    @Override
    public OrderDetail updateOrderDetail(OrderDetail orderDetail) {
        return orderDetailRepository.save(orderDetail);
    }

    @Override
    public void deleteOrderDetailById(Long id) {

        orderDetailRepository.deleteById(id);
    }

    @Override
    public void deleteAllOrderDetail() {

        orderDetailRepository.deleteAll();
    }

    @Override
    public OrderDetail getOrderDetailById(Long id) {
        return orderDetailRepository.findById(id).get();
    }

    @Override
    public List<OrderDetail> getAllOrderDetail() {
        return orderDetailRepository.findAll();
    }

    //Modification a faire pour la pagination
    @Override
    public Page<OrderDetail> getAllOrderDetailByPage(int page, int size) {
        return orderDetailRepository.findAll(PageRequest.of(page, size));
    }
}
