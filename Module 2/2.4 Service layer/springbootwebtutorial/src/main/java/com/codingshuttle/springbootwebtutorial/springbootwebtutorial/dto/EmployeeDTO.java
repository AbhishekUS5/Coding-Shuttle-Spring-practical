package com.codingshuttle.springbootwebtutorial.springbootwebtutorial.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor

public class EmployeeDTO {
    private Long id;
    private String name;
    private String email;
    private Integer age;
    private LocalDate dateOfJoining;
    @JsonProperty("isActive")
    private Boolean isActive;

    // Jackson tries to serialize and deserialize the data back to java objects.
    // it is trying to convert the active to JSON string and then JSON string back to the object
    // if you want to pass the data inside your JSON inside your postman we have ot use the isActive
    // mapping and inside the java code we can use this variable(isActive) but then you have to update the variable isActive
}