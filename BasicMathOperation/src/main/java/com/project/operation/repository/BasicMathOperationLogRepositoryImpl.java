package com.project.operation.repository;

import com.project.operation.model.MathOperationDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class BasicMathOperationLogRepositoryImpl implements BasicMathOperationLogRepository {

    @Autowired
    private MongoTemplate mongoTemplate;


    /**
     * @param query
     * @return
     */
    @Override
    public Optional<List<MathOperationDto>> findAllByQuery(Query query) {
        return Optional.of(mongoTemplate.find(query,MathOperationDto.class));
    }

    /**
     * @param mathOperationDto
     */
    @Override
    public void save(MathOperationDto mathOperationDto) {

        mongoTemplate.save(mathOperationDto);

    }

    /**
     * @return
     */
    @Override
    public long documentSize() {
        Query query = new Query();
        return  mongoTemplate.count(query,MathOperationDto.class);
    }
}
