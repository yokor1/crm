package ca.korichi.crm.services.news;

import ca.korichi.crm.repositories.news.NewsRepository;
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


}
