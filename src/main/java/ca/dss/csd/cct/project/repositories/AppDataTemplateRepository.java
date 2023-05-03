package ca.dss.csd.cct.project.repositories;

import ca.dss.csd.cct.project.entity.AppData;
import org.springframework.stereotype.Repository;


public interface AppDataTemplateRepository {
    void update(AppData appData);
}
