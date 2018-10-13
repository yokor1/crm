package ca.korichi.crm.services.news;

import ca.korichi.crm.repositories.NewsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("NewsService")
public class CrmNewsService implements NewsService {

    private final NewsRepository newsRepository;

    @Autowired
    public CrmNewsService(NewsRepository newsRepository) {
        this.newsRepository = newsRepository;
    }

    @Override
    public List<News> findAll() {
        return newsRepository.findAll();
    }

    @Override
    public News findById(String newsId) {
        return newsRepository.findById(newsId)
                .orElseThrow(() -> new NewsNotFoundException("userId not found."));
    }
}
