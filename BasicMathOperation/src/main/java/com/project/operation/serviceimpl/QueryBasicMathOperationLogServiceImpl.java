package com.project.operation.serviceimpl;

import com.project.operation.model.OperationLogResponses;
import com.project.operation.repository.BasicMathOperationLogRepository;
import com.project.operation.service.QueryBasicMathOperationLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;

import java.util.Collections;

@Service
public class QueryBasicMathOperationLogServiceImpl implements QueryBasicMathOperationLogService {

    @Autowired
    BasicMathOperationLogRepository mathOperationLogRepository;
    /**
     * @param limit  is long for number of operation to be returned
     * @return list of operation based on the limit default 10
     */
    @Override
    public OperationLogResponses getMathOperationLogs(int limit) throws Exception {
        if(limit<=0)
            throw new Exception("Limit should be greater than 0.");
        Query query = new Query();
        query.limit(limit);
        query.with(Sort.by(Sort.Direction.DESC,"executedAt"));
        return OperationLogResponses.builder().size(mathOperationLogRepository.documentSize())
                .result(mathOperationLogRepository.findAllByQuery(query)
                        .orElse(Collections.emptyList())).build();
    }
}
