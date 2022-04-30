package com.project.operation.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Document(collection = "operations")
@Data
@Builder
public class MathOperationDto {
    @Id
    private String requestId;
    private String operation;
    private long executedAt;
    private MathOperationModel input;
    private double output;

}
