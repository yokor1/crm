package ca.korichi.crm.repositories;

import ca.korichi.crm.services.news.News;

import java.util.List;
import java.util.Optional;

public interface NewsRepository {
    List<News> findAll();

    Optional<News> findById(String newsId);
}
