package com.sto.arithmetic;

/**
 * @author yanyugang
 * @description 快速排序
 * @date 2019-10-16 18:32
 */
public class QuickSort {
    public static int[] qsort(int[] arr, int start, int end){
        if (start < end){
            // 选定的基准值（第一个数值作为基准值）
            int base=arr[start];
            // 记录临时中间值
            int temp;
            int i=start, j=end;
            do {
                while ((arr[i] < base) && (i < end)) {
                    i++;
                }
                while ((arr[j] > base) && (j > start)) {
                    j--;
                }
                if (i <= j){
                    temp=arr[i];
                    arr[i]=arr[j];
                    arr[j]=temp;
                    i++;
                    j--;
                }
            } while (i <= j);
            if (start < j){
                qsort(arr, start, j);
            }
            if (end > i){
                qsort(arr, i, end);
            }
        }
        return arr;
    }

    public static void main(String[] args){
        int[] arr=new int[]{3, 3, 3, 7, 9, 122344, 4656, 34, 34, 4656, 5, 6, 7, 8, 9, 343, 57765, 23, 12321};
        int len=arr.length - 1;
        arr=qsort(arr, 0, len);
        for (int i : arr) {
            System.out.print(i + "\t");
        }
    }

}
