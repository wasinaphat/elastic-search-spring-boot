package com.wasinapl.elasticsearch.repository;

import com.wasinapl.elasticsearch.entitiy.Car;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarElasticRepository extends ElasticsearchRepository<Car,String> {
}
