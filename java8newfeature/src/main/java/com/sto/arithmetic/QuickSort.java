package com.sto.arithmetic;

/**
 * @author yanyugang
 * @description 快速排序
 * 1、先从数列中取出一个数作为基准数
 * 2、分区过程，将比这个数大的数全放到它的右边，小于或等于它的数全放到它的左边
 * 3、再对左右区间重复第二步，直到各区间只有一个数
 *
 * 挖坑填数+分治法
 * @date 2019-10-16 18:32
 */
public class QuickSort {

    public static void quickSort(int s[], int left, int right){
        if (left < right){
            // 左边下标位置
            int i=left;
            // 右边下标位置
            int j=right;
            // 基准元素
            int x=s[left];
            while (i < j) {
                // 从右向左找第一个小于x的数
                while (i < j && s[j] >= x) {
                    j--;
                }
                // 将数填到坑里
                if (i < j){
                    s[i++]=s[j];
                }

                // 从左向右找第一个大于等于x的数
                while (i < j && s[i] < x) {
                    i++;
                }
                // 将数填到坑里
                if (i < j){
                    s[j--]=s[i];
                }

            }
            // 将基准数填到坑里
            s[i]=x;
            //此时，i左侧的都比x小，i右侧的都比x大，以i为界，递归调用
            quickSort(s, left, i - 1);
            quickSort(s, i + 1, right);
        }
    }

    public static void main(String[] args){
        int[] arr= new int[]{3,3,3,7,9,122344,4656,34,34,4656,5,6,7,8,9,343,57765,23,12321};
        quickSort(arr, 0, arr.length - 1);
        for (int i : arr) {
            System.out.print(i + "\t");
        }
    }

}
