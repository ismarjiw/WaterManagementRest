package com.waterquality.waterqualitymanagementrest.advice;

import com.waterquality.waterqualitymanagementrest.dto.ErrorMessage;
import com.waterquality.waterqualitymanagementrest.exception.SensorNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.Date;

@RestControllerAdvice
public class RestControllerExceptionHandler
{
    @ExceptionHandler(SensorNotFoundException.class)
    @ResponseStatus(value = HttpStatus.NOT_FOUND)
    public ErrorMessage sensorNotFoundException(SensorNotFoundException sensorNotFoundException)
    {
        ErrorMessage errorMessage = new ErrorMessage(HttpStatus.NOT_FOUND.value(), new Date(),sensorNotFoundException.getMessage());

        return errorMessage;
    }

}
