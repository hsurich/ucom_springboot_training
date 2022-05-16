package com.uuu.demo.demo2;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("add")
public class AddCalculator implements Calculator {

    @Override
    public int calc(int a, int b) {
        return a+b;
    }
}
