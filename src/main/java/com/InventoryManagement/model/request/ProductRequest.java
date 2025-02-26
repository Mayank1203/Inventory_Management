package com.InventoryManagement.model.request;

import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductRequest {

    @NotNull
    @NotBlank
    @Size(min = 3 , max = 100)
    private String name ;

    @NotNull
    @NotBlank
    @Size(min = 3 , max = 1000)
    private String description ;

    @NotNull
    @Digits(integer = 10 , fraction = 2)
    @DecimalMin(value = "0.0" , inclusive = false)
    private double price ;

    @NotNull
    @Min(value = 0)
    @Digits(integer = 10 , fraction = 0)
    private Integer stockQuantity ;
}
