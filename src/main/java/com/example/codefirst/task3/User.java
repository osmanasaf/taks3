package com.example.codefirst.task3;

import javax.persistence.*;
import java.util.List;


@Entity
public class User {
    @Id
    @Column(unique = true)
    private String username;
    private String name;
    private String surname;
    private String password;
    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "UserRoles", joinColumns = {@JoinColumn(name = "username", referencedColumnName = "username")}, inverseJoinColumns = {@JoinColumn(name = "roleName", referencedColumnName = "name")})
    private List<Role> roles;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Role> getRoles() {
        return roles;
    }

    public void setRoles(List<Role> roles) {
        this.roles = roles;
    }

    public User(String username, String name, String surname, String password) {
        this.username = username;
        this.name = name;
        this.surname = surname;
        this.password = password;
    }

    public User() {

    }
}
