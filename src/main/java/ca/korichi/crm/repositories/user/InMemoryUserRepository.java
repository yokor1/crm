package ca.korichi.crm.repositories.user;

import ca.korichi.crm.services.users.User;
import ca.korichi.crm.services.users.UserId;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

@Repository(value = "UserRepository")
public class InMemoryUserRepository implements UserRepository {
    private static final Map<UserId, User> users = new ConcurrentHashMap<>();

    @Override
    public List<User> findAll() {
        return new ArrayList<>(users.values());
    }

    @Override
    public Optional<User> findById(UserId userId) {
        return Optional.ofNullable(users.get(userId));
    }
}
