package api.fixtures;

import api.domain.Publisher;

public enum DatabaseFixtures {
    INSTANCE;

    public void initialize() {
        UserFixtures.INSTANCE.initialize();
        AuthorFixtures.INSTANCE.initialize();
        PublisherFixtures.INSTANCE.initialize();
        BookFixtures.INSTANCE.initialize();
        AddressFixtures.INSTANCE.initialize();

    }
}
