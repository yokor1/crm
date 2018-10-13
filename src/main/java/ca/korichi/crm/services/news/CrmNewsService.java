package ca.korichi.crm.services.news;

import ca.korichi.crm.repositories.news.NewsRepository;
import ca.korichi.crm.repositories.user.UserRepository;
import ca.korichi.crm.services.users.UserId;
import ca.korichi.crm.services.users.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Service("NewsService")
public class CrmNewsService implements NewsService {

    private final NewsRepository newsRepository;
    private final UserRepository userRepository;

    @Autowired
    public CrmNewsService(NewsRepository newsRepository, UserRepository userRepository) {
        this.newsRepository = newsRepository;
        this.userRepository = userRepository;
    }

    @Override
    public List<News> findAll() {
        return newsRepository.findAll();
    }

    @Override
    public News findById(NewsId newsId) {
        return newsRepository.findById(newsId)
                .orElseThrow(() -> new NewsNotFoundException("userId not found."));
    }

    @Override
    public News create(News news) {
        return newsRepository.create(news);
    }

    @Override
    public News delete(NewsId newsId) {
        return newsRepository.delete(newsId).orElseThrow(() -> new NewsNotFoundException("newsId not found"));
    }

    @Override
    public void addReviewers(NewsId newsId, List<UserId> userIds) {
        allUserExist(userIds);
        allUserAreReviewers(userIds);
        News news = newsRepository.findById(newsId)
                .orElseThrow(() -> new NewsNotFoundException("news not found"));
        news.addReviewers(userIds);
        newsRepository.update(news);
    }

    @Override
    public void addMandatoryReviewers(NewsId newsId, List<UserId> userIds) {
        allUserExist(userIds);
        allUserAreReviewers(userIds);
        News news = newsRepository.findById(newsId)
                .orElseThrow(() -> new NewsNotFoundException("news not found"));
        news.addMandatoryReviewers(userIds);
        newsRepository.update(news);
    }

    private void allUserAreReviewers(List<UserId> userIds) {
        Set<UserId> notReviewers = userIds.stream()
                .filter(userId -> !userRepository.isReviewer(userId))
                .collect(Collectors.toSet());
        if (notReviewers.size() > 0)
            throw new UserNotAuthorizedException("users not reviewers:" + notReviewers);
    }

    private void allUserExist(List<UserId> userIds) {
        Set<UserId> notExists = userIds.stream()
                .filter(userId -> !userRepository.exists(userId))
                .collect(Collectors.toSet());
        if (notExists.size() > 0)
            throw new UserNotFoundException("users not exist:" + notExists);


    }


}
