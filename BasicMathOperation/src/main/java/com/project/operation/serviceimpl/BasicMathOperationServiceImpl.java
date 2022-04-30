package com.project.operation.serviceimpl;

import com.project.operation.model.MathOperationDto;
import com.project.operation.model.MathOperationModel;
import com.project.operation.repository.BasicMathOperationLogRepository;
import com.project.operation.service.BasicMathOperationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.UUID;

@Service
public class BasicMathOperationServiceImpl implements BasicMathOperationService {

    @Autowired
    private BasicMathOperationLogRepository mathOperationLogRepository;
    /**
     * @param mathOperationModel has  number1 and number2 is double datatype
     * @return Addition of number1 and Number2 and it returns double
     */
    @Override
    public double add(MathOperationModel mathOperationModel ) {
        double result = mathOperationModel.getNumber1() + mathOperationModel.getNumber2();
        saveOperationLog("ADD",mathOperationModel,result);
        return result;
    }

    /**
     * @param mathOperationModel has  number1 and number2 is double datatype
     * @return subtract of number1 and Number2 and it returns double
     */
    @Override
    public double subtract(MathOperationModel mathOperationModel ) {
        double result = mathOperationModel.getNumber1() - mathOperationModel.getNumber2();
        saveOperationLog("SUB",mathOperationModel,result);
        return result;
    }

    /**
     * @param mathOperationModel has  number1 and number2 is double datatype
     * @return multiply of number1 and Number2 and it returns double
     */
    @Override
    public double multiply(MathOperationModel mathOperationModel ) {
        double result = mathOperationModel.getNumber1() * mathOperationModel.getNumber2();
        saveOperationLog("MUL",mathOperationModel,result);
        return result;
    }

    /**
     * @param mathOperationModel has  number1 and number2 is double datatype
     * @return divide of number1 and Number2 and it returns double
     */
    @Override
    public double divide(MathOperationModel mathOperationModel ) {
        double result = mathOperationModel.getNumber1() / mathOperationModel.getNumber2();
        saveOperationLog("DIV",mathOperationModel,result);
        return result;
    }


    private void  saveOperationLog(String operation,MathOperationModel input,double output){
        long executedAt = new Date().toInstant().toEpochMilli();
        String requestId = UUID.randomUUID().toString();
        MathOperationDto mathOperationDto = MathOperationDto.builder().operation(operation).executedAt(executedAt)
                .requestId(requestId).input(input).output(output).build();
        mathOperationLogRepository.save(mathOperationDto);
    }
}
