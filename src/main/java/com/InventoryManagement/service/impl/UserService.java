package com.InventoryManagement.service.impl;

import com.InventoryManagement.exception.UserCustomException;
import com.InventoryManagement.model.entity.UserBE;
import com.InventoryManagement.model.request.UserRequest;
import com.InventoryManagement.repository.IUserRepository;
import com.InventoryManagement.service.IUserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import static com.InventoryManagement.constants.InventoryConstants.USER_NOT_FOUND;

@Service
public class UserService implements IUserService {

    @Autowired
    private IUserRepository iUserRepository ;
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public UserBE addUser(UserRequest userRequest) {
        String encodePassword = passwordEncoder.encode(userRequest.getPassword());
        UserBE userBE = modelMapper.map(userRequest, UserBE.class);
        userBE.setPassword(encodePassword);
        return iUserRepository.save(userBE);
    }

    @Override
    public List<UserBE> getAllUser() {
        return iUserRepository.findAll();
    }

    @Override
    public UserBE getUserById(String id) {
        Optional<UserBE> userBE = iUserRepository.findById(id);
        if(userBE.isEmpty()){
            throw new UserCustomException(USER_NOT_FOUND  , HttpStatus.NOT_FOUND);
        }
        return userBE.get();
    }

    @Override
    public boolean deleteUser(String id) {
        Optional<UserBE> userBE = iUserRepository.findById(id);
        if(userBE.isEmpty()){
            throw new UserCustomException(USER_NOT_FOUND , HttpStatus.NOT_FOUND);
        }

        iUserRepository.deleteById(id);
        return true;
    }
}
