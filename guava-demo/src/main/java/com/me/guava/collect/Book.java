package com.me.guava.collect;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

/**
 * @author yanyugang
 * @description
 * @date 2019-11-09 16:45
 */
@Builder
@Getter
@Setter
public class Book {
    private String author;
    private String title;
    private String publisher;
    private String isbn;
    private double price;

}
