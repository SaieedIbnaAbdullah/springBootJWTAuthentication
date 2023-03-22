package jwt.com.example.demo.jwt.service;

import jwt.com.example.demo.jwt.models.MyUserDetails;
import jwt.com.example.demo.jwt.models.UserEntity;
import jwt.com.example.demo.jwt.repository.UserRepository;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
@Service
public class MyUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    public MyUserDetailsService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String userName) throws UsernameNotFoundException {
        UserEntity user = userRepository.findByAgentId(userName).orElseThrow(()->new UsernameNotFoundException("Invalid user"));
        return new MyUserDetails(user);
    }
}
