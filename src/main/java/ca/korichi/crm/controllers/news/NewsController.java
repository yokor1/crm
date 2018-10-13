package ca.korichi.crm.controllers.news;

import ca.korichi.crm.services.news.News;
import ca.korichi.crm.services.news.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
        return ResponseEntity.ok(newsService.findById(newsId));
    }

}
