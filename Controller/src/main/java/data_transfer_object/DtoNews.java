package data_transfer_object;

import entity.news.INews;

import java.util.Date;

public class DtoNews {
    public int id;
    public String title;
    public Date date;
    public String category;
    public String author;
    public String text;

    public DtoNews(INews news) {
        this.id = news.getId();
        this.title = news.getTitle();
        this.date = news.getDate();
        this.category = news.getCategory();
        this.text = news.getText();
        this.author = news.getAuthor();
    }
}
