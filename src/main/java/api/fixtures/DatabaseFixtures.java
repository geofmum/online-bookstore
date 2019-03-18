package api.fixtures;

public enum DatabaseFixtures {
    INSTANCE;

    public void initialize() {
        UserFixtures.INSTANCE.initialize();
        BookFixtures.INSTANCE.initialize();
        AddressFixtures.INSTANCE.initialize();

    }
}
