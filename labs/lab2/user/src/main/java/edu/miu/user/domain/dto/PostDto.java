package edu.miu.user.domain.dto;

import lombok.Data;

@Data
public class PostDto {
    private int id;
    private String title;
    private String content;
    private String author;
    private long user_id;
}
