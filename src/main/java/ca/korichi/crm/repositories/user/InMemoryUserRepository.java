package ca.korichi.crm.repositories.user;

import ca.korichi.crm.services.users.User;
import ca.korichi.crm.services.users.UserId;
import ca.korichi.crm.services.users.UserRole;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

@Repository(value = "UserRepository")
public class InMemoryUserRepository implements UserRepository {
    private static final User fakeUser = new User(new UserId(), "name", UserRole.READER);
    private static final Map<UserId, User> users = new ConcurrentHashMap<UserId, User>() {{
        put(fakeUser.getUserId(), fakeUser);
    }};

    @Override
    public List<User> findAll() {
        return new ArrayList<>(users.values());
    }

    @Override
    public Optional<User> findById(UserId userId) {
        return Optional.ofNullable(users.get(userId));
    }

    @Override
    public User create(User user) {
        UserId generatedUserId = new UserId();
        users.put(generatedUserId, new User(generatedUserId, user));
        return users.get(generatedUserId);
    }
}
