package edu.miu.controller;

import edu.miu.domain.dto.UserDto;
import edu.miu.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/admin")
//@RequiredArgsConstructor
public class AdminController {

//    private final UserService userService;

    @GetMapping
//    @PreAuthorize("hasRole('ADMIN')")
//    public List<UserDto> getUsers() {
//        return userService.findAll();
//    }
    public String getAdminPage(){
        return "This is the admin page";
    }
}
