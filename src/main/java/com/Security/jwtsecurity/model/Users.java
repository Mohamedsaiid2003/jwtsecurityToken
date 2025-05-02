package com.Security.jwtsecurity.model;

import jakarta.persistence.*;



@Entity
@Table(name = "users")
public class Users {
    @Id
//    @GeneratedValue(strategy = GenerationType.SEQUENCE )
    private int id;
    @Column(
            unique = true,
            name = "username",
            columnDefinition = "TEXT"
    )
    private String username;
    @Column(
            name = "password",
            columnDefinition = "TEXT"
    )
    private String password;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    @Override
    public String toString() {
        return "Users{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}
