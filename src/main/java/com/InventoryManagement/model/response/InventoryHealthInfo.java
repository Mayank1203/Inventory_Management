package com.InventoryManagement.model.response;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class InventoryHealthInfo {
    private Integer activeUsers ;
    private long uptimeSecond ;
    private String serverStatus ;
}
