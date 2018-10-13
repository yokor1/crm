package ca.korichi.crm.services.users;

import ca.korichi.crm.repositories.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service(value = "UserService")
public class CrmUserService implements UserService {
    private final UserRepository userRepository;

    @Autowired
    public CrmUserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();
    }

    @Override
    public User findById(UserId userId) {
        return userRepository.findById(userId)
                .orElseThrow(() -> new UserNotFoundException("userId not found"));
    }

    @Override
    public User create(User user) {
        return userRepository.create(user);
    }
}
