package com.chuwa.redbook.payload;

import java.util.List;

public class PostResponse {
    private List<PostDto> content;
    private long totalElements;
    private int pageSize;
    private int totalPages;
    private int pageNo;
    private boolean last;

    public PostResponse() {
    }

    public PostResponse(List<PostDto> content, long totalElement, int pageSize, int totalPages, int pageNo, boolean last) {
        this.content = content;
        this.totalElements = totalElement;
        this.pageSize = pageSize;
        this.totalPages = totalPages;
        this.pageNo = pageNo;
        this.last = last;
    }

    public List<PostDto> getContent() {
        return content;
    }

    public void setContent(List<PostDto> content) {
        this.content = content;
    }

    public long getTotalElements() {
        return totalElements;
    }

    public void setTotalElements(long totalElements) {
        this.totalElements = totalElements;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getTotalPages() {
        return totalPages;
    }

    public void setTotalPages(int totalPages) {
        this.totalPages = totalPages;
    }

    public int getPageNo() {
        return pageNo;
    }

    public void setPageNo(int pageNo) {
        this.pageNo = pageNo;
    }

    public boolean isLast() {
        return last;
    }

    public void setLast(boolean last) {
        this.last = last;
    }

    @Override
    public String toString() {
        return "PostResponse{" +
                "content=" + content +
                ", pageNo=" + pageNo +
                ", pageSize=" + pageSize +
                ", totalElements=" + totalElements +
                ", totalPages=" + totalPages +
                ", last=" + last +
                '}';
    }
}
