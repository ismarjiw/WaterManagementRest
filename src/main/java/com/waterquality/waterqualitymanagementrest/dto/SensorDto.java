package com.waterquality.waterqualitymanagementrest.dto;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class SensorDto {

    private long id;

    private String name;

    private boolean active;

    private String description;

}
