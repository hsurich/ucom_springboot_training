package com.fet.springboot_demo1;

import com.fet.springboot_demo1.beans.NormalUser2;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

public class BeansValidatorTest2 {
    private static Validator validator;

    @BeforeAll
    public static void setupValidatorInstance() {
        validator = Validation.buildDefaultValidatorFactory().getValidator();
    }

    @Test
    public void test1() {
        NormalUser2 user1 = new NormalUser2("John");
        Set<ConstraintViolation<NormalUser2>> violations= validator.validate(user1);
        assertThat(violations.size()).isEqualTo(0);
    }

    @Test
    public void test2() {
        NormalUser2 user1 = new NormalUser2("");
        Set<ConstraintViolation<NormalUser2>> violations = validator.validate(user1);
        for(ConstraintViolation<NormalUser2> violation:violations) {
            System.out.println(violation.getMessage());
        }
        assertThat(violations.size()).isEqualTo(1);
    }

    @Test
    public void test3() {
        NormalUser2 user1 = new NormalUser2();
        Set<ConstraintViolation<NormalUser2>> violations = validator.validate(user1);
        for(ConstraintViolation<NormalUser2> violation:violations) {
            System.out.println(violation.getMessage());
        }
        assertThat(violations.size()).isEqualTo(1);
    }

    @Test
    public void test4() {
        NormalUser2 user1 = new NormalUser2("      ");
        Set<ConstraintViolation<NormalUser2>> violations = validator.validate(user1);
        assertThat(violations.size()).isEqualTo(0);
    }
}
