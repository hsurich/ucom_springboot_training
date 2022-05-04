package com.fet.springboot_demo1;

import com.fet.springboot_demo1.beans.NormalUser1;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

public class BeansValidatorTest1 {
    private static Validator validator;

    @BeforeAll
    public static void setupValidatorInstance() {
        validator = Validation.buildDefaultValidatorFactory().getValidator();
    }

    @Test
    public void test1() {
        NormalUser1 user1 = new NormalUser1("John");
        Set<ConstraintViolation<NormalUser1>> violations= validator.validate(user1);
        assertThat(violations.size()).isEqualTo(0);
    }

    @Test
    public void test2() {
        NormalUser1 user1 = new NormalUser1("");
        Set<ConstraintViolation<NormalUser1>> violations = validator.validate(user1);
        assertThat(violations.size()).isEqualTo(0);
    }

    @Test
    public void test3() {
        NormalUser1 user1 = new NormalUser1();
        Set<ConstraintViolation<NormalUser1>> violations = validator.validate(user1);
        for(ConstraintViolation<NormalUser1> violation:violations) {
            System.out.println(violation.getMessage());
        }
        assertThat(violations.size()).isEqualTo(1);
    }
}
