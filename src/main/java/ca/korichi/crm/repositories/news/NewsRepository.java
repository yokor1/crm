package ca.korichi.crm.repositories.news;

import ca.korichi.crm.services.news.News;
import ca.korichi.crm.services.news.NewsId;

import java.util.List;
import java.util.Optional;

public interface NewsRepository {
    List<News> findAll();

    Optional<News> findById(NewsId newsId);

    News create(News news);

    Optional<News> delete(NewsId newsId);
}
