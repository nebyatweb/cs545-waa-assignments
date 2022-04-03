package edu.miu.comment.service.impl;

import edu.miu.comment.domain.Comment;
import edu.miu.comment.domain.dto.CommentDto;
import edu.miu.comment.helper.ListMapper;
import edu.miu.comment.repo.CommentRepo;
import edu.miu.comment.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {
    @Autowired
    CommentRepo commentRepo;

    @Autowired
    ListMapper listMapper;

    @Autowired
    ListMapper<Comment, CommentDto> listMapperCommentToDto;


    @Override
    public List<CommentDto> findAll() {
        return (List<CommentDto>)listMapperCommentToDto.mapList(commentRepo.findAll(), new CommentDto());
    }

    @Override
    public void addComment(Comment c) {
        commentRepo.save(c);
    }
}
