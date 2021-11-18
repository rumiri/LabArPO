package entity.news;

import entity.Entity;

import java.util.Date;

public class News extends Entity implements INews{
    private int id;
    private String title;
    private Date date;
    private String category;
    private String author;
    private String text;

    public News() { }

    public News(int id, String title, Date date, String category, String author, String text) {
        this.id = id;
        this.title = title;
        this.date = date;
        this.category = category;
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


    @Override
    public String getTitle()  {
        return title;
    }

    @Override
    public void setTitle(String title)  {
        this.title = title;
    }

    @Override
    public Date getDate() {
        return date;
    }

    @Override
    public void setDate(Date date)  {
        this.date = date;
    }

    @Override
    public String getCategory() {
        return category;
    }

    @Override
    public void setCategory(String category) {
        this.category = category;
    }

    @Override
    public String getAuthor()  {
        return author;
    }

    @Override
    public void setAuthor(String author)  {
        this.author = author;
    }

    @Override
    public String getText() {
        return text;
    }

    @Override
    public void setText(String text) {
        this.text = text;
    }
}
