package api.repository;

import api.domain.User;

public class UserRepository extends BaseRepository<User> {
    protected UserRepository(User model) {
        super(model);
    }
}
