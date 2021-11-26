package controller.news;

import data_transfer_object.DtoNews;
import entity.news.INews;

import java.util.List;

public interface INewsController {
    DtoNews getNews(int id);

    void addNews(INews news);

    void updateNews(int id, INews news);

    void deleteNews(int id);

    List<DtoNews> getNewsList();

    List<DtoNews> getFilteredNewsList(String category);
}
