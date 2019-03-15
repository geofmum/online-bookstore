package api.repository;

import api.domain.User;
import com.sun.org.apache.xpath.internal.operations.Mod;

public class UserRepository extends BaseRepository<User> {
    protected UserRepository(User model) {
        super(model);
    }


}
