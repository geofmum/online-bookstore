package api.repository;

import api.domain.User;
import api.domain.query.QUser;

public class UserRepository implements IRepository<User> {
    private static UserRepository instance;

    private UserRepository() {}

    public static UserRepository getInstance(){
        synchronized (UserRepository.class){
            if (instance == null)
                instance = new UserRepository();
        }

        return instance;
    }

    @Override
    public User getById(long id) {
        return null;
    }
}
