package com.me.guava.collect;

import com.sun.istack.internal.Nullable;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @author yanyugang
 * @description
 * @date 2019-11-16 17:13
 */
@Builder
@Getter
@Setter
@ToString
public class Foo {
    @Nullable
    String sortedBy;
    int notSortedBy;
}
