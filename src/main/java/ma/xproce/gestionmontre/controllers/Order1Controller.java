package ma.xproce.gestionmontre.controllers;

import lombok.AllArgsConstructor;
import ma.xproce.gestionmontre.entities.Order1;
import ma.xproce.gestionmontre.services.Order1Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
@AllArgsConstructor
public class Order1Controller {
    @Autowired
    private Order1Service order1Service;

    @RequestMapping("/CreateOrder1")
    public String CreateOrder1() {
        return "CreateOrder1";
    }


    @RequestMapping("saveOrder1")
    public String saveOrder1(@ModelAttribute("Order1Vue") Order1 order1,
                             @RequestParam("createdAt") String submittedDateString) throws ParseException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date dateCreation = dateFormat.parse(submittedDateString);
        order1.setCreatedAt(dateCreation);
        order1Service.saveOrder1(order1);
        return "redirect:Order1List";
    }







    //Modification a faire pour la pagination
    @RequestMapping("/Order1List")
    public String order1List(ModelMap modelMap,
                               @RequestParam(name ="page",defaultValue = "0")int page,
                               @RequestParam(name ="size",defaultValue = "5")int size) {
        Page<Order1> order1Controller = order1Service.getAllOrder1ByPage(page, size);
        modelMap.addAttribute("Order1Vue", order1Controller);
        modelMap.addAttribute("pages",new int[order1Controller.getTotalPages()]);
        modelMap.addAttribute("currentPage",page);
        return "Order1List";
    }

    //Modification a faire pour la pagination

    @RequestMapping("/deleteOrder1")

    public String deleteOrder1(@RequestParam("id") Long id, ModelMap modelMap,
                                 @RequestParam(name ="page",defaultValue = "0")int page,
                                 @RequestParam(name ="size",defaultValue = "5")int size) {
        order1Service.deleteOrder1ById(id);
        Page<Order1> order1Controller = order1Service.getAllOrder1ByPage(page, size);
        modelMap.addAttribute("order1Vue", order1Controller);//Passer les objets du controllers vers la vue
        modelMap.addAttribute("pages",new int[order1Controller.getTotalPages()]);
        modelMap.addAttribute("currentPage",page);
        return "redirect:Order1List";    }



    @RequestMapping("/editOrder1")
    public String editOrder1(@RequestParam("id") Long id, ModelMap modelMap) {
        Order1 order1 = order1Service.getOrder1ById(id);
        modelMap.addAttribute("order1View", order1);
        return "EditeOrder1"; // Assurez-vous que "EditeShoes" est le nom de votre vue JSP pour l'édition de chaussures
    }

    @RequestMapping("updateOrder1")

    public String updateOrder1(

            @ModelAttribute("order1View")  Order1 order1Controller ){

        order1Service.updateOrder1(order1Controller);
        return "redirect:Order1List";

    }



}



