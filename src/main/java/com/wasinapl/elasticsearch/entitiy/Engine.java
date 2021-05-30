package com.wasinapl.elasticsearch.entitiy;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;
import lombok.experimental.Accessors;

@Accessors(chain  = true)
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
@JsonIgnoreProperties(value = {"color","serialNumber"})
public class Engine {
    private String fuelType;
    private int horsePower;
    private String color = "Black";
    private String serialNumber = "SN0000001";
}
