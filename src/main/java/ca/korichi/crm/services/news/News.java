package ca.korichi.crm.services.news;

import lombok.Value;

import java.util.Set;

@Value
public class News {
    private String newsId;
    private String title;
    private String content;
    private Set<User> reviewers;
    private Set<User> mandatoryReviewers;
    private Set<Category> categories;
    private Set<String> tags;

}
