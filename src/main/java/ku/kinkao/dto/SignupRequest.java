package ku.kinkao.dto;

import lombok.Data;

@Data
public class SignupRequest {
    private String username;
    private String password;
    private String firstName;
    private String lastName;
}
