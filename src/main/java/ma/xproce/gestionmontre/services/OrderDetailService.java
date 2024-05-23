package ma.xproce.gestionmontre.services;

import ma.xproce.gestionmontre.entities.OrderDetail;
import org.springframework.data.domain.Page;

import java.util.List;

public interface OrderDetailService {
    OrderDetail saveOrderDetail(OrderDetail orderDetail); //"Create" pour créer un nouveau client s'il nexiste pas id
    OrderDetail updateOrderDetail(OrderDetail orderDetail);//"Update"
    void deleteOrderDetailById(Long id);//"Delete by id"
    void deleteAllOrderDetail();//"Delete All"
    OrderDetail getOrderDetailById(Long id); //"Read by id"
    List<OrderDetail> getAllOrderDetail();//"Read All"
    //Modification a faire pour la pagination
    Page<OrderDetail> getAllOrderDetailByPage(int page, int size);

}
