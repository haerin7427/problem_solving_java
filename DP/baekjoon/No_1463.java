package DP.baekjoon;

// 문제 : 1로 만들기
// 풀이 일자 : 2025.06.10
// 설명 : https://www.acmicpc.net/problem/1463

import java.io.*;

public class No_1463 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] dp = new int[n+1];
        dp[1] = 0;
        for(int i=2; i<=n; i++) {

            if(i % 6 == 0) {
                dp[i] = Math.min(Math.min(dp[i/3], dp[i/2]), dp[i-1]) + 1;
            }else if(i % 3 == 0) {
                dp[i] = Math.min(dp[i/3], dp[i-1]) + 1;
            }else if(i % 2 == 0) {
                dp[i] = Math.min(dp[i/2], dp[i-1]) + 1;
            }else {
                dp[i] = dp[i-1] + 1;
            }

        }
        System.out.println(dp[n]);
    }
}