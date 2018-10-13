package ca.korichi.crm.services.news;

import ca.korichi.crm.services.users.UserId;
import lombok.Value;

import java.util.HashSet;
import java.util.Set;

@Value
public class News {
    private NewsId newsId;
    private String title;
    private String content;
    private Set<UserId> reviewers;
    private Set<UserId> mandatoryReviewers;
    private Set<Category> categories;
    private Set<String> tags;


    public News(NewsId newsId, String title, String content) {
        this.newsId = newsId;
        this.title = title;
        this.content = content;
        this.reviewers = new HashSet<>();
        this.mandatoryReviewers = new HashSet<>();
        this.categories = new HashSet<>();
        this.tags = new HashSet<>();
    }

    public News(NewsId newsId, News oldNews) {
        this.newsId = newsId;
        this.title = oldNews.title;
        this.content = oldNews.content;
        this.reviewers = oldNews.reviewers;
        this.mandatoryReviewers = oldNews.mandatoryReviewers;
        this.categories = oldNews.categories;
        this.tags = oldNews.tags;
    }

}
