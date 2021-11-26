package entity.category;

import entity.Entity;

public class Category extends Entity implements ICategory{
    private int id;
    private String name;

    public Category(int id, String name) {
        super();
        this.name = name;
        this.id = id;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }
}
