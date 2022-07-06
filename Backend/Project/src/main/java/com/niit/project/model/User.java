package com.niit.project.model;


import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Document
public class User {


    private int id;
    private String name;
    private String email;
    private String password;

}
