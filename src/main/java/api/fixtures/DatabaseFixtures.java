package api.fixtures;

public enum DatabaseFixtures {
    INSTANCE;

    public void initialize(){
        UserFixtures.INSTANCE.initialize();
    }
}
