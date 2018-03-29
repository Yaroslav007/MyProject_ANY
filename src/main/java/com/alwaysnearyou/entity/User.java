package com.alwaysnearyou.entity;



import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity

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
            inverseJoinColumns=@JoinColumn(name="user_id"))
    private List<User> friendOf;

    @ManyToMany(fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    @JoinTable(name = "room_user",
            joinColumns = @JoinColumn(name = "user_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "room_id", referencedColumnName = "id"))
    private List<Room> rooms;


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

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getPhone() {
        return phone;
    }

    public void setPhone(int phone) {
        this.phone = phone;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public List<User> getFriends() {
        return friends;
    }

    public void setFriends(List<User> friends) {
        this.friends = friends;
    }

    public List<User> getFriendOf() {
        return friendOf;
    }

    public void setFriendOf(List<User> friendOf) {
        this.friendOf = friendOf;
    }

    public List<Room> getRooms() {
        return rooms;
    }

    public void setRooms(List<Room> rooms) {
        this.rooms = rooms;
    }
}
