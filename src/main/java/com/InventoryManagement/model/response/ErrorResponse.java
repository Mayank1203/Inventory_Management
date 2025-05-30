package com.InventoryManagement.model.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;


@Data
@NoArgsConstructor
@AllArgsConstructor
public class ErrorResponse {
    private String error ;
    private String message ;
    private String statusCode ;
    private LocalDateTime timestamp ;
}
