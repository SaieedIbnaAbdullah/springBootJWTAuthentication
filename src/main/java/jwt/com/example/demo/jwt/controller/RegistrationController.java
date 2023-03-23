package jwt.com.example.demo.jwt.controller;

import jwt.com.example.demo.jwt.dto.UserDto;
import jwt.com.example.demo.jwt.models.UserEntity;
import jwt.com.example.demo.jwt.service.RegistrationService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/agent-registration")
public class RegistrationController {
    private final RegistrationService registrationService;

    public RegistrationController(RegistrationService registrationService) {
        this.registrationService = registrationService;
    }

    @PostMapping
    public ResponseEntity<UserEntity> registerAgent(@RequestBody UserDto userDto){
        UserEntity user = registrationService.registerNewAgent(userDto);
        return new ResponseEntity<>(user, HttpStatus.CREATED);
    }
}
