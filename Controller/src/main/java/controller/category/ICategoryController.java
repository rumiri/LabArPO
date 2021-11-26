package controller.category;

import data_transfer_object.DtoCategory;

import java.util.List;

public interface ICategoryController {
    int addCategory(String name);

    void updateCategory(String name);

    void deleteCategory(int id);

    List<DtoCategory> getCategoriesList();
}
