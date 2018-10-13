package ca.korichi.crm.services.users;

import java.util.List;

public interface UserService {
    List<User> findAll();

    User findById(UserId userId);
}
