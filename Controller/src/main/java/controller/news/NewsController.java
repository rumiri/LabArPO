package controller.news;

import data_access_object.IDao;
import data_object.DoCategory;
import data_object.DoNews;
import data_transfer_object.DtoNews;
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
        return new DtoNewsItem(news);
    }

    @Override
    public void addNews(INews news) {

    }

    @Override
    public void updateNews(int id, INews news) {

    }

    @Override
    public void deleteNews(int id) {

    }

    @Override
    public List<DtoNews> getAllNews() {
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
        return null;
    }
}
