package edu.miu.comment.domain.dto;

import lombok.Data;

@Data
public class UserDto {
    private long id;
    private String email;
    private String firstName;
    private String lastName;
}
