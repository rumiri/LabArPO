package entity.news;

import javax.xml.crypto.Data;
import java.util.Date;

public interface INews {

    int getId();

    void setId(int id);

    String getTitle();

    void setTitle(String title);

    Date getDate();

    void setDate(Date date);

    String getCategory();

    void setCategory(String category);

    public String getAuthor();

    public void setAuthor(String author);

    String getText();

    void setText(String text);
}
