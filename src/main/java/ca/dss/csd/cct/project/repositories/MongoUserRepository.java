package ca.dss.csd.cct.project.repositories;

import ca.dss.csd.cct.project.entity.MongoUser;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;



public interface MongoUserRepository extends MongoRepository<MongoUser, ObjectId> {
    MongoUser findByUsername(String username);
}