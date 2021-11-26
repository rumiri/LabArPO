package data_object;

import entity.Entity;
import entity.category.ICategory;

public class DoCategory extends Entity {
    private int id;
    private String name;

    public DoCategory(int id, String name) {
        super();
        this.id = id;
        this.name = name;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
