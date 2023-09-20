/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.security.AuthenticatedBackend.models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.Table;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

/**
 *
 * @author bas200181
 */
@Entity
@Table(name = "userss")
public class AppUser  implements UserDetails{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    private Integer userid;
    private String username;
    private String password;
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "user_role_junction",joinColumns = {@JoinColumn(name = "user_id")},inverseJoinColumns =  {@JoinColumn (name = "role_id")}  )
    private Set<Role> authorities;

    public void setUserid(Integer userid) {
        this.userid = userid;
    }

    public AppUser() {
        super();
        this.authorities=new HashSet<Role>();
             
    }

    public AppUser(Integer userid, String username, String password, Set<Role> authorities) {
       super(); 
        this.userid = userid;
        this.username = username;
        this.password = password;
        this.authorities = authorities;
    }
    

    public void setUsername(String username) {
        this.username = username;
    }

 
    public void setPassword(String password) {
        this.password = password;
    }
    

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
return  this.authorities;
        }

    @Override
    public String getPassword() {
return  this.password;
    }

    @Override
    public String getUsername() {
return this.username;
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
return true;    }

    @Override
    public boolean isEnabled() {
return true;    }
    
    
}
