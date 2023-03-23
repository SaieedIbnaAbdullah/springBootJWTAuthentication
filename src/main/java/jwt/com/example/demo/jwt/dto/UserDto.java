package jwt.com.example.demo.jwt.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
    private String agentId;
    private String agentName;
    private String mobile_number;

    private String nid;
    private String password;
    private Boolean enabled;
    private String syndicate_id;

    private String image;
}
