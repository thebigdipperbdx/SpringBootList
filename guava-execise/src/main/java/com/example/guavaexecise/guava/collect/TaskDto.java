package com.example.guavaexecise.guava.collect;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

/**
 * @author yanyugang
 * @description
 * @date 2019-11-22 14:41
 */
@Builder
@Getter
@Setter
public class TaskDto {
    private String taskNo;
    private String driverName;
    private String vehicleLicense;
}
