package ca.dss.csd.cct.project.services;

import ca.dss.csd.cct.project.entity.AppData;
import ca.dss.csd.cct.project.entity.Log;
import ca.dss.csd.cct.project.entity.MongoUser;
import ca.dss.csd.cct.project.repositories.LogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LogServiceImpl implements LogService{

    private LogRepository repository;

    @Autowired
    public LogServiceImpl(LogRepository repository) {
        this.repository = repository;
    }


    @Override
    public Log save(Log log) {
        return repository.save(log);
    }

    @Override
    public List<Log> findAll() {
        return repository.findAll();
    }

    @Override
    public void logNewUser(MongoUser user) {
        Log log = new Log();
        log.setMessage("New User Created: " + user.getUsername());
        this.save(log);
    }

    @Override
    public void dataEntryUpdated(AppData data) {
        Log log = new Log();
        log.setMessage("Data Entry Updated with ID: " + data.getAppId());
        this.save(log);
    }

    @Override
    public void dataEntryDeleted(String id) {
        Log log = new Log();
        log.setMessage("Data Entry Deleted with ID: " + id);
        this.save(log);
    }
}
