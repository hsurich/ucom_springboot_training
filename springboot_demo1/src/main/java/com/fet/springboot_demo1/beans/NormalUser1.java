package com.fet.springboot_demo1.beans;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class NormalUser1 {
    @NotNull(message = "Name can not be null!!")
    private String name;
}
