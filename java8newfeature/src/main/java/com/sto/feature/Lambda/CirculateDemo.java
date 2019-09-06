package com.sto.feature.Lambda;

import java.util.Arrays;
import java.util.List;

public class CirculateDemo {
    public static void main(String[] args){
        // Java 8之前：
        List<String> features=Arrays.asList("Lambdas", "Default Method", "Stream API", "Date and Time API");
        for (String feature : features) {
            System.out.println(feature);
        }

        // Java 8之后：
        List features1=Arrays.asList("Lambdas", "Default Method", "Stream API", "Date and Time API");
        features1.forEach(n -> System.out.println(n));
    }

}
