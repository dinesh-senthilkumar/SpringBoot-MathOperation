package com.project.operation.controller;

import com.project.operation.model.MathOperationModel;
import com.project.operation.model.OperationLogResponses;
import com.project.operation.service.BasicMathOperationService;
import com.project.operation.service.QueryBasicMathOperationLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@ControllerAdvice
@RequestMapping("v1/math_operation")
public class BasicMathOperationController {

    @Autowired
    private BasicMathOperationService basicOperationService;

    @Autowired
    private QueryBasicMathOperationLogService queryMathOperationService;

    @PostMapping("/addition")
    public ResponseEntity<Double> add(@RequestBody MathOperationModel mathOperationModel ){
        return ResponseEntity.ok(basicOperationService.add(mathOperationModel));
    }
    @PostMapping("/subtraction")
    public ResponseEntity<Double> subtract(@RequestBody MathOperationModel mathOperationModel ){
        return ResponseEntity.ok(basicOperationService.subtract(mathOperationModel));
    }
    @PostMapping("/multiplication")
    public ResponseEntity<Double> multiply(@RequestBody MathOperationModel mathOperationModel ){
        return ResponseEntity.ok(basicOperationService.multiply(mathOperationModel));
    }
    @PostMapping("/division")
    public ResponseEntity<Double> divide(@RequestBody MathOperationModel mathOperationModel ){
        return ResponseEntity.ok(basicOperationService.divide(mathOperationModel));
    }
    @GetMapping("/get_operation_logs")
    public ResponseEntity<OperationLogResponses> getAllMathOperationLogs(@RequestParam(name="limit",required = false,defaultValue = "10") int limit ) throws Exception {
        return ResponseEntity.ok(queryMathOperationService.getMathOperationLogs(limit));
    }


}
