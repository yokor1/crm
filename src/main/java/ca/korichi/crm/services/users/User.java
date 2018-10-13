package ca.korichi.crm.services.users;

import lombok.Value;

@Value
public class User {
    private UserId userId;
    private String name;
    private UserRole userRole;
}
