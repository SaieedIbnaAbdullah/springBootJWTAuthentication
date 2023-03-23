package jwt.com.example.demo.jwt.service;

import jwt.com.example.demo.jwt.dto.UserDto;
import jwt.com.example.demo.jwt.models.UserEntity;
import jwt.com.example.demo.jwt.repository.RegistrationRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RegistrationService {
    private final RegistrationRepository registrationRepository;

    public RegistrationService(RegistrationRepository registrationRepository) {
        this.registrationRepository = registrationRepository;
    }

    public UserEntity userDtoToUserEntityMap(UserDto userDto){
        UserEntity userEntity = new UserEntity();
        userEntity.setEnabled(userDto.getEnabled());
        userEntity.setNid(userDto.getNid());
        userEntity.setImage(userDto.getImage());
        userEntity.setAgentId(userDto.getAgentId());
        userEntity.setAgentName(userDto.getAgentName());
        userEntity.setSyndicate_id(userDto.getSyndicate_id());
        userEntity.setMobile_number(userDto.getMobile_number());
        return userEntity;
    }

    public UserEntity registerNewAgent(UserDto userDto) {
        UserEntity userEntity=userDtoToUserEntityMap(userDto);
        Optional<UserEntity> userExist = registrationRepository.findByAgentId(userEntity.getAgentId());
        if (userExist.isPresent() && userExist.get().getEnabled() == true){
            throw new RuntimeException("User already exist & enabled");
        }
        else{
            userDto.setEnabled(false);
            UserEntity user = userDtoToUserEntityMap(userDto);
            UserEntity userSave = registrationRepository.save(user);
            return userSave;
        }
    }
}
