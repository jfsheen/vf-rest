package cc.aisc.business.mongo.vin;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by sjf on 16-11-9.
 */
@Repository
public interface VinLogRepo extends MongoRepository<VinLogDoc, String> {
}
