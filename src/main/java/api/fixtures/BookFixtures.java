package api.fixtures;

import api.domain.Author;
import api.domain.Book;
import api.domain.Publisher;
import api.domain.User;
import api.domain.query.QAuthor;
import api.domain.query.QPublisher;

import java.util.Random;

public enum BookFixtures {
    INSTANCE;
    private final int RECORDS = 10;

    public void initialize() {
        Random numberGenerator = new Random();

        for (int i = 0; i < RECORDS; i++) {
            int randInt = numberGenerator.nextInt(1000);
            Book instance = new Book();
            Author author = new QAuthor().id.eq(i + 1).findOne();
            Publisher publisher = new QPublisher().id.eq(i + 1).findOne();

            instance.addAuthors(author);
            instance.addPublishers(publisher);
            instance.setISBN("isbn-" + randInt);
            instance.setPrice(90 + randInt);
            instance.setTitle("title-" + randInt);
            instance.setCategory("category" + randInt);
            instance.setYear("1990" + randInt);
            instance.save();
        }
    }
}
