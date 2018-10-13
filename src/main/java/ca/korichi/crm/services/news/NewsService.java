package ca.korichi.crm.services.news;

import ca.korichi.crm.services.users.UserId;

import java.util.List;

public interface NewsService {
    List<News> findAll();

    News findById(NewsId newsId);

    News create(News news);

    News delete(NewsId newsId);

    void addReviewers(NewsId newsId, List<UserId> userIds);

    void addMandatoryReviewers(NewsId newsId, List<UserId> userIds);
}
