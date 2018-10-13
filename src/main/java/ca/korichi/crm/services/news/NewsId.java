package ca.korichi.crm.services.news;

import lombok.Value;

import java.util.UUID;

@Value
public class NewsId {
    String value;

    public NewsId() {
        this.value = UUID.randomUUID().toString();
    }

    public NewsId(String newsId) {
        this.value = newsId;
    }
}
