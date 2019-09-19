package com.sto.arithmetic;

import java.util.Arrays;

/**
 * @author yanyugang
 * @description 二分法查找
 * 算法：二分法查找适用于数据量较大时，但是数据需要先排好顺序
 * 现要求采用二分法找出指定的数值并将其在数组的索引返回，如果没有找到则返回 -1
 * @date 2019-09-18 17:53
 */
public class BinarySearch {
    public static int search(int[] arr, int key){
        int low=0;
        int high=arr.length - 1;
        while (low <= high) {
            //取中间索引
            int mid=(low + high) / 2;
            long midVal=arr[mid];
            //如果中间值小于key值则key在高位
            if (midVal < key){
                low=mid + 1;
            }else if (midVal > key){
                //如果中间值大于key值则key在低位
                high=mid - 1;
            }else {
                // 找到，返回索引位置
                return mid;
            }

        }
        // 没有找到，返回 -1
        return -1;
    }

    public static void main(String[] args){
        int[] arr={9, 6, 7, 4, 5, 3, 2, 1};
        //需先将待搜索的数组进行排序
        Arrays.sort(arr);//[1, 2, 3, 4, 5, 6, 7, 9]
        System.out.println(Arrays.toString(arr));
        int index=search(arr, 9);
        System.out.println(index);
    }
}
