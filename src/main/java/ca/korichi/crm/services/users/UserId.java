package ca.korichi.crm.services.users;

import lombok.Value;

import java.util.UUID;

@Value
public class UserId {
    String value;

    public UserId() {
        this.value = UUID.randomUUID().toString();
    }

    public UserId(String userId) {
        this.value = userId;
    }
}
