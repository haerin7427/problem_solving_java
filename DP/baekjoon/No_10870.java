package DP.baekjoon;

import java.io.*;

// 문제 : 피보나치 수 5
// 풀이 일자 : 2025.06.04
// 설명 : https://www.acmicpc.net/problem/10870

public class No_10870 {
    static int[] array;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        array = new int[n+1];

        for(int i=0; i<=n; i++) {
            array[i] = fibonacci(i);
        }
        System.out.println(array[n]);
    }

    private static int fibonacci(int n) {
        if(n <= 1)
            return n;
        else
            return array[n-2] + array[n-1];
    }
}