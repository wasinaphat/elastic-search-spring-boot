package com.wasinapl.elasticsearch.common;

import com.wasinapl.elasticsearch.entitiy.Car;
import com.wasinapl.elasticsearch.repository.CarElasticRepository;
import com.wasinapl.elasticsearch.service.CarService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.ArrayList;

@Component
public class CarElasticDataSource {

    private static final Logger LOG = LoggerFactory.getLogger(CarElasticDataSource.class);

    @Autowired
    private CarElasticRepository carRepository;

    @Autowired
    @Qualifier("randomCarService")
    private CarService carService;

    @Autowired
    @Qualifier("webClientElasticsearch")
    private WebClient webClient;

    @EventListener(ApplicationReadyEvent.class)
    public void populateData(){
       var response = webClient.delete().uri("/practical-java").retrieve().bodyToMono(String.class).block();
       LOG.info("End delete with response {}" ,response);

       var cars = new ArrayList<Car>();

        for (int i = 0; i <100_000 ; i++) {
            cars.add(carService.generateCar());

        }
        carRepository.saveAll(cars);

        LOG.info("Saved  {} cars",carRepository.count());
    }
}
