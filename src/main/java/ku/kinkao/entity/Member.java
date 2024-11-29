package ku.kinkao.entity;

import lombok.Data;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import java.time.Instant;
import java.util.UUID;
import ku.kinkao.config.AttributeEncryptor;
import jakarta.persistence.Convert;


@Data
@Entity
public class Member {


    @Id
    @GeneratedValue
    private UUID id;


    private String username;
    private String password;


    @Convert(converter = AttributeEncryptor.class)
    private String firstName;


    @Convert(converter = AttributeEncryptor.class)
    private String lastName;


    @Convert(converter = AttributeEncryptor.class)
    private String email;


    private String role;
    private Instant createdAt;
}


