package com.waterquality.waterqualitymanagementrest.service;

import com.waterquality.waterqualitymanagementrest.dto.ReportDto;
import com.waterquality.waterqualitymanagementrest.dto.SensorDataDto;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ReportService {

    private List<ReportDto> reportDtoList = new ArrayList<>();

   public ReportService()
   {
       ReportDto reportDto1 = new ReportDto("billy-bob", "2024", "01", "positive");
       ReportDto reportDto2 = new ReportDto("salinity-1", "2024", "03", "negative");

       reportDtoList.add(reportDto1);
       reportDtoList.add(reportDto2);
   }

    public ReportDto getReportByName(String name) {
        return reportDtoList.stream()
                .filter(e -> e.getSensorName().equals(name))
                .findFirst()
                .orElse(null);
    }

    public ReportDto getSensorDataByYear(String year)
    {
        return reportDtoList.stream().filter(e -> e.getYear().equals(year)).findFirst().get();
    }

    public ReportDto getSensorDataByMonth(String yearMonth)
    {
        return reportDtoList.stream().filter(e -> e.getYearMonth().equals(yearMonth)).findFirst().get();
    }
}
