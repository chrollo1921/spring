package com.springbootsecurity.model;

import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class User {

    private String user;
    private String password;
    private String email;

}
