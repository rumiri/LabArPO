package facade;

import data_transfer_object.DtoNews;
import entity.news.INews;

import java.util.List;

public interface IFacade {
    DtoNews getNews(int id);

    void addNews(INews news);

    void updateNews();

    void deleteNews();

    List<?> getNewsList();

    void addCategory(String name);

    void updateCategory();

    void deleteCategory();

    List<?> getCategoriesList();
}
