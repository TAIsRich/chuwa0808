package com.chuwa.mongoblog.payload;

public class PostDto {
    private String id;

    private String title;

    private String description;

    private String content;

    public PostDto() {
    }

    public PostDto(String id, String title, String description, String content) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.content = content;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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

    @Override
    public String toString() {
        return "PostDto{" +
                "id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}
