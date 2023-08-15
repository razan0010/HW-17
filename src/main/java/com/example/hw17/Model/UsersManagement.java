package com.example.hw17.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class UsersManagement {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer ID;

    @NotEmpty(message = "Name should be not null")
    @Size(min = 4, message = "Name length should be more than 4")
    @Column(columnDefinition = "varchar(13) not null")
    private String name;

    @NotEmpty(message = "Username should be not null")
    @Size(min = 6, message = "Username length should be more than 6")
    @Column(columnDefinition = "varchar(20) not null unique")
    private String username;

    @NotEmpty(message = "Password should be not null")
    @Column(columnDefinition = "varchar(20) not null")
    private String password;

    @NotEmpty(message = "Email should be not null")
    @Column(columnDefinition = "varchar(40) not null unique")
    @Email(message = "must be valid email")
    private String email;

    @Column(columnDefinition = " varchar(5) check( role='admin' or role = 'user' ) not null")
    @NotEmpty(message = "Role should be not null")
    @Pattern(regexp ="\\b(user|admin)\\b" , message = "Role must be user or admin only")
    private String role;

    @NotNull(message = "Age should be not null")
    @Positive(message = "Age must be integer")
    @Column(columnDefinition = "int not null")
    private Integer age;


}
