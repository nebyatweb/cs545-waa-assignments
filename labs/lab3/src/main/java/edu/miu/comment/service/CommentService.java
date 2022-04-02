package edu.miu.comment.service;

import edu.miu.comment.domain.Comment;
import edu.miu.comment.domain.dto.CommentDto;

import java.util.List;

public interface CommentService {
    List<CommentDto> findAll();
    void addComment(Comment c);
}
