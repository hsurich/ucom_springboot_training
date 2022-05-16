package com.uuu.demo.demo2;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
@Qualifier("sub")
public class SubCalculator implements Calculator {
    @Override
    public int calc(int a, int b) {
        return a - b;
    }

}
