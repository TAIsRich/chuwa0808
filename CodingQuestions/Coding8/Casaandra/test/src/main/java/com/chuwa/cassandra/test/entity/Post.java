package com.chuwa.cassandra.test.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.cassandra.core.mapping.Table;

@Table
public class Post {

    @Id
    private int id;

    private String description;

    private String content;

    private String title;

    public Post() {
    }

    public Post(int id, String description, String content, String title) {
        this.id = id;
        this.description = description;
        this.content = content;
        this.title = title;
    }

    @Override
    public String toString() {
        return "Post{" +
                "id=" + id +
                ", description='" + description + '\'' +
                ", content='" + content + '\'' +
                ", title='" + title + '\'' +
                '}';
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public String getContent() {
        return content;
    }

    public String getTitle() {
        return title;
    }
}
