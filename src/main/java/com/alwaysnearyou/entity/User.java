package com.alwaysnearyou.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString(exclude = "friends")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String name;
    private String surname;
    private String birthday;
    private String password;
    private String gender;
    private String country;
    private String address;
    private String email;
    private int phone;
    private String avatar;
    private boolean active = false;
    private int code;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name="friends",
            joinColumns=@JoinColumn(name="user_id"),
            inverseJoinColumns=@JoinColumn(name="friend_id"))
    private List<User> friends;

//    @ManyToMany
//    @JoinTable(name="friends",
//            joinColumns=@JoinColumn(name="friend_id"),
//            inverseJoinColumns=@JoinColumn(name="user_id")
//    )
//    private List<User> friendOf;

//    public User(String name, String surname,
//                String birthday, String passward,
//                String gender, String country,
//                String adress, String email,
//                int phone, String avatar) {
//        this.name = name;
//        this.surname = surname;
//        this.birthday = birthday;
//        this.password = passward;
//        this.gender = gender;
//        this.country = country;
//        this.address = adress;
//        this.email = email;
//        this.phone = phone;
//        this.avatar = avatar;
//    }

}
