package DP.baekjoon;

// 문제 : 피보나치 수 2
// 풀이 일자 : 2025.06.14
// 설명 : https://www.acmicpc.net/problem/2748

import java.io.*;

public class No_2748 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        long[] dp = new long[n+1];
        dp[0] = 0; dp[1] = 1;
        for(int i=2; i<=n; i++) {
            dp[i] = dp[i-2] + dp[i-1];
        }
        System.out.println(dp[n]);
    }
    
}
