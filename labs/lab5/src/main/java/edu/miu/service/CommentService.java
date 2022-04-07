package edu.miu.service;

import edu.miu.domain.Comment;
import edu.miu.domain.dto.CommentDto;

import java.util.List;

public interface CommentService {
    List<CommentDto> findAll();
    void addComment(Comment c);
}
