package api.fixtures;

import api.domain.Book;
import api.domain.User;

import java.util.Random;

public enum BookFixtures {
    INSTANCE;
    private final int RECORDS  = 10;

    public void initialize(){
        Random numberGenerator = new Random();

        for(int i = 0; i < RECORDS; i++){
            int randInt = numberGenerator.nextInt(1000);
            Book instance = new Book();

            instance.setISBN("isbn-" + randInt);
            instance.setPrice(90 + randInt);
            instance.setTitle("title-" + randInt);
            instance.setCategory("category" + randInt);
            instance.setYear("1990" + randInt);
            instance.save();
        }
    }
}
