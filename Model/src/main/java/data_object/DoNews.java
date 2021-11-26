package data_object;

import entity.Entity;
import entity.news.INews;

import java.util.Date;

public class DoNews extends Entity {
    private int id;
    private String title;
    private Date date;
    private int categoryId;
    private String author;
    private String text;

    public DoNews(int id, String title, Date date, int categoryId, String text, String author) {
        super();
        this.id = id;
        this.title = title;
        this.date = date;
        this.categoryId = categoryId;
        this.text = text;
        this.author = author;
    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }

    public String getTitle()  {
        return title;
    }


    public void setTitle(String title)  {
        this.title = title;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date)  {
        this.date = date;
    }

    public int getCategoryId() {
        return categoryId;
    }

    public void setCategoryId(int categoryId) {
        this.categoryId = categoryId;
    }

    public String getAuthor()  {
        return author;
    }

    public void setAuthor(String author)  {
        this.author = author;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
