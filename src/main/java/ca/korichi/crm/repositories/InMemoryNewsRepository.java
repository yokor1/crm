package ca.korichi.crm.repositories;

import ca.korichi.crm.services.news.News;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;

@Repository(value = "NewsRepository")
public class InMemoryNewsRepository implements NewsRepository {
    private static News fakeNews =
            new News("newsid", "title", "content",
                    new HashSet<>(), new HashSet<>(),
                    new HashSet<>(), new HashSet<>());

    @Override
    public List<News> findAll() {
        return Arrays.asList(fakeNews);
    }

    @Override
    public Optional<News> findById(String newsId) {
        return Optional.of(fakeNews);
    }
}
