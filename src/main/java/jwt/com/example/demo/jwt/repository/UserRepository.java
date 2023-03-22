package jwt.com.example.demo.jwt.repository;


import jwt.com.example.demo.jwt.models.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepository extends JpaRepository<UserEntity, String> {
    Optional<UserEntity> findByAgentId(String agentId);
}
