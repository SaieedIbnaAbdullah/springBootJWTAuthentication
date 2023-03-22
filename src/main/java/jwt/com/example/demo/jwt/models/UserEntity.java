package jwt.com.example.demo.jwt.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name="user",  schema = "ekpay_agent")
public class UserEntity {
    @Id
    private Integer agentId;
    private String agentName;
    @Column(length = 8)
    private String mobile_number;
    @Column(length = 17)
    private String nid;
    private String password;
    private Boolean enabled;
    private String syndicate_id;
    @Column(columnDefinition = "TEXT")
    private String image;
}
