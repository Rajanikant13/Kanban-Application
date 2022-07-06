package com.niit.notification.model;

import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
@Document
public class UserDetails {


    private String name;
    private String email;
    private String message;

}
