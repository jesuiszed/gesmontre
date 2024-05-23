package ma.xproce.gestionmontre.controllers;

import lombok.AllArgsConstructor;
import ma.xproce.gestionmontre.entities.*;
import ma.xproce.gestionmontre.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@AllArgsConstructor
public class montreController {
    @Autowired
    private  montreService montreService;
    @Autowired
    private  categorieService categorieService;
    @Autowired
    private ma.xproce.gestionmontre.services.clientService clientService;
    @Autowired
    private Order1Service order1Service;
    @Autowired
    private OrderDetailService orderDetailService;
    @RequestMapping("/Createmontre")
    public String Createmontre() {
        return "Createmontre";
    }

    @RequestMapping("/savemontre")
    public String savemontre(@ModelAttribute("montreVue") montre montre) {
        montreService.savemontre(montre);
        return "redirect:montreList";
    }




    //Modification a faire pour la pagination
    @RequestMapping("/montreList")
    public String montreList(ModelMap modelMap,
                             @RequestParam(name ="page",defaultValue = "0")int page,
                             @RequestParam(name ="size",defaultValue = "5")int size) {
        Page<montre> montreController = montreService.getAllmontreByPage(page, size);
        modelMap.addAttribute("montreVue", montreController);
        modelMap.addAttribute("pages",new int[montreController.getTotalPages()]);
        modelMap.addAttribute("currentPage",page);
        return "montreList";
    }

    @RequestMapping("/")
    public String montrList(ModelMap modelMap,
                             @RequestParam(name ="page",defaultValue = "0")int page,
                             @RequestParam(name ="size",defaultValue = "5")int size) {
        // Suppression de montre

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

    //Modification a faire pour la pagination

    @RequestMapping("/deletemontre")

    public String deletemontre(@RequestParam("id") Long id, ModelMap modelMap,
                                    @RequestParam(name ="page",defaultValue = "0")int page,
                                    @RequestParam(name ="size",defaultValue = "5")int size) {
        montreService.deletemontreById(id);
        Page<montre> montreController = montreService.getAllmontreByPage(page, size);
        modelMap.addAttribute("montreVue", montreController);//Passer les objets du controllers vers la vue
        modelMap.addAttribute("pages",new int[montreController.getTotalPages()]);
        modelMap.addAttribute("currentPage",page);
        return "montreList";}




    @RequestMapping("/editmontre")
    public String editmontre(@RequestParam("id") Long id, ModelMap modelMap) {
        montre montre = montreService.getmontreById(id);
        modelMap.addAttribute("montreView", montre);
        return "Editemontre"; // Assurez-vous que "EditeShoes" est le nom de votre vue JSP pour l'édition de chaussures
    }

    @RequestMapping("updatemontre")

    public String updatemontre(

            @ModelAttribute("montreView") montre montreController){

        montreService.updatemontre(montreController);
        return "redirect:montreList";

    }


}



