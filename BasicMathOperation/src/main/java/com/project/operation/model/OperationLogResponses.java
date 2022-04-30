package com.project.operation.model;

import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
public class OperationLogResponses {
    private long size;
    private List<MathOperationDto> result;
}
