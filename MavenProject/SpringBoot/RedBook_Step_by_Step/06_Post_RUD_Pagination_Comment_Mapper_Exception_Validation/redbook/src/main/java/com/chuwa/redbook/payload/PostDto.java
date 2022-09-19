package com.chuwa.redbook.payload;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.util.Set;

public class PostDto {
    private Long id;

    /**
     * 1. title should not be null or empty
     * 2. title should have at least 2 characters
     * Question: our database have set it as nullable=false, why do we need to set validation here? what are the benefits?
     */
    @NotEmpty
    @Size(min = 2, message = "Post title should have at least 2 characters.")
    private String title;

    @NotEmpty
    @Size(min = 10, message = "Post description should have at least 10 characters.")
    private String description;

    @NotEmpty
    private String content;
    private Set<CommentDto> comments;

    public PostDto() {

    }

    public PostDto(Long id, String title, String description, String content) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.content = content;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public Set<CommentDto> getComments() {
        return comments;
    }

    public void setComments(Set<CommentDto> comments) {
        this.comments = comments;
    }

    @Override
    public String toString() {
        // title=后边跟的是一个string, string在json里边要有''
        // 双引号里边的单引号不用escape
        return "PostDto{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", content='" + content + '\'' +
                '}';
    }
}
