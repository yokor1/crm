package ca.korichi.crm.repositories.user;

import ca.korichi.crm.services.users.User;
import ca.korichi.crm.services.users.UserId;

import java.util.List;
import java.util.Optional;

public interface UserRepository {
    List<User> findAll();

    Optional<User> findById(UserId userId);

    User create(User user);
}
