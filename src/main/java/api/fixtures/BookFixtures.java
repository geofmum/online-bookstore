package api.fixtures;

import api.domain.Book;

import java.util.Random;

public enum BookFixtures {
    INSTANCE;
    private final int RECORDS = 20;

    public void initialize() {
        Random numberGenerator = new Random();
        String[] category = new String[]{"Drama", "Fantasy", "Romance", "Best Seller", "Science"};
        String[] description = new String[]{
                "Lorem ipsum dolor sit amet, consectetur adipiscing elit",
                "sed do eiusmod tempor incididunt ut labore et dolore magna aliqua.",
                "Ut enim ad minim veniam, quis nostrud",
                "exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat."
        };
        for (int i = 0; i < RECORDS; i++) {
            int randInt = numberGenerator.nextInt(1000);

            Book instance = new Book();

            instance.setAuthor("author-" + randInt);
            instance.setPublisher("publisher-" + randInt);
            instance.setISBN("isbn-" + randInt);
            instance.setPrice(10 + randInt);
            instance.setTitle("title-" + randInt);
            instance.setDescription(description[randInt % 4]);
            instance.setCategory(category[i % 5]);
            instance.setYear("1990" + randInt);
            instance.setDiscount(numberGenerator.nextDouble());
            if (i < 5) instance.setDiscount(10);
            instance.setThumb_url("/resources/images/book" + (i % 10 + 1) + ".jpg");

            instance.save();
        }
    }
}
