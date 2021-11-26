package facade;

import data_transfer_object.DtoCategory;
import data_transfer_object.DtoNews;
import controller.category.CategoryController;
import controller.category.ICategoryController;
import controller.news.INewsController;
import controller.news.NewsController;
import entity.category.ICategory;
import entity.news.INews;

import java.util.Date;
import java.util.List;

public class Facade implements IFacade{
    INewsController newsController;
    ICategoryController categoryController = new CategoryController();
    List<String> sadWords;
    List<String> definedAuthors;
    List<Date> definedDates;

    @Override
    public DtoNews getNews(int id) {
        return newsController.getNews(id);
    }

    @Override
    public void addNews(INews news) {
        newsController.addNews(news);
    }

    @Override
    public void updateNews(int id, INews news) {
        newsController.updateNews(id, news);
    }

    @Override
    public void deleteNews(int id) {
        newsController.deleteNews(id);
    }

    @Override
    public List<DtoNews> getNewsList() {
        return newsController.getNewsList();
    }

    @Override
    public void addCategory(ICategory category) {
        categoryController.addCategory(category.getName());
    }

    @Override
    public void updateCategory(int id, INews news) {
        newsController.updateNews(id, news);
    }

    @Override
    public void deleteCategory(int id) {
        categoryController.deleteCategory(id);
    }

    @Override
    public List<DtoCategory> getCategoriesList() {
        return categoryController.getCategoriesList();
    }

    public Facade(List<String> sadWords, List<String> definedAuthors, List<Date> definedDates) {
        this.sadWords = sadWords;
        this.definedAuthors = definedAuthors;
        this.definedDates = definedDates;

        newsController = new NewsController();
        if (sadWords != null) {
            newsController = new WithoutSadWordsNewsController(newsController, sadWords);
        }
        if (definedAuthors != null) {
            newsController = new DefinedAuthorsNewsController(newsController, definedAuthors);
        }
        if (definedDates != null) {
            newsController = new DefinedDatesNewsController(newsController, definedDates);
        }
    }
}
