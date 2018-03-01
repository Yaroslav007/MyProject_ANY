package com.alwaysnearyou.entity;

import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString(exclude = {"friends","friendOf"})
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

    @ManyToMany
    @JoinTable(name="friends",
            joinColumns=@JoinColumn(name="friend_id"),
            inverseJoinColumns=@JoinColumn(name="user_id")
    )
    private List<User> friendOf;

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


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        User user = (User) o;

        if (phone != user.phone) return false;
        if (active != user.active) return false;
        if (code != user.code) return false;
        if (!id.equals(user.id)) return false;
        if (!name.equals(user.name)) return false;
        if (!surname.equals(user.surname)) return false;
        if (!birthday.equals(user.birthday)) return false;
        if (!password.equals(user.password)) return false;
        if (!gender.equals(user.gender)) return false;
        if (!country.equals(user.country)) return false;
        if (!address.equals(user.address)) return false;
        if (!email.equals(user.email)) return false;
        return avatar.equals(user.avatar);
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + name.hashCode();
        result = 31 * result + surname.hashCode();
        result = 31 * result + birthday.hashCode();
        result = 31 * result + password.hashCode();
        result = 31 * result + gender.hashCode();
        result = 31 * result + country.hashCode();
        result = 31 * result + address.hashCode();
        result = 31 * result + email.hashCode();
        result = 31 * result + phone;
        result = 31 * result + avatar.hashCode();
        result = 31 * result + (active ? 1 : 0);
        result = 31 * result + code;
        return result;
    }
}
