package cl.bigbytes.foodapp.domain;


import lombok.Data;

@Data
public class Item {
    private Integer id;
    private String name;
    private String description;
    private Double price;
}
