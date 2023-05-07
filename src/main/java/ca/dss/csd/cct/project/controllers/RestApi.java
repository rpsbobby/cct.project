package ca.dss.csd.cct.project.controllers;

import ca.dss.csd.cct.project.entity.Log;
import ca.dss.csd.cct.project.services.AppDataService;
import ca.dss.csd.cct.project.services.LogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class RestApi {

    private LogService logs;

    @Autowired
    public RestApi(LogService logs) {
        this.logs = logs;
    }




    @GetMapping("/findAll")
    public List<Log> getLogs() {
        return logs.findAll();
    }

}

