package com.Security.jwtsecurity.service;

import com.Security.jwtsecurity.model.Users;
import com.Security.jwtsecurity.repo.UserRepo;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;


@Service
public class UserService {
    @Autowired
    private UserRepo userRepo;
    @Autowired
    private JWTService jwtService;
    @Autowired
    AuthenticationManager authMAnager;

    private BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

    public Users register(Users user){
        user.setPassword(encoder.encode(user.getPassword()));
       return userRepo.save(user);
    }

    public String verify(Users users) {
        Authentication authentication =
                authMAnager.authenticate(new UsernamePasswordAuthenticationToken(users.getUsername(),users.getPassword()));
        if(authentication.isAuthenticated()){
            return jwtService.generateToken(users.getUsername());
        }
        return "fail";
    }
}
