package com.sto.arithmetic;

import java.util.Arrays;

/**
 * @author yanyugang
 * @description 直接插入排序
 * @date 2019-10-21 10:08
 */
public class InsertSort {

    public static void insertSort(int[] array){
        //第0位独自作为有序数列，从第1位开始向后遍历
        for (int i=1; i < array.length; i++) {
            //0~i-1位为有序，若第i位小于i-1位，继续寻位并插入，否则认为0~i位也是有序的，忽略此次循环，相当于continue
            if (array[i] < array[i - 1]){
                //保存第i位的值
                int temp=array[i];
                int j=i - 1;
                //从第i-1位向前遍历并移位，直至找到小于第i位值停止
                while (j >= 0 && temp < array[j]) {
                    array[j + 1]=array[j];
                    j--;
                }
                //插入第i位的值
                array[j + 1]=temp;
            }
        }
    }

    public static void main(String[] args){
        int[] arr={9, 6, 7, 4, 15, 3, 2, 1};
        insertSort(arr);
        System.out.println(Arrays.toString(arr));
    }


}
