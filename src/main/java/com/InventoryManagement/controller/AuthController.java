package com.InventoryManagement.controller;

import com.InventoryManagement.model.entity.UserBE;
import com.InventoryManagement.model.request.UserRequest;
import com.InventoryManagement.model.response.ErrorResponse;
import com.InventoryManagement.service.IUserService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.EntityModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PostAuthorize;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("users")
public class AuthController {
    @Autowired
    private IUserService iUserService ;

    @Operation(
            summary = "Register a new user" , responses = {
                    @ApiResponse(responseCode = "200" , description = "user successfully created" , content = @Content(mediaType = "application/json" ,
                    schema = @Schema(implementation = UserBE.class))),
            @ApiResponse(responseCode = "409" , description = "user already present" , content = @Content(mediaType = "application/json" ,
                    schema = @Schema(implementation = ErrorResponse.class))),
    }
    )
    @PostMapping("/register")
    public ResponseEntity<UserBE> addUser(@Valid @RequestBody UserRequest userRequest){
        UserBE userBE = iUserService.addUser(userRequest);
        return new ResponseEntity<>(userBE , HttpStatus.CREATED);
    }

    @GetMapping
    @PostAuthorize("hasRole('ADMIN')")
    public ResponseEntity<List<EntityModel<UserBE>>> getAlluser(){
        List<UserBE> allUser = iUserService.getAllUser();
        List<EntityModel<UserBE>> list = allUser.stream().map(
                userBE -> EntityModel.of(userBE)
        ).toList() ;

        return new ResponseEntity<>(list , HttpStatus.OK);
    }

    @GetMapping("/{id}")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<UserBE> getUserById(@PathVariable String id){
        UserBE userById = iUserService.getUserById(id);
        return new ResponseEntity<>(userById , HttpStatus.OK);
    }

    @DeleteMapping
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> deleteUser(@PathVariable String id){
        boolean user = iUserService.deleteUser(id);
        return new ResponseEntity<>(user , HttpStatus.NO_CONTENT);
    }


}
