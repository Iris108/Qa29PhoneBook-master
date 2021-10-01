package models;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
@ToString
public class Contact {

    String name;
    String lastname;
    String phone;
    String email;
    String address;
    String description;
}

