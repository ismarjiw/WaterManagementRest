package com.waterquality.waterqualitymanagementrest.api;

import com.waterquality.waterqualitymanagementrest.dto.ReportDto;
import com.waterquality.waterqualitymanagementrest.dto.SensorDataDto;
import com.waterquality.waterqualitymanagementrest.exception.SensorNotFoundException;
import com.waterquality.waterqualitymanagementrest.service.ReportService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api")
@RequiredArgsConstructor
public class ReportController {

    private final ReportService reportService;

    @GetMapping("report/find-sensor/{name}")
    public ReportDto findBySensor(@PathVariable String name)
    {
        try {
            return reportService.getReportByName(name);
        }
        catch (Exception exception)
        {
            throw new SensorNotFoundException("Report for name : "+ name +" Not Found!");
        }

    }

    @GetMapping("report/find-sensor-year/{year}")
    public ReportDto findBySensorYear(@PathVariable String year)
    {
        try {
            return reportService.getSensorDataByYear(year);
        }
        catch (Exception exception)
        {
            throw new SensorNotFoundException("Report for year : "+ year +" Not Found!");
        }
    }

    @GetMapping("report/find-sensor-month/{month}")
    public ReportDto findBySensorMonth(@PathVariable String yearMonth)
    {
        try {
            return reportService.getSensorDataByMonth(yearMonth);
        }
        catch (Exception exception)
        {
            throw new SensorNotFoundException("Report for month : "+ yearMonth +" Not Found!");
        }

    }
}
