package api.fixtures;

import api.domain.User;
import java.util.Random;

public enum  UserFixtures {
    INSTANCE;
    private final int RECORDS  = 10;

    public void initialize(){
        Random numberGenerator = new Random();

        for(int i = 0; i < RECORDS; i++){
            int randInt = numberGenerator.nextInt(100);
            User user = new User();

            user.setName("user-" + randInt);
            user.setPassword("password");
            user.setEmail("mse"+(i)+"@mum.edu");
            user.setProfile_pic("pic-" + randInt);

            user.save();
        }
    }
}
