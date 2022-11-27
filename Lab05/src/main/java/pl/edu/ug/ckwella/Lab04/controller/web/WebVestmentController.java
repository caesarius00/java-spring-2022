package pl.edu.ug.ckwella.Lab04.controller.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.edu.ug.ckwella.Lab04.domain.LiturgicalVestment;
import pl.edu.ug.ckwella.Lab04.service.LiturgicalVestmentService;

@Controller
public class WebVestmentController {

    private final LiturgicalVestmentService vestmentService;

    public WebVestmentController(@Autowired LiturgicalVestmentService vestmentService) {
        this.vestmentService = vestmentService;
    }

    @GetMapping("/vestment")
    public String vestments(Model model) {
        model.addAttribute("allVestmentsFromDB", vestmentService.getAllVestments());
        return "vestment-all";
    }

    @GetMapping("/vestment/form/{id}")
    public String editVestmentForm(@PathVariable String id, Model model) {
        model.addAttribute("vestmentToAdd", vestmentService.findVestment(id));
        model.addAttribute("whatToDo", "edit/" + id);
        model.addAttribute("buttonName", "Edit");
        return "vestment-edit";
    }

    @PostMapping("/vestment/edit/{id}")
    public String editVestment(@PathVariable String id, @ModelAttribute LiturgicalVestment vestment) {
        vestmentService.editVestment(vestment, id);
        return "redirect:/vestment";
    }


    @GetMapping("/vestment/form")
    public String vestmentAdd(Model model) {
        model.addAttribute("vestmentToAdd", new LiturgicalVestment());
        model.addAttribute("whatToDo", "add");
        model.addAttribute("buttonName", "Add");
        return "vestment-edit";
    }

    @PostMapping("/vestment/add")
    public String addNewVestment(@ModelAttribute LiturgicalVestment vestmentToAdd) {
        vestmentService.addVestment(vestmentToAdd);
        return "redirect:/vestment";
    }

    @GetMapping("/vestment/delete/{id}")
    public String deleteVestment(@PathVariable("id") String id, Model model) {
        if (vestmentService.deleteVestment(id)) {
            model.addAttribute("successMessage", "Operacja się powiodła");
        }
        else {
            model.addAttribute("errorMessage", "Operacja się nie powiodła");
        }
        return "redirect:/vestment";
    }


}

