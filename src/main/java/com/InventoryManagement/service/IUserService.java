package com.InventoryManagement.service;

import com.InventoryManagement.model.entity.UserBE;
import com.InventoryManagement.model.request.UserRequest;

import java.util.List;

public interface IUserService {
    UserBE addUser(UserRequest userRequest);
    List<UserBE> getAllUser();
    UserBE getUserById(String id);
    boolean deleteUser(String id);
}
