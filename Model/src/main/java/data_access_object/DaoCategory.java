package data_access_object;

import data_object.DoCategory;
import provider.IProvider;

import java.util.List;

public class DaoCategory implements IDao<DoCategory>{

    public static final String CATEGORY = "categories";
    private IProvider provider;

    public DaoCategory(IProvider provider) {
        this.provider = provider;
    }

    @Override
    public DoCategory get(int id) {
        return provider.get(CATEGORY, id);
    }

    @Override
    public List<DoCategory> getAll() {
        return provider.getAll(CATEGORY);
    }

    @Override
    public void add(DoCategory category) {
        provider.add(CATEGORY, category);
    }

    @Override
    public void update(DoCategory category) {
        provider.update(CATEGORY, category);
    }

    @Override
    public void delete(int id) {
        provider.delete(CATEGORY, id);
    }

    @Override
    public List<Integer> getIdList() {
        return provider.getIdList(CATEGORY);
    }
}
