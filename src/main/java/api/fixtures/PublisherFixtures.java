package api.fixtures;

import api.domain.Publisher;

import java.util.Random;

public enum PublisherFixtures {
    INSTANCE;
    private final int RECORDS  = 10;

    public void initialize(){
        Random numberGenerator = new Random();

        for(int i = 0; i < RECORDS; i++){
            int randInt = numberGenerator.nextInt(1000);
            Publisher instance = new Publisher();

            instance.setName("publisher-" + randInt);
            instance.save();
        }
    }
}
