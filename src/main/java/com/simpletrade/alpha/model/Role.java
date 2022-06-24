package com.simpletrade.alpha.model;

import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;

@Entity
@Table(name = "auth_role")
public class Role implements GrantedAuthority {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "auth_role_id")
    private int id;

    @Column(name = "role_name")
    private String role;

    public int getId() {
        return id;
    }

    public Role() {

    }

    public Role(int id, String role) {
        this.id = id;
        this.role = role;
    }

    @Override
    public String getAuthority() {
        return role;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof Role && ((Role) obj).getId() == getId();
    }
}