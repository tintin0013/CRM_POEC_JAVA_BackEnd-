package com.Certif.SlackLike.model;

import jakarta.persistence.*;

@Entity
@Table(name="users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)


    private Integer id;

    @Column(name="first_name" , nullable = false,length = 50)
    private String firstName ;

    @Column(name="last_name" , nullable = false,length = 50)
    private String lastName ;

    @Column(nullable = false,length = 50)
    private String nickname ;

    @Enumerated(EnumType.ORDINAL)
    @Column(nullable = false, columnDefinition = "int4")
//    private Integer status;
    private UserStatus status;


    public User() {
    }

    public User(String firstName, String lastName, String nickname, UserStatus status) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.nickname = nickname;
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public UserStatus getStatus() {
        return status;
    }

    public void setStatus(UserStatus status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", nickname='" + nickname + '\'' +
                ", status=" + status +
                '}';
    }
}
