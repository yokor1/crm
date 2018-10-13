package ca.korichi.crm.services.news;

import java.util.List;

public interface NewsService {
    List<News> findAll();

    News findById(NewsId newsId);

    News create(News news);

    News delete(NewsId newsId);
}
