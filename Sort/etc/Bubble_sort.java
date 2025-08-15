package Sort.etc;

import java.util.*;


public class Bubble_sort {
    public static void main(String[] args) throws Exception {
        int[] arr1 = new int[]{8, 2, 4, 1, 7};
        sort_by_bubble(arr1);
    }

    private static void sort_by_bubble(int[] arr) {
        for(int i=0; i<arr.length-1; i++) {
            boolean flag = false;
            for(int j=0; j<arr.length-1-i; j++) {

                if(arr[j] > arr[j+1]) {
                    flag = true;
                    swap(j, j+1, arr);
                }
            }

            if(!flag) {
                break;
            }
        }
        System.out.println(Arrays.toString(arr));
    }

    private static void swap(int a, int b, int[] arr) {
        int temp = arr[a];
        arr[a] = arr[b];
        arr[b] = temp;
    }
}
