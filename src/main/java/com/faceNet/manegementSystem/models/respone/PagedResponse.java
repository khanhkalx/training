package com.faceNet.manegementSystem.models.respone;

import lombok.Data;

import java.util.List;

@Data
public class PagedResponse<T> {
    private List<T> content;
    private int totalPages;
    private long totalElements;

    public PagedResponse(List<T> content, int totalPages, long totalElements) {
        this.content = content;
        this.totalPages = totalPages;
        this.totalElements = totalElements;
    }


}
