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
    private final int RECORDS = 20;

    public void initialize() {
        Random numberGenerator = new Random();
        String[] category=new String[]{"Drama","Fantasy","Romance","Best Seller","Science"};
        String[] description=new String[]{
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit",
                "sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.",
                "Ut enim ad minim veniam, quis nostrud",
                "exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat."
        };
        for (int i = 0; i < RECORDS; i++) {
            int randInt = numberGenerator.nextInt(1000);

            Book instance = new Book();
            Author author = new QAuthor().id.eq((i%10) + 1).findOne();
            Publisher publisher = new QPublisher().id.eq((i%5) + 1).findOne();

            instance.addAuthors(author);
            instance.addPublishers(publisher);
            instance.setISBN("isbn-" + randInt);
            instance.setPrice(10 + randInt);
            instance.setTitle("title-" + randInt);
            instance.setDescription(description[randInt%4]);
            instance.setCategory(category[i%5] );
            instance.setYear("1990" + randInt);
            if(i<5)instance.setDiscount(10);
            instance.setThumb_url("/resources/images/book" + (i%10 + 1) + ".jpg");
//            instance.setDiscount();
            instance.save();
        }
    }
}
