package DP.baekjoon;

// 문제 : 돌 게임
// 풀이 일자 : 2025.06.09
// 설명 : https://www.acmicpc.net/problem/9655

import java.io.*;

public class No_9655 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] divide = new int[]{6,4,2};

        for(int d : divide) {
            n %= d;
        }

        if(n == 1) {
            System.out.println("SK");
        }else {
            System.out.println("CY");
        }

        // dp_version(n);
    }

    private static void dp_version (int n) {

        int[] dp = new int[n+1]; // dp[i] = i개의 돌이 있을 때 게임 하는 사람이 돌을 가져가는 횟수
        dp[1] = 1;
        if(n>=2) {dp[2] = 2;}
        if(n>=3) {dp[3] = 1;}
        for(int i=4; i<=n; i++) {
            dp[i] = Math.min(dp[i-3], dp[i-1]) + 1;
        }

        if(dp[n] % 2 == 0) {
            System.out.println("CY");
        }else {
            System.out.println("SK");
        }

    }
    
}