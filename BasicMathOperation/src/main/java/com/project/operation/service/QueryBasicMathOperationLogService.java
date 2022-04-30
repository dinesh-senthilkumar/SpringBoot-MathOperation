package com.project.operation.service;

import com.project.operation.model.OperationLogResponses;

public interface QueryBasicMathOperationLogService {
    OperationLogResponses getMathOperationLogs(int limit) throws Exception;
}
