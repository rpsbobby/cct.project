package ca.dss.csd.cct.project.controllers;

import ca.dss.csd.cct.project.entity.AppData;
import ca.dss.csd.cct.project.services.AppDataService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.awt.print.Book;
import java.awt.print.PageFormat;
import java.awt.print.Pageable;
import java.awt.print.Printable;
import java.util.List;

@Controller
@RequestMapping("/data")
public class AppDataController {

    private AppDataService appDataService;

    @Autowired
    public AppDataController(AppDataService appDataService) {
        this.appDataService = appDataService;
    }

    @GetMapping("/")
    public String test() {
        return "hello";
    }
    @GetMapping("/api/")
    public String api() {
        return "hello";
    }


    @GetMapping("/getAll")
    public String getAllData(Model model) {
        List<AppData> data = appDataService.findAll();
        model.addAttribute("dataAll", data);
        return "data/displayData";
    }

    @GetMapping("/updateDataEntry")
    public String updateDataEntry(@RequestParam("id") String id, Model model) {
        AppData data = appDataService.findById(id); // either null or valid
        model.addAttribute("appData", data);
        return "data/dataEntryForm";
    }

    @GetMapping("/deleteDataEntry")
    public String deleteDataEntry(@ModelAttribute("appData")AppData data) {
        appDataService.delete(data.getId().toString());
        return "redirect:/data/getAll";
    }

    @PostMapping("/save")
    public String save(@ModelAttribute("appData") AppData data) {
        appDataService.save(data);
        return "redirect:/data/getAll";
    }
}
