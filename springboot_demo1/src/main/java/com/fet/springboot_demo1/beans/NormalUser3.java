package com.fet.springboot_demo1.beans;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotBlank;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NormalUser3 {
    @NotBlank(message = "Name can not be blank!!")
    private String name;
}
