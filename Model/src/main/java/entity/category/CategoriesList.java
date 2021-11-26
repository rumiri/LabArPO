package entity.category;

import data_access_object.DaoCategory;
import data_object.DoCategory;
import factory.ModelFactory;

import java.util.ArrayList;
import java.util.List;

public class CategoriesList implements ICategoriesList{

    private static volatile CategoriesList instance;

    private ArrayList<ICategory> categoriesList = new ArrayList<>();

    @Override
    public void setCategoriesList(List<ICategory> categoriesList) {
        this.categoriesList = (ArrayList<ICategory>) categoriesList;
    }

    @Override
    public List<ICategory> getCategoriesList() {
        return categoriesList;
    }

    private CategoriesList() {};

    public static CategoriesList getInstance(){
        CategoriesList localInstance = instance;
        if (localInstance == null) {
            synchronized (CategoriesList.class) {
                localInstance = instance;
                if (localInstance == null) {
                    instance = localInstance = new CategoriesList();
                    DaoCategory daoCategory = ModelFactory.getModel().getDaoCategory(1);
                    List<DoCategory> doCategories = daoCategory.getAll();
                    List<ICategory> categories = new ArrayList<>();
                    for (DoCategory doCategory: doCategories) {
                        Category category = new Category(doCategory.getId(), doCategory.getName());
                        categories.add(category);
                    }
                    instance.setCategoriesList(categories);
                }
            }
        }
        return localInstance;
    }

    public int getFreeId() {
        for (int i = 1; i <= categoriesList.size(); i ++) {
            if (i != categoriesList.get(i - 1).getId()) {
                return i;
            }
        }
        return categoriesList.size() + 1;
    }
}
