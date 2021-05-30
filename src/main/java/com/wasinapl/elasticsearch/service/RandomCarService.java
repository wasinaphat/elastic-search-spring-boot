package com.wasinapl.elasticsearch.service;

import com.wasinapl.elasticsearch.entitiy.Car;
import com.wasinapl.elasticsearch.entitiy.Engine;
import com.wasinapl.elasticsearch.entitiy.Tire;
import com.wasinapl.elasticsearch.util.RandomDateUtil;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

@Service
public class RandomCarService implements CarService{
    @Override
    public Car generateCar () {
        var brand = BRANDS.get(ThreadLocalRandom.current().nextInt(0,BRANDS.size()));
        var color = COLORS.get(ThreadLocalRandom.current().nextInt(0,COLORS.size()));
        var type = TYPES.get(ThreadLocalRandom.current().nextInt(0,TYPES.size()));

        var available = ThreadLocalRandom.current().nextBoolean();
        var price = ThreadLocalRandom.current().nextInt(5000,12001);
        var firstReleaseDate = RandomDateUtil.generateRandomLocalDate();

        int randomCount = ThreadLocalRandom.current().nextInt(ADDITIONAL_FEATURES.size());
        var additionalFeatures = new ArrayList<String>();

        for (int i = 0; i < randomCount; i++) {

            additionalFeatures.add(ADDITIONAL_FEATURES.get(i));

        }

        var fuel = FUELS.get(ThreadLocalRandom.current().nextInt(FUELS.size()));
        var horsePower = ThreadLocalRandom.current().nextInt(100,221);
        var engine = new Engine();
        engine.setFuelType(fuel).setHorsePower(horsePower);

        var tires = new ArrayList<Tire>();
        for (int i = 0; i < 3; i++) {
            var tire = new Tire();
            var manufacturer = TIRE_MANUFACTURERS.get(ThreadLocalRandom.current().nextInt(TIRE_MANUFACTURERS.size()));
            var size = ThreadLocalRandom.current().nextInt(15,17);
            var tirePrice = ThreadLocalRandom.current().nextInt(200,401);
            tire.setManufacturer(manufacturer).setSize(size).setPrice(tirePrice);
            tires.add(tire);

        }

        var secretFeature = ThreadLocalRandom.current().nextBoolean() ? "Can fly":null;

        return new Car()
                .setSecretFeature(secretFeature)
                .setEngine(engine)
                .setTires(tires)
                .setAdditionalFeatures(additionalFeatures)
                .setType(type).setBrand(brand).setColor(color).setAvailable(available).setPrice(price).setFirstReleaseDate(firstReleaseDate);
    }
}
