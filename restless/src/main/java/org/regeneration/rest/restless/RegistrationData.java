package org.regeneration.rest.restless;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Getter
@Setter
@NoArgsConstructor
@Component
public class RegistrationData {
    private String username;
    private String password;
    private String first_name;
    private String last_name;
    private String phone_num;
    private String email;
    private int amka;
}
