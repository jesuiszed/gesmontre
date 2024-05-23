package ma.xproce.gestionmontre.controllers;

import lombok.AllArgsConstructor;
import ma.xproce.gestionmontre.entities.OrderDetail;
import ma.xproce.gestionmontre.services.OrderDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@AllArgsConstructor
public class OrderDetailController {
    @Autowired
    private OrderDetailService orderDetailService;

    @RequestMapping("/CreateOrderDetail")
    public String CreateOrderDetail() {
        return "CreateOrderDetail";
    }

    @RequestMapping("saveOrderDetail")
    public String saveOrderDetail(@ModelAttribute("OrderDetailVue") OrderDetail orderDetail) {
        orderDetailService.saveOrderDetail(orderDetail);
        return "redirect:OrderDetailList";
    }





    //Modification a faire pour la pagination
    @RequestMapping("/OrderDetailList")
    public String orderDetailList(ModelMap modelMap,
                               @RequestParam(name ="page",defaultValue = "0")int page,
                               @RequestParam(name ="size",defaultValue = "5")int size) {
        Page<OrderDetail> orderDetailController = orderDetailService.getAllOrderDetailByPage(page, size);
        modelMap.addAttribute("OrderDetailVue", orderDetailController);
        modelMap.addAttribute("pages",new int[orderDetailController.getTotalPages()]);
        modelMap.addAttribute("currentPage",page);
        return "OrderDetailList";
    }

    //Modification a faire pour la pagination

    @RequestMapping("/deleteOrderDetail")

    public String deleteOrderDetail(@RequestParam("id") Long id, ModelMap modelMap,
                               @RequestParam(name ="page",defaultValue = "0")int page,
                               @RequestParam(name ="size",defaultValue = "5")int size) {
        orderDetailService.deleteOrderDetailById(id);
        Page<OrderDetail> orderDetailController = orderDetailService.getAllOrderDetailByPage(page, size);
        modelMap.addAttribute("orderDetailVue", orderDetailController);//Passer les objets du controllers vers la vue
        modelMap.addAttribute("pages",new int[orderDetailController.getTotalPages()]);
        modelMap.addAttribute("currentPage",page);
        return "OrderDetailList";}


    @RequestMapping("/editOrderDetail")
    public String editOrderDetail(@RequestParam("id") Long id, ModelMap modelMap) {
        OrderDetail orderDetail = orderDetailService.getOrderDetailById(id);
        modelMap.addAttribute("orderDetailView", orderDetail);
        return "EditeOrderDetail"; // Assurez-vous que "EditeShoes" est le nom de votre vue JSP pour l'édition de chaussures
    }

    @RequestMapping("updateOrderDetail")

    public String updateOrderDetail(

            @ModelAttribute("orderDetailView")  OrderDetail orderDetailController ){

        orderDetailService.updateOrderDetail(orderDetailController);
        return "redirect:OrderDetailList";

    }



}



