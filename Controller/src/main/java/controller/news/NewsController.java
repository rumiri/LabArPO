package controller.news;

import controller.category.CategoryController;
import data_access_object.IDao;
import data_object.DoCategory;
import data_object.DoNews;
import data_transfer_object.DtoNews;
import entity.category.CategoriesList;
import entity.category.ICategory;
import entity.news.INews;
import entity.news.News;
import factory.ModelFactory;

import java.util.ArrayList;
import java.util.List;

public class NewsController implements INewsController{

    @Override
    public DtoNews getNews(int id) {
        IDao<DoNews> daoNews = ModelFactory.getModel().getDaoNews(1);
        DoNews doNews = daoNews.get(id);
        IDao<DoCategory> daoCategory = ModelFactory.getModel().getDaoCategory(1);
        DoCategory doCategory = daoCategory.get(doNews.getCategoryId());
        News news = new News(doNews.getId(), doNews.getTitle(), doNews.getDate(), doCategory.getName(), doNews.getText(), doNews.getAuthor());
        return new DtoNews(news);
    }

    @Override
    public void addNews(INews news) {
        DoNews doNews = new DoNews(news.getId(), news.getTitle(), news.getDate(),
                getCategoryId(news.getCategory()), news.getText(), news.getAuthor());
        IDao<DoNews> daoNews = ModelFactory.getModel().getDaoNews(1);
        daoNews.add(doNews);
    }

    @Override
    public void updateNews(int id, INews news) {
        IDao<DoNews> daoNews = ModelFactory.getModel().getDaoNews(1);
        int categoryId = getCategoryId(news.getCategory());
        DoNews doNews = new DoNews(news.getId(), news.getTitle(), news.getDate(), categoryId, news.getText(), news.getAuthor());
        daoNews.update(doNews);
    }

    @Override
    public void deleteNews(int id) {
        IDao<DoNews> daoNews = ModelFactory.getModel().getDaoNews(1);
        daoNews.delete(id);
    }

    @Override
    public List<DtoNews> getNewsList() {
        IDao<DoNews> daoNews = ModelFactory.getModel().getDaoNews(1);
        List<DoNews> doNewsList = daoNews.getAll();
        List<DtoNews> dtoNewsList = new ArrayList<>();
        for (DoNews doNews: doNewsList) {
            IDao<DoCategory> daoCategory = ModelFactory.getModel().getDaoCategory(1);
            DoCategory doCategory = daoCategory.get(doNews.getCategoryId());
            INews news = new News(doNews.getId(), doNews.getTitle(), doNews.getDate(), doCategory.getName(), doNews.getAuthor(), doNews.getText());
            DtoNews dtoNewsItem = new DtoNews(news);
            dtoNewsList.add(dtoNewsItem);
        }
        return dtoNewsList;
    }

    @Override
    public List<DtoNews> getFilteredNewsList(String category) {
        List<DtoNews> filteredNews = new ArrayList<>();
        List<DtoNews> NewsList = getNewsList();
        for (DtoNews newsItem: NewsList) {
            if (category.equals(newsItem.category)) {
                filteredNews.add(newsItem);
            }
        }
        return filteredNews;
    }

    public static int getCategoryId(String name) {
        List<ICategory> categoriesList = CategoriesList.getInstance().getCategoriesList();
        for (ICategory category: categoriesList) {
            if (name.equals(category.getName())) {
                return category.getId();
            }
        }
        CategoryController categoryController = new CategoryController();
        return categoryController.addCategory(name);
    }
}
