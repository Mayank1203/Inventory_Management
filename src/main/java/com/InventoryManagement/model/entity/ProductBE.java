package com.InventoryManagement.model.entity;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
@AllArgsConstructor

@Document(collection = "product")
public class ProductBE {

    @NotNull
    @Schema(description = "This is unique id of product")
    private String id;

    @NotNull
    @Schema(description = "This is product name" , example = "moto-charger")
    private String name ;

    @NotNull
    private String description;

    @NotNull
    private String price ;

    @NotNull
    private Integer stockQuantity ;

}
