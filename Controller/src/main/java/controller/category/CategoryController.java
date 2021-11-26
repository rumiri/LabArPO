package controller.category;

import controller.news.NewsController;
import data_access_object.DaoCategory;
import data_object.DoCategory;
import data_transfer_object.DtoCategory;
import entity.category.CategoriesList;
import entity.category.Category;
import entity.category.ICategory;
import factory.ModelFactory;

import java.util.ArrayList;
import java.util.List;

public class CategoryController implements ICategoryController{
    @Override
    public int addCategory(String name) {
        int id = getFreeId();
        ICategory category = new Category(id, name);
        DaoCategory daoCategory = ModelFactory.getModel().getDaoCategory(1);
        DoCategory doCategory = new DoCategory(category.getId(), category.getName());
        daoCategory.add(doCategory);
        updateCategoryCache(daoCategory);
        return id;
    }

    @Override
    public void updateCategory(String name) {
        DoCategory doCategory = new DoCategory(NewsController.getCategoryId(name), name);
        DaoCategory daoCategory = ModelFactory.getModel().getDaoCategory(1);
        daoCategory.update(doCategory);
        updateCategoryCache(daoCategory);
    }

    @Override
    public void deleteCategory(int id) {
        DaoCategory daoCategory = ModelFactory.getModel().getDaoCategory(1);
        daoCategory.delete(id);
        updateCategoryCache(daoCategory);
    }

    @Override
    public List<DtoCategory> getCategoriesList() {
        List<ICategory> categories = CategoriesList.getInstance().getCategoriesList();
        ArrayList<DtoCategory> dtoCategories = new ArrayList<>();
        for (ICategory category: categories) {
            DtoCategory dtoCategory = new DtoCategory(category.getId(), category.getName());
            dtoCategories.add(dtoCategory);
        }
        return dtoCategories;
    }

    public static int getFreeId() {
        return CategoriesList.getInstance().getFreeId();
    }

    private void updateCategoryCache(DaoCategory daoCategory) {
        List<DoCategory> doCategoriesList = daoCategory.getAll();
        List<ICategory> categoriesList = new ArrayList<>();
        for (DoCategory doCat: doCategoriesList) {
            ICategory category = new Category(doCat.getId(), doCat.getName());
            categoriesList.add(category);
        }
        CategoriesList.getInstance().setCategoriesList(categoriesList);
    }
}
