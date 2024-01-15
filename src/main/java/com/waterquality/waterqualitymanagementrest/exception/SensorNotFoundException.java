package com.waterquality.waterqualitymanagementrest.exception;

import com.waterquality.waterqualitymanagementrest.dto.SensorDto;

public class SensorNotFoundException extends  RuntimeException
{
    public SensorNotFoundException(String message)
    {
        super(message);
    }
}
