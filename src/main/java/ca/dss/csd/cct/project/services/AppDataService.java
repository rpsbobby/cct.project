package ca.dss.csd.cct.project.services;

import ca.dss.csd.cct.project.entity.AppData;
import org.bson.types.ObjectId;

import java.util.List;

public interface AppDataService {

    List<AppData> findAll();
    List<AppData> findAll(int pageNumber);

    //    List<AppData> findAll(Integer pageNo);
    AppData findById(String id);

    void update(AppData appData);

    AppData save(AppData appData);

    void delete(ObjectId id);
//    Page<AppData> getNextPage(int pageNo, int pageSize);

}
