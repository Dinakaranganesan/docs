 /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.security.AuthenticatedBackend.usersservice;

import com.security.AuthenticatedBackend.models.AppUser;
import com.security.AuthenticatedBackend.models.Role;
import java.util.HashSet;
import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

/**
 *
 * @author bas200181
 */
@Service
public class UserService implements UserDetailsService {
@Autowired
private PasswordEncoder encoder;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
if(!username.equals("Ethan")) throw new UsernameNotFoundException("Not Ethan");
Set<Role> roles=new HashSet<>();
roles.add(new Role(1, "USER"));
return new AppUser(1, "Ethan", encoder.encode("password"), roles);
     }
    
}
