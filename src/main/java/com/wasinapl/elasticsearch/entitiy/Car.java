package com.wasinapl.elasticsearch.entitiy;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonUnwrapped;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.*;
import lombok.experimental.Accessors;

import java.time.LocalDate;
import java.util.List;

@Accessors(chain  = true)
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class Car {

    private String brand;

    private String color;

    private String type;

    private int price;

    private  boolean available;

    @JsonFormat(pattern = "dd-MMM-yyyy",timezone = "Asia/Jakarta")
    private LocalDate firstReleaseDate;

    @JsonInclude(value = JsonInclude.Include.NON_EMPTY)
    private List<String> additionalFeatures;

    @JsonInclude(value = JsonInclude.Include.NON_EMPTY)
    private String secretFeature;

    @JsonUnwrapped
    private Engine engine;

    private List<Tire> tires;


}
