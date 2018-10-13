package ca.korichi.crm.services.news;

import ca.korichi.crm.services.users.UserId;
import lombok.Value;

@Value
public class Review {
    private UserId userId;
    private Boolean accepted;
}
