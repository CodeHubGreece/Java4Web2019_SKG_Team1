package org.regeneration.efka;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;


@Component
@Getter
@Setter
public class RegistrationData {
    private String username;
    private String password;
    private String first_name;
    private String last_name;
    private String phone_num;
    private String email;
    private int amka;
}
/*{
    "username": "",
    "password": "",
    "first_name": "",
    "last_name": "",
    "phone_num": "",
    "email": "",
    "amka": 1234
}*/
