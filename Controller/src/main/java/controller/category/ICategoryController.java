package controller.category;

public interface ICategoryController {
    void addCategory(int id, String name);

    void updateCategory(int id, String name);

    void deleteCategory(int id);
}
