package com.example.demopr.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Supplier {
    private int id;
    private String type;
    private String name;
    private String director;
    private String email;
    private String phone;
    private String address;
    private String inn;
    private int rating;
}
