package ca.korichi.crm.repositories.news;

import ca.korichi.crm.services.news.News;
import ca.korichi.crm.services.news.NewsId;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

@Repository(value = "NewsRepository")
public class InMemoryNewsRepository implements NewsRepository {

    private static Map<NewsId, News> news = new ConcurrentHashMap<>();

    @Override
    public List<News> findAll() {
        return new ArrayList<>(news.values());
    }

    @Override
    public Optional<News> findById(NewsId newsId) {
        return Optional.ofNullable(news.get(newsId));
    }

    @Override
    public News create(News newNews) {
        NewsId generatedNewsId = new NewsId();
        news.put(generatedNewsId, new News(generatedNewsId, newNews));
        return news.get(generatedNewsId);
    }

    @Override
    public Optional<News> delete(NewsId newsId) {
        News removedNews = news.remove(newsId);
        return Optional.ofNullable(removedNews);
    }

    @Override
    public Optional<News> update(News updatedNews) {
        if (!news.containsKey(updatedNews.getNewsId())) return Optional.empty();
        news.replace(updatedNews.getNewsId(), updatedNews);
        return Optional.of(updatedNews);
    }
}
