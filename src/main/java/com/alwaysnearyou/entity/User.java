package com.alwaysnearyou.entity;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;
    private String surname;
    private String birthday;
    private String passward;
    private String gender;
    private String country;
    private String adress;
    private String email;
    private int phone;
    private String avatar;


    public User(String name, String surname,
                String birthday, String passward,
                String gender, String country,
                String adress, String email,
                int phone, String avatar) {
        this.name = name;
        this.surname = surname;
        this.birthday = birthday;
        this.passward = passward;
        this.gender = gender;
        this.country = country;
        this.adress = adress;
        this.email = email;
        this.phone = phone;
        this.avatar = avatar;
    }
}
