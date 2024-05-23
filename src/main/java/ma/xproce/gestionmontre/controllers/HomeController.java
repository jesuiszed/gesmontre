package ma.xproce.gestionmontre.controllers;

import lombok.AllArgsConstructor;
import ma.xproce.gestionmontre.entities.*;
import ma.xproce.gestionmontre.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
@Controller
@AllArgsConstructor
public class HomeController {
    @Autowired
    private  montreService montreService;
    @Autowired
    private  categorieService categorieService;
    @Autowired
    private  clientService clientService;
    @Autowired
    private  Order1Service order1Service;
    @Autowired
    private  OrderDetailService orderDetailService;


    @RequestMapping("/home")
    public String home(ModelMap modelMap,
                             @RequestParam(name = "id") Long id,
                             @RequestParam(name ="page",defaultValue = "0")int page,
                            @RequestParam(name ="size",defaultValue = "5")int size) {
        // Suppression de montre
        montreService.deletemontreById(id);

        // Récupération des pages pour chaque entité
        Page<montre> montrePage = montreService.getAllmontreByPage(page, size);
        Page<categorie> categoriePage = categorieService.getAllcategorieByPage(page, size);
        Page<client> clientPage = clientService.getAllclientByPage(page, size);
        Page<Order1> order1Page = order1Service.getAllOrder1ByPage(page, size);
        Page<OrderDetail> orderDetailPage = orderDetailService.getAllOrderDetailByPage(page, size);

        // Ajout des attributs dans le modèle
        modelMap.addAttribute("montres", montrePage);
        modelMap.addAttribute("categories", categoriePage);
        modelMap.addAttribute("clients", clientPage);
        modelMap.addAttribute("orders1", order1Page);
        modelMap.addAttribute("orderDetails", orderDetailPage);

        // Ajout des informations de pagination dans le modèle
        modelMap.addAttribute("montrePages", new int[montrePage.getTotalPages()]);
        modelMap.addAttribute("categoriePages", new int[categoriePage.getTotalPages()]);
        modelMap.addAttribute("clientPages", new int[clientPage.getTotalPages()]);
        modelMap.addAttribute("order1Pages", new int[order1Page.getTotalPages()]);
        modelMap.addAttribute("orderDetailPages", new int[orderDetailPage.getTotalPages()]);

        modelMap.addAttribute("currentPage", page);

        return "home";
    }
}
