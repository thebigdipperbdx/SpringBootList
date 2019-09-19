package com.sto.arithmetic;

import java.util.Arrays;

/**
 * @author yanyugang
 * @description 冒泡排序
 * @date 2019-09-18 19:50
 */
public class BubbleSort {
    public static void bubbleSort(int[] arr){
        // 总共arr.length - 1轮
        for (int i=0; i < arr.length - 1; i++) {
            // 每轮比较arr.length - i - 1次
            for (int j=0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j + 1]){
                    int temp=arr[j];
                    arr[j]=arr[j + 1];
                    arr[j + 1]=temp;
                }
            }
        }
    }

    public static void main(String[] args){
        int[] arr={9, 6, 7, 4, 5, 3, 2, 1};
        bubbleSort(arr);
        System.out.println(Arrays.toString(arr));
    }
}
