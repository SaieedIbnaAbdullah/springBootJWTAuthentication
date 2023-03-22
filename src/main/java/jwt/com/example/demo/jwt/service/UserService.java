package jwt.com.example.demo.jwt.service;

import jwt.com.example.demo.jwt.models.UserEntity;
import jwt.com.example.demo.jwt.repository.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepository userRepository;
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }
    public UserEntity createPassword(UserEntity userEntity) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        String encodePass = passwordEncoder.encode(userEntity.getPassword());
        userEntity.setPassword(encodePass);
        return userRepository.save(userEntity);
    }
}
