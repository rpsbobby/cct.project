package ca.dss.csd.cct.project.repositories;

import ca.dss.csd.cct.project.entity.AppData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.*;
import org.springframework.stereotype.Repository;

@Repository
public class AppDataTemplateRepositoryImpl implements AppDataTemplateRepository {
    // documentation available at: https://docs.spring.io/spring-data/mongodb/docs/current/api/org/springframework/data/mongodb/core/MongoTemplate.html

    private MongoTemplate template;

    @Autowired
    public AppDataTemplateRepositoryImpl(MongoTemplate template) {
        this.template = template;
    }


    @Override
    public void update(AppData appData) {
        // create query with criteria -> id
        Query query = new Query().addCriteria(Criteria.where("_id").is(appData.getAppId()));
        // replace
        template.findAndReplace(query,appData);
    }

}
