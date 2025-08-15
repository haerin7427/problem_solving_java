package Sort.etc;

import java.util.Arrays;

public class Insert_sort {
    public static void main(String[] args) throws Exception {
        int[] arr2 = new int[]{9, 6, 3, 1, 2};
        sort_by_insert(arr2);
    }


    private static void sort_by_insert(int[] arr) {
        for(int i=1; i<arr.length; i++) {
            for(int j=0; j<i; j++) {
                if(arr[i] < arr[j]) {
                    move(i, j, arr);
                    break;
                }
            }

        }
        System.out.println(Arrays.toString(arr));
    }

    private static void move(int from, int to, int[] a) {
        int v = a[from];
        System.arraycopy(a, to, a, to + 1, from - to);
        a[to] = v;
    } 
}
