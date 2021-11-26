package facade;

import data_transfer_object.DtoCategory;
import data_transfer_object.DtoNews;
import entity.category.ICategory;
import entity.news.INews;

import java.util.List;

public interface IFacade {
    DtoNews getNews(int id);

    void addNews(INews news);

    void updateNews(int id, INews news);

    void deleteNews(int id);

    List<DtoNews> getNewsList();

    void addCategory(ICategory category);

    void updateCategory(int id, INews news);

    void deleteCategory(int id);

    List<DtoCategory> getCategoriesList();
}
