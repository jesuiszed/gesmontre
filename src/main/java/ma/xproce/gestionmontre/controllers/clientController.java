package ma.xproce.gestionmontre.controllers;

import lombok.AllArgsConstructor;
import ma.xproce.gestionmontre.entities.client;
import ma.xproce.gestionmontre.enums.ClientState;
import ma.xproce.gestionmontre.services.clientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@AllArgsConstructor
public class clientController {
    @Autowired
    private clientService clientService;

    @RequestMapping("/createclient")
    public String creatclient() {
        return "Createclient";
    }

    @RequestMapping("saveclient")
    public String saveclient(

            @ModelAttribute("clientVue") client clientController) {

        clientController.setClientState(ClientState.Active);
          clientService.saveclient(clientController);//Create
        return "Createclient";
    }







    //Modification a faire pour la pagination
    @RequestMapping("/clientList")
    public String categorieList(ModelMap modelMap,
                               @RequestParam(name ="page",defaultValue = "0")int page,
                               @RequestParam(name ="size",defaultValue = "5")int size) {
        Page<client> clientController = clientService.getAllclientByPage(page, size);
        modelMap.addAttribute("clientVue", clientController);
        modelMap.addAttribute("pages",new int[clientController.getTotalPages()]);
        modelMap.addAttribute("currentPage",page);
        return "clientList";
    }

    //Modification a faire pour la pagination

    @RequestMapping("/deleteclient")

    public String deleteclient(@RequestParam("id") Long id, ModelMap modelMap,
                                 @RequestParam(name ="page",defaultValue = "0")int page,
                                 @RequestParam(name ="size",defaultValue = "5")int size) {
        clientService.deleteclientById(id);
        Page<client> clientsController = clientService.getAllclientByPage(page, size);
        modelMap.addAttribute("clientsVue", clientsController);//Passer les objets du controllers vers la vue
        modelMap.addAttribute("pages",new int[clientsController.getTotalPages()]);
        modelMap.addAttribute("currentPage",page);
        return "clientList";
    }





    @RequestMapping("/editclient")

    public String editclient(@RequestParam("id") Long id, ModelMap modelMap){
        client clientController= clientService.getclientById(id);
    modelMap.addAttribute("clientView",clientController);
    return "redirect:clientList";
    }
    @RequestMapping("updateclient")

    public String updateclient(

            @ModelAttribute("clientView")  client clientController ){

        clientService.updateclient(clientController);
        return "redirect:clientList";

    }
}
