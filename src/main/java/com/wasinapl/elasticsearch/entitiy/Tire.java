package com.wasinapl.elasticsearch.entitiy;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;
import lombok.experimental.Accessors;

@Accessors(chain  = true)
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class Tire {
    private String manufacturer;
    @JsonProperty(value = "diameter")
    private int size;
    private int price;
}
