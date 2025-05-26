package com.github.sprise233.bumentong.dto;

import lombok.Data;

import java.util.List;

@Data
public class ListResponseDTO<T> {
    private Long total;
    private List<T> rows ;

    public ListResponseDTO() {
    }

    public ListResponseDTO(Long total, List<T> rows) {
        this.total = total;
        this.rows = rows;
    }
}
