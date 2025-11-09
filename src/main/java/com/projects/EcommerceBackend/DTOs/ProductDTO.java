package com.projects.EcommerceBackend.DTOs;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ProductDTO {

    private Integer id;
    private String title;
    private float price;
    private String description;
    private String category;
    private String image;
    private Rating rating;

    @Setter
    @Getter
    public static class Rating {
        private double rate;
        private int count;

    }

}
