package edu.miu.service.impl;

import edu.miu.domain.Comment;
import edu.miu.domain.dto.CommentDto;
import edu.miu.util.ListMapper;
import edu.miu.repo.CommentRepo;
import edu.miu.service.CommentService;
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
