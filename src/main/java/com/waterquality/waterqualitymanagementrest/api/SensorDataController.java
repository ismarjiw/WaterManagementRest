package com.waterquality.waterqualitymanagementrest.api;

import com.waterquality.waterqualitymanagementrest.dto.ParameterDto;
import com.waterquality.waterqualitymanagementrest.dto.SensorDataDto;
import com.waterquality.waterqualitymanagementrest.dto.SensorDto;
import com.waterquality.waterqualitymanagementrest.entity.Sensor;
import com.waterquality.waterqualitymanagementrest.exception.SensorNotFoundException;
import com.waterquality.waterqualitymanagementrest.service.SensorDataService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("api")
@RequiredArgsConstructor
public class SensorDataController
{
    private final SensorDataService sensorDataService;

    @GetMapping("sensordata/{id}")
    public SensorDataDto findById(@PathVariable Long id)
    {
        try {
            return sensorDataService.getSensorDataById(id);
        }
        catch (Exception exception)
        {
            throw new SensorNotFoundException("SensorData for id : "+ id +" Not Found!");
        }

    }

//    http://localhost:8080/api/sensordata/add-sensor
//    request body:
    // {
    //    "id": 4,
    //        "sensor": {
    //    "id": 4,
    //            "name": "SNS-4",
    //            "active": true,
    //            "description": "Middle Location"
    // },
    //    "parameter": {
    //    "id": 4,
    //            "name": "H"
    // },
    //    "year": "2024",
    //        "month": "01",
    //        "parameterValue": 12.6
    // }
    @PostMapping("/sensordata/add-sensor")
    public List<SensorDataDto> addNewSensor(
            @RequestBody SensorDataDto sensorDataDto
    ) {
        return sensorDataService.addNewSensorData(sensorDataDto);
    }

//    http://localhost:8080/api/sensordata/find-sensor/SNS-2
    @GetMapping("sensordata/find-sensor/{name}")
    public SensorDataDto findBySensor(@PathVariable String name)
    {
        try {
            return sensorDataService.getSensorDataByName(name);
        }
        catch (Exception exception)
        {
            throw new SensorNotFoundException("SensorData for name : "+ name +" Not Found!");
        }

    }

//    http://localhost:8080/api/sensordata/find-sensor-year/2024
    @GetMapping("sensordata/find-sensor-year/{year}")
    public SensorDataDto findBySensorYear(@PathVariable String year)
    {
        try {
            return sensorDataService.getSensorDataByYear(year);
        }
        catch (Exception exception)
        {
            throw new SensorNotFoundException("SensorData for year : "+ year +" Not Found!");
        }

    }

//    http://localhost:8080/api/sensordata/find-sensor-month/03
    @GetMapping("sensordata/find-sensor-month/{month}")
    public SensorDataDto findBySensorMonth(@PathVariable String month)
    {
        try {
            return sensorDataService.getSensorDataByMonth(month);
        }
        catch (Exception exception)
        {
            throw new SensorNotFoundException("SensorData for month : "+ month +" Not Found!");
        }

    }

//    http://localhost:8080/api/sensordata/update-sensor
    @PutMapping("sensordata/update-sensor")
    public List<SensorDataDto> updateSensor(@RequestBody SensorDataDto updatedSensorDataDto) {
        return sensorDataService.update(updatedSensorDataDto);
    }

//    http://localhost:8080/api/sensordata/delete-sensor/1
    @DeleteMapping("sensordata/delete-sensor/{id}")
    public List<SensorDataDto> deleteSensor(@PathVariable long id) {
        return sensorDataService.deleteSensorById(id);
    }


}
