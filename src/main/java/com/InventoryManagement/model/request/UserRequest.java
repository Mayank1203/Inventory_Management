package com.InventoryManagement.model.request;

import com.InventoryManagement.model.enums.Role;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class UserRequest {
    @NotNull
    @NotBlank
    @Size(min = 3 , max = 100)
    private String userName;

    @NotNull
    @Email
    @NotBlank
    @Size(min = 3 , max = 50)
    private String email;

    @NotNull
    @NotBlank
    @Size(min = 8 , max = 20)
    private String password;

    @NotNull
    private Role role;
}
