package ca.dss.csd.cct.project.repositories;

import ca.dss.csd.cct.project.entity.Log;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface LogRepository extends MongoRepository<Log, ObjectId> {
}
