package com.project.operation.repository;

import com.project.operation.model.MathOperationDto;
import org.springframework.data.mongodb.core.query.Query;

import java.util.List;
import java.util.Optional;

public interface BasicMathOperationLogRepository {
    Optional<List<MathOperationDto>> findAllByQuery(Query query);
    void save(MathOperationDto mathOperationDto);

    long documentSize();

}
