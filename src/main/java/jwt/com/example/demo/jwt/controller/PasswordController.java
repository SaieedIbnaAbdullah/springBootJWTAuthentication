package jwt.com.example.demo.jwt.controller;

import jwt.com.example.demo.jwt.models.UserEntity;
import jwt.com.example.demo.jwt.service.UserService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/create-pass")
public class PasswordController {
    private final UserService userService;

    public PasswordController(UserService userService) {
        this.userService = userService;
    }
    @PostMapping
    public ResponseEntity<UserEntity> createPass(@RequestBody UserEntity userEntity){
        UserEntity user = userService.createPassword(userEntity);
        final HttpHeaders httpHeaders = new HttpHeaders();
        httpHeaders.setContentType(MediaType.APPLICATION_JSON);
        return new ResponseEntity<>(user, httpHeaders, HttpStatus.CREATED);
    }
}