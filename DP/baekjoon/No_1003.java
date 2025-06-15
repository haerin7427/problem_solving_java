package DP.baekjoon;

// 문제 : 피보나치 함수
// 풀이 일자 : 2025.06.15
// 설명 : https://www.acmicpc.net/problem/1003

import java.io.*;

public class No_1003 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        int[] n_array = new int[t];
        int max = 0;
        for(int i=0; i<t; i++) {
            n_array[i] = Integer.parseInt(br.readLine());
            if(n_array[i] > max) {
                max = n_array[i];
            }
        }

        int[][] dp = new int[max+1][2];
        dp[0][0] = 1; dp[0][1] = 0;
        if(dp.length > 1) {
            dp[1][0] = 0; dp[1][1] = 1;
        }
        for(int i=2; i<dp.length; i++) {
            dp[i][0] = dp[i-2][0] + dp[i-1][0];
            dp[i][1] = dp[i-2][1] + dp[i-1][1];
        }

        StringBuffer answer = new StringBuffer();
        for(int n : n_array) {
            answer.append(dp[n][0] +" " + dp[n][1]+ "\n");
        }
        System.out.print(answer);
    } 
}