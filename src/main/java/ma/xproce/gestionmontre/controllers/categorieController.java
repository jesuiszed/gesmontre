package ma.xproce.gestionmontre.controllers;

import lombok.AllArgsConstructor;
import ma.xproce.gestionmontre.entities.categorie;
import ma.xproce.gestionmontre.services.categorieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@AllArgsConstructor
public class categorieController {
    @Autowired
    private categorieService categorieService;

    @RequestMapping("/Createcategorie")
    public String Createcategorie() {
        return "Createcategorie";
    }

    @RequestMapping("savecategorie")
    public String savecategorie(@ModelAttribute("categorieVue") categorie categorie) {
        categorieService.savecategorie(categorie);
        return "redirect:categorieList";
    }


    //Modification a faire pour la pagination
    @RequestMapping("/categorieList")
    public String categorieList(ModelMap modelMap,
                             @RequestParam(name ="page",defaultValue = "0")int page,
                             @RequestParam(name ="size",defaultValue = "5")int size) {
        Page<categorie> categorieController = categorieService.getAllcategorieByPage(page, size);
        modelMap.addAttribute("categorieVue", categorieController);
        modelMap.addAttribute("pages",new int[categorieController.getTotalPages()]);
        modelMap.addAttribute("currentPage",page);
        return "categorieList";
    }






    //Modification a faire pour la pagination

    @RequestMapping("/deletecategorie")

    public String deletecategorie(@RequestParam("id") Long id, ModelMap modelMap,
                                 @RequestParam(name ="page",defaultValue = "0")int page,
                                 @RequestParam(name ="size",defaultValue = "5")int size) {
        categorieService.deletecategorieById(id);
        Page<categorie> categorieController = categorieService.getAllcategorieByPage(page, size);
        modelMap.addAttribute("categorieVue", categorieController);//Passer les objets du controllers vers la vue
        modelMap.addAttribute("pages",new int[categorieController.getTotalPages()]);
        modelMap.addAttribute("currentPage",page);
        return "categorieList";
    }








    @RequestMapping("/editcategorie")
    public String editcategorie(@RequestParam("id") Long id, ModelMap modelMap) {
        categorie categorie = categorieService.getcategorieById(id);
        modelMap.addAttribute("categorieView", categorie);
        return "Editecategorie"; // Assurez-vous que "EditeShoes" est le nom de votre vue JSP pour l'édition de chaussures
    }

    @RequestMapping("updatecategorie")

    public String updatecategorie(

            @ModelAttribute("categorieView")  categorie categorieController ){

        categorieService.updatecategorie(categorieController);
        return "redirect:categorieList";

    }



}



