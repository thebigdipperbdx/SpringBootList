package com.me.guava.collect;

import com.google.common.base.Function;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.common.collect.Sets;

import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author yanyugang
 * @description
 * Static utility methods pertaining to {@link Map} instances
 * @date 2019-11-09 16:52
 */
public class MapsTest {
    static Book book=new Book.BookBuilder().isbn("ISBN123").title("book1").build();
    static Book book2=new Book.BookBuilder().isbn("ISBN456").title("book2").build();
    static Book book3=new Book.BookBuilder().isbn("ISBN789").title("book3").build();
    static List<Book> books=Lists.newArrayList(book, book2, book3);


    public static void main(String[] args){
        setToMap();
    }

    /**
     * List 转 Map
     */
    public static void listToMap(){

        Map<Object, Book> bookMap=Maps.uniqueIndex(books, book1 -> book1.getIsbn());

        bookMap.forEach((key, value) -> {
            System.out.println(key);
            System.out.println(value.getTitle());
        });
    }

    /**
     * Set 转 Map
     * Returns a live {@link Map} view whose keys are the contents of {@code set}
     * and whose values are computed on demand using {@code function}.
     */
    public static void setToMap(){
        Set<Book> bookSet=Sets.newHashSet(books);
        Map<Book, String> bookMap=Maps.asMap(bookSet, input -> input.getIsbn());
        System.out.println(bookMap.size());
        bookMap.forEach((key, value) -> {
            System.out.println(key.getTitle());
            System.out.println(value);
        });
    }


}
