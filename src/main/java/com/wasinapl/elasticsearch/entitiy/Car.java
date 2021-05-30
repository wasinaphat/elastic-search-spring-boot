package com.wasinapl.elasticsearch.entitiy;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonUnwrapped;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.*;
import lombok.experimental.Accessors;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.DateFormat;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

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
@Document(indexName = "practical-java")
public class Car {

    @Id
    private String id;

    private String brand;

    private String color;

    private String type;

    private int price;

    private  boolean available;

    @Field(type = FieldType.Date,format = DateFormat.date)
    @JsonFormat(pattern = "yyyy-MM-dd",timezone = "Asia/Jakarta")
    private LocalDate firstReleaseDate;

    @JsonInclude(value = JsonInclude.Include.NON_EMPTY)
    private List<String> additionalFeatures;

    @JsonInclude(value = JsonInclude.Include.NON_EMPTY)
    private String secretFeature;

    @JsonUnwrapped
    private Engine engine;

    private List<Tire> tires;


}
