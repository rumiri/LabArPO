package data_access_object;

import data_object.DoNews;
import provider.IProvider;

import java.util.List;

public class DaoNews implements IDao<DoNews>{

    public static final String NEWS = "news";
    private IProvider provider;

    public DaoNews(IProvider provider) {
        this.provider = provider;
    }

    @Override
    public DoNews get(int id) {
        return provider.get(NEWS, id);
    }

    @Override
    public List<DoNews> getAll() {
        return provider.getAll(NEWS);
    }

    @Override
    public void add(DoNews news) {
        provider.add(NEWS, news);
    }

    @Override
    public void update(DoNews news) {
        provider.update(NEWS, news);
    }

    @Override
    public void delete(int id) {
        provider.delete(NEWS, id);
    }

    @Override
    public List<Integer> getIdList() {
        return provider.getIdList(NEWS);
    }
}
