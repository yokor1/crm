package ca.korichi.crm.services.users;

import lombok.Value;

@Value
public class User {
    private UserId userId;
    private String name;
    private UserRole userRole;

    public User(UserId userId, User user) {
        this.userId = userId;
        this.name = user.name;
        this.userRole = user.userRole;
    }

    public User(UserId userId, String name, UserRole userRole) {
        this.userId = userId;
        this.name = name;
        this.userRole = userRole;
    }

    public boolean isReviewer() {
        return userRole.equals(UserRole.REVIEWER);
    }
}
