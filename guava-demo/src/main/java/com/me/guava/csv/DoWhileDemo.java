package com.me.guava.csv;

/**
 * @author yanyugang
 * @description ${todo}
 * @date 2019-12-14 11:39
 */
public class DoWhileDemo {
    public static void main(String[] args){

        int[][] arrayOfInts={
                {32, 87, 3, 589},
                {12, 1076, 2000, 8},
                {622, 127, 77, 955}
        };
        int searchfor=12;

        int i;
        int j=0;
        boolean foundIt=false;

        search:
        for (i=0; i < arrayOfInts.length; i++) {
            for (j=0; j < arrayOfInts[i].length;
                 j++) {
                System.out.println(arrayOfInts[i][j]);
                if (arrayOfInts[i][j]==searchfor){
                    foundIt=true;
                    break search;
                }
            }
        }

        if (foundIt){
            System.out.println("Found " + searchfor + " at " + i + ", " + j);
        }else {
            System.out.println(searchfor + " not in the array");
        }
    }
}
