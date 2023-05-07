package ca.dss.csd.cct.project.services;

import ca.dss.csd.cct.project.entity.AppData;
import ca.dss.csd.cct.project.entity.Log;
import ca.dss.csd.cct.project.entity.MongoUser;

import java.util.List;

public interface LogService {
    Log save(Log log);
    List<Log> findAll();
    void logNewUser(MongoUser user);
    void dataEntryUpdated(AppData data);
    void dataEntryDeleted(String id);
}
