package ca.korichi.crm.controllers.news;

import ca.korichi.crm.services.news.News;
import ca.korichi.crm.services.news.NewsId;
import ca.korichi.crm.services.news.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(
        value = "/news",
        consumes = {MediaType.APPLICATION_JSON_UTF8_VALUE},
        produces = {MediaType.APPLICATION_JSON_UTF8_VALUE})
public class NewsController {


    private final NewsService newsService;

    @Autowired
    public NewsController(NewsService newsService) {
        this.newsService = newsService;
    }

    @GetMapping(value = "")
    public ResponseEntity<List<News>> findAll() {
        return ResponseEntity.ok(newsService.findAll());
    }

    @GetMapping(value = "/{news-id}")
    public ResponseEntity<News> findById(@PathVariable("news-id") String newsId) {
        return ResponseEntity.ok(newsService.findById(new NewsId(newsId)));
    }

    @PostMapping(value = "/")
    public ResponseEntity<News> create(@RequestBody News news) {
        News createdNews = newsService.create(news);
        return ResponseEntity
                .created(URI.create("/news/" + createdNews.getNewsId()))
                .body(createdNews);
    }

    @DeleteMapping(value = "/{news-id}")
    public ResponseEntity<News> delete(@PathVariable("news-id") String newsId) {
        News deletedNews = newsService.delete(new NewsId(newsId));
        return ResponseEntity.accepted().body(deletedNews);
    }

}
