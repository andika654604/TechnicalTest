/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.id.mii.serverside.service;

import co.id.mii.serverside.model.User;
import co.id.mii.serverside.model.dto.LoginData;
import co.id.mii.serverside.model.dto.LoginResponseData;
import co.id.mii.serverside.repository.UserRepository;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

/**
 *
 * @author Vino
 */
@Service
public class LoginService {
    private AppUserDetailService appUserDetailService;
    private UserRepository userRepository;
    private AuthenticationManager authenticationManager;

    @Autowired
    public LoginService(AppUserDetailService appUserDetailService, UserRepository userRepository, AuthenticationManager authenticationManager) {
        this.appUserDetailService = appUserDetailService;
        this.userRepository = userRepository;
        this.authenticationManager = authenticationManager;
    }
  
    public LoginResponseData login(LoginData loginData){
        UsernamePasswordAuthenticationToken autoReq = new UsernamePasswordAuthenticationToken(loginData.getUsername(), loginData.getPassword());
        Authentication auth = authenticationManager.authenticate(autoReq);
        SecurityContext sc = SecurityContextHolder.getContext();
        sc.setAuthentication(auth);
        
        UserDetails userDetails = appUserDetailService.loadUserByUsername(loginData.getUsername());
        
        List<String> authorities = userDetails.getAuthorities()
                .stream().map(authority -> authority.getAuthority())
                .collect(Collectors.toList());
       
        User user = userRepository.findByUsernameOrEmployee_Email(loginData.getUsername(), loginData.getUsername()).get();
        
        return new LoginResponseData(user.getUsername(), user.getEmployee().getEmail(), user.getEmployee().getAddress(), authorities);
    }
}

