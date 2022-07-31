package com.annauniv.server.relational;

import javax.persistence.*;

import com.annauniv.server.authority.UserAccountDesignation;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Collections;
import java.util.Set;

@Entity(name = "User")
@NoArgsConstructor
public class UserAccount implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String password;

    @Enumerated(EnumType.STRING)
    private UserAccountDesignation designation;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return designation.getGrantedAuthorities();
    }

    @Override
    public String getUsername() {
        return Long.toString(id);
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UserAccountDesignation getDesignation() {
        return designation;
    }

    public void setDesignation(UserAccountDesignation designation) {
        this.designation = designation;
    }

    public Set<GrantedAuthority> getGrantedAuthorities () {
        return Collections.emptySet();
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public UserAccount(String name, String password, UserAccountDesignation designation) {
        this.name = name;
        this.password = password;
        this.designation = designation;
    }
}