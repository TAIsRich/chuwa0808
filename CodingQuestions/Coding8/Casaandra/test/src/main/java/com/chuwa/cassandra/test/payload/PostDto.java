package com.chuwa.cassandra.test.payload;

public class PostDto {
    private int id;

    private String description;

    private String content;

    private String title;

    public PostDto() {
    }

    public PostDto(int id, String description, String content, String title) {
        this.id = id;
        this.description = description;
        this.content = content;
        this.title = title;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
