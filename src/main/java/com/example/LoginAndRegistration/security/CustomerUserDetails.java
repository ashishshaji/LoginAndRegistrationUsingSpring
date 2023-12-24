package com.example.LoginAndRegistration.security;

import com.example.LoginAndRegistration.entity.User;
import com.example.LoginAndRegistration.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;

// UserDetailsService is an interface in Spring Security that defines a method for loading user-specific data, such as username, password, and authorities.
@Service
public class CustomerUserDetails implements UserDetailsService {

    @Autowired
    UserRepo userRepo;

    List<GrantedAuthority> authorities = Arrays.asList(new SimpleGrantedAuthority("ROLE_USER"));


    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {

        User user = userRepo.findByEmail(email);

        if (user != null) {
            System.out.println(user);
            return new org.springframework.security.core.userdetails.User(user.getEmail(),
                    user.getPassword(),
                    authorities);
        }else{
            throw new UsernameNotFoundException("Invalid username or password.");
        }
    }

}
