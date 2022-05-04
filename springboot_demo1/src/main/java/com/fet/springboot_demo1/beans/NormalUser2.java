package com.fet.springboot_demo1.beans;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotEmpty;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NormalUser2 {
    @NotEmpty(message = "Name can not be empty!!")
    private String name;
}
