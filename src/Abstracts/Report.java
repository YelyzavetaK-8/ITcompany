package Abstracts;

import java.util.Date;

public abstract class Report {
    protected final int id;
    protected String title;
    protected final Date dateCreated;

    public Report(int id, String title) {
        this.id = id;
        this.title = title;
        this.dateCreated = new Date(); 
    }

    public int getId() {
        return id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getDateCreated() {
        return dateCreated;
    }

    @Override
    public String toString() {
        return "Report{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", dateCreated=" + dateCreated +
                '}';
    }
}
