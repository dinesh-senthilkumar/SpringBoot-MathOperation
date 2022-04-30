package com.project.operation.service;

import com.project.operation.model.MathOperationModel;

public interface BasicMathOperationService {
    double add(MathOperationModel mathOperationModel);
    double subtract(MathOperationModel mathOperationModel);
    double multiply(MathOperationModel mathOperationModel);
    double divide(MathOperationModel mathOperationModel);
}
