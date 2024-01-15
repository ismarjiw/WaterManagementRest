package com.waterquality.waterqualitymanagementrest.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
@AllArgsConstructor
public class ReportDto
{
    private String sensorName;

    private String year;

    private String yearMonth;

    private String result;

}
