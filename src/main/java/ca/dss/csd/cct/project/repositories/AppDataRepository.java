package ca.dss.csd.cct.project.repositories;

import ca.dss.csd.cct.project.entity.AppData;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface AppDataRepository extends MongoRepository<AppData, ObjectId> {

}
