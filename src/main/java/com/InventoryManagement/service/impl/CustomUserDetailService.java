package com.InventoryManagement.service.impl;

import com.InventoryManagement.exception.UserCustomException;
import com.InventoryManagement.model.entity.UserBE;
import com.InventoryManagement.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

import static com.InventoryManagement.constants.InventoryConstants.USER_NOT_FOUND;


@Service
public class CustomUserDetailService implements UserDetailsService {
    @Autowired
    private IUserRepository iUserRepository ;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Optional<UserBE> userBE = iUserRepository.findByEmail(email);
        if(userBE.isEmpty()){
            throw new UserCustomException(USER_NOT_FOUND , HttpStatus.NOT_FOUND);
        }

        return User.builder()
                .username(userBE.get().getEmail())
                .password(userBE.get().getPassword())
                .roles(userBE.get().getRole().name().replace("ROLE_" , ""))
                .build();
    }
}
