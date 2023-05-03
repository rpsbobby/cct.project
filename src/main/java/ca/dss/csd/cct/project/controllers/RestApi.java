package ca.dss.csd.cct.project.controllers;

import ca.dss.csd.cct.project.entity.Log;
import ca.dss.csd.cct.project.services.AppDataService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class RestApi {

    private AppDataService appDataService;


    @GetMapping("/findAll")
    public List<Log> getLogs() {
        List<Log> logs = new ArrayList<>();
        Log log = new Log();
        log.setMessage("Log one");
        logs.add(log);
        log = new Log();
        log.setMessage("Log Two");
        logs.add(log);
        return logs;
    }

}
