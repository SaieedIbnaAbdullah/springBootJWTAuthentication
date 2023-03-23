package jwt.com.example.demo.jwt.repository;

import jwt.com.example.demo.jwt.models.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RegistrationRepository extends JpaRepository<UserEntity, String> {
    Optional<UserEntity> findByAgentId(String agentId);
}
