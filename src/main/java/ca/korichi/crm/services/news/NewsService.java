package ca.korichi.crm.services.news;

import java.util.List;

public interface NewsService {
    List<News> findAll();

    News findById(String newsId);
}
