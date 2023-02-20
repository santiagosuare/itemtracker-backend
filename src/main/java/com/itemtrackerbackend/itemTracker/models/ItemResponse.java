package com.itemtrackerbackend.itemTracker.models;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ItemResponse {

    public ItemResponse(List<ItemResponse> itemResponseList){
    }

    private Long id;

    private String name;

    private Long price;

    private String urlImage;

    private Long stock;

}
