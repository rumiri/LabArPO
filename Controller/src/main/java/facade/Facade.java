package facade;

import data_transfer_object.DtoNews;
import controller.category.CategoryController;
import controller.category.ICategoryController;
import controller.news.INewsController;
import controller.news.NewsController;
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
    public void updateNews() {

    }

    @Override
    public void deleteNews() {

    }

    @Override
    public List<?> getNewsList() {
        return null;
    }

    @Override
    public void addCategory(String name) {

    }

    @Override
    public void updateCategory() {

    }

    @Override
    public void deleteCategory() {

    }

    @Override
    public List<?> getCategoriesList() {
        return null;
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
