package api.fixtures;

import api.domain.Address;
import api.domain.User;
import api.domain.query.QUser;

import java.util.Random;

public enum AddressFixtures {
    INSTANCE;
    private final int RECORDS  = 10;

    public void initialize(){
        Random numberGenerator = new Random();

        for(int i = 0; i < RECORDS; i++){
            int randInt = numberGenerator.nextInt(1000);
            Address instance = new Address();
            User user = (new QUser()).id.eq(i + 1).findOne();

            instance.setUser(user);
            instance.setStreet("street-" + randInt);
            instance.setAppartment("appartment-" + randInt);
            instance.setCity("city-" + randInt);
            instance.setZipcode("5245-" + randInt);
            instance.setState("state-" + randInt);
            instance.setPhonenumber("1234567" + randInt);
            instance.save();
        }
    }
}
