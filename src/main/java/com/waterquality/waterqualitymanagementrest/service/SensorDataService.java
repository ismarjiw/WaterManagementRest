package com.waterquality.waterqualitymanagementrest.service;

import com.waterquality.waterqualitymanagementrest.dto.ParameterDto;
import com.waterquality.waterqualitymanagementrest.dto.SensorDataDto;
import com.waterquality.waterqualitymanagementrest.dto.SensorDto;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SensorDataService
{
    private List<SensorDataDto> sensorDataDtoList = new ArrayList<>();
    public SensorDataService()
    {
        //prepare sensor
        SensorDto sensorDto = new SensorDto(1,"SNS-1",true,"Upper Location");
        SensorDto sensorDto2 =  new SensorDto(2,"SNS-2",true,"Middle Location");

        //prepare parameter

        ParameterDto parameterDto = new ParameterDto(1l,"pH");
        ParameterDto parameterDto2 = new ParameterDto(2l,"Ca");

        //prepare sensor data dto

        SensorDataDto sensorDataDto = new SensorDataDto(1l,sensorDto,parameterDto,"2024","01",2.5);
        SensorDataDto sensorDataDto2 = new SensorDataDto(2l,sensorDto2,parameterDto2,"2024","01",5.6);

        sensorDataDtoList.add(sensorDataDto);
        sensorDataDtoList.add(sensorDataDto2);
    }

    public SensorDataDto getSensorDataById(Long id)
    {
        return sensorDataDtoList.stream().filter(e -> e.getId() == id).findFirst().get();
    }

    public SensorDataDto getSensorDataByName(String name) {
        return sensorDataDtoList.stream()
                .filter(e -> e.getSensor().getName().equals(name))
                .findFirst()
                .orElse(null);
    }

    public SensorDataDto getSensorDataByYear(String year)
    {
        return sensorDataDtoList.stream().filter(e -> e.getYear().equals(year)).findFirst().get();
    }

    public SensorDataDto getSensorDataByMonth(String month)
    {
        return sensorDataDtoList.stream().filter(e -> e.getMonth().equals(month)).findFirst().get();
    }

    public List<SensorDataDto> addNewSensorData(SensorDataDto sensorDataDto) {
        // Check for duplicate entry by ID
        if (sensorDataDtoList.stream().anyMatch(e -> e.getId() == (sensorDataDto.getId()))) {
            throw new RuntimeException("Sensor data with the same ID already exists.");
        }

        // Add new sensor data
        sensorDataDtoList.add(sensorDataDto);

        return new ArrayList<>(sensorDataDtoList);
    }


    public List<SensorDataDto> update(SensorDataDto updatedSensorDataDto) {
        for (int i = 0; i < sensorDataDtoList.size(); i++) {
            SensorDataDto existingSensorDataDto = sensorDataDtoList.get(i);
            if (existingSensorDataDto.getId() == updatedSensorDataDto.getId()) {
                // Replace the existing sensor with the updated one
                sensorDataDtoList.set(i, updatedSensorDataDto);
                break;  // Break the loop once the update is done
            }
        }
        return new ArrayList<>(sensorDataDtoList);
    }

    public List<SensorDataDto> deleteSensorById(long sensorId) {
        sensorDataDtoList.removeIf(sensorDataDto -> sensorDataDto.getId() == sensorId);
        return new ArrayList<>(sensorDataDtoList);
    }


}
