package ca.korichi.crm.services.news;

import lombok.Value;

@Value
public class User {
    private String userId;
    private String name;
    private UserRole userRole;
}
