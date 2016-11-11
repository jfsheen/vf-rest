package cc.aisc.business.mongo;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by sjf on 16-10-14.
 */
@Repository
public interface DocModelRepo extends MongoRepository<DocModel, String> {
}
