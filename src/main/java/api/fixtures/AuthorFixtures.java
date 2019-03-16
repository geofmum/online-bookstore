package api.fixtures;

import api.domain.Author;
import api.domain.Book;

import java.util.Random;

public enum AuthorFixtures {
    INSTANCE;
    private final int RECORDS  = 10;

    public void initialize(){
        Random numberGenerator = new Random();

        for(int i = 0; i < RECORDS; i++){
            int randInt = numberGenerator.nextInt(1000);
            Author instance = new Author();

            instance.setName("author-" + randInt);
            instance.save();
        }
    }
}
