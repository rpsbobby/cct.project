package ca.dss.csd.cct.project.controllers;

import ca.dss.csd.cct.project.entity.AppData;
import ca.dss.csd.cct.project.repositories.AppDataTemplateRepository;
import ca.dss.csd.cct.project.services.AppDataService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Optionals;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.awt.print.Book;
import java.awt.print.PageFormat;
import java.awt.print.Pageable;
import java.awt.print.Printable;
import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Controller
@RequestMapping("/data")
public class AppDataController {

    private AppDataService appDataService;
    private AppDataTemplateRepository appDataTemplateRepository;
    private int currentPage = 1; // default

    @Autowired
    public AppDataController(AppDataService appDataService, AppDataTemplateRepository appDataTemplateRepository) {
        this.appDataService = appDataService;
        this.appDataTemplateRepository = appDataTemplateRepository;
    }


    @GetMapping("/getAll")
    public String getAllData(@RequestParam(name = "page", required = false , defaultValue = "first") String page, Model model) {
        int currentPage = getPageNumber(page);
        List<AppData> data = appDataService.findAll(currentPage);
        model.addAttribute("dataAll", data);
        return "data/displayData";
    }

    private int getPageNumber(String page) {
        if (page.equals("first")){
            currentPage = 1;
        } else  if(page.equals("next")) {
            currentPage++;
        }
        if(page.equals("previous")){
            if(currentPage - 1 < 1){
                currentPage = 1;
            } else {
                currentPage--;
            }
        }
        return currentPage;
    }

    @GetMapping("/updateDataEntry")
    public String updateDataEntry(@RequestParam("id") String id, Model model) {
        AppData data = appDataService.findById(id); // either null or valid
        model.addAttribute("appData", data);
        return "data/dataEntryForm";
    }

    @GetMapping("/deleteDataEntry")
    public String deleteDataEntry(@ModelAttribute("appData")AppData data) {
        appDataService.delete(data.getId());
        return "redirect:/data/getAll";
    }

    @PostMapping("/save")
    public String save(@Valid @ModelAttribute("appData") AppData data, BindingResult bindingResult, Model model) {
        if(bindingResult.hasErrors()) {
            return "data/dataEntryForm";
        }
        appDataTemplateRepository.update(data);
        return "redirect:/data/getAll";
    }
}
