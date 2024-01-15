package com.waterquality.waterqualitymanagementrest.api;

import com.waterquality.waterqualitymanagementrest.dto.ErrorMessage;
import com.waterquality.waterqualitymanagementrest.dto.SensorDto;
import com.waterquality.waterqualitymanagementrest.exception.SensorNotFoundException;
import com.waterquality.waterqualitymanagementrest.service.SensorService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("api")
@RequiredArgsConstructor
public class SensorController
{
     private final SensorService sensorService;

     @GetMapping("sensor/{id}")
     public SensorDto retrievet_pv(@PathVariable Long id)
     {
          try{
          return sensorService.getSensorById(id);
          }
          catch (Exception exception)
          {
              throw new SensorNotFoundException("Sensor Data for id : "+ id +" Not Found!");
          }

     }

     @GetMapping("sensor")
     public SensorDto retrievet_rp(@RequestParam(name = "iSensorname") String kensParameter)
     {
          try {
               return sensorService.getSensorByName(kensParameter);
          }
          catch (Exception exception)
          {
               throw new SensorNotFoundException("Sensor Data for name : "+ kensParameter +" Not Found!");
          }
     }


     @GetMapping("sensor/all")
     public List<SensorDto> listAllSensors()
     {
          return sensorService.getListSensorData();
     }

     @GetMapping("sensor/list")
     public List<SensorDto> listAllSensorsByStatus(@RequestParam(name = "status") boolean status)
     {
          return sensorService.getListSensorDataByStatus(status);
     }

     @PostMapping("sensor")
     public List<SensorDto> add(@RequestBody SensorDto sensorDto)
     {
          return sensorService.add(sensorDto);
     }

     @PutMapping("sensor")
     public List<SensorDto> update(@RequestBody SensorDto sensorDto)
     {
          return sensorService.update(sensorDto);
     }
//
//     @PatchMapping("sensor")
//     public List<SensorDto> update_partially(@RequestBody SensorDto sensorDto)
//     {
//          return sensorService.update(sensorDto);
//     }

     @DeleteMapping("sensor/{name}")
     public List<SensorDto> delete(@PathVariable String name)
     {
          return sensorService.delete(name);
     }

     @PatchMapping("sensor")
     public List<SensorDto> patch(@RequestParam(name="sensorName") String name, @RequestParam String description)
     {
          return sensorService.patch(name, description);
     }


}
