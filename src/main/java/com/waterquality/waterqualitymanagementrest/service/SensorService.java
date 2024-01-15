package com.waterquality.waterqualitymanagementrest.service;

import com.waterquality.waterqualitymanagementrest.dto.SensorDto;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SensorService
{

    private static List<SensorDto> sensorDtoList = new ArrayList<>();
    public SensorService()
    {
        sensorDtoList.add(new SensorDto(1,"SNS-1",true,"Upper Location"));
        sensorDtoList.add(new SensorDto(2,"SNS-2",true,"Middle Location"));
        sensorDtoList.add(new SensorDto(3,"SNS-3",true,"Lower Location"));
        sensorDtoList.add(new SensorDto(4,"SNS-4",false,"Deactivated Location"));
    }


    public SensorDto getSensorByName(String name)
    {
        return sensorDtoList.stream().filter( e -> e.getName().equals(name)).findFirst().get();
    }

    public SensorDto getSensorById(Long id)
    {
        return sensorDtoList.stream().filter( e -> e.getId() == id).findFirst().get();
    }

    public List<SensorDto> getListSensorData()
    {
        return sensorDtoList;
    }

    public List<SensorDto> getListSensorDataByStatus(boolean status)
    {
        return sensorDtoList.stream().filter(e -> e.isActive() == status).toList();
    }

    public List<SensorDto> add(SensorDto sensorDto)
    {
         sensorDtoList.add(sensorDto);
         return sensorDtoList;
    }

    public List<SensorDto> update(SensorDto sensorDtoUpdate)
    {

        SensorDto sensorDto = getSensorByName(sensorDtoUpdate.getName());


        //delete existing item in the list
        sensorDtoList.remove(sensorDtoList.indexOf(sensorDto));
        //update

        sensorDto.setActive(sensorDtoUpdate.isActive());
        sensorDto.setDescription(sensorDtoUpdate.getDescription());
        sensorDto.setName(sensorDto.getName());

        //insert
        sensorDtoList.add(sensorDto);

        return sensorDtoList;
    }

    public List<SensorDto> delete(String name)
    {

        SensorDto sensorDto = getSensorByName(name);

        //delete existing item in the list
        sensorDtoList.remove(sensorDtoList.indexOf(sensorDto));
        //update

        return sensorDtoList;
    }


    public List<SensorDto> patch(String sensorName, String description)
    {

        SensorDto sensorDto = getSensorByName(sensorName);


        //delete existing item in the list
        sensorDtoList.remove(sensorDtoList.indexOf(sensorDto));
        //update


        sensorDto.setDescription(description);


        //insert
        sensorDtoList.add(sensorDto);

        return sensorDtoList;
    }
}
