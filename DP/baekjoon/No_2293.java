package DP.baekjoon;

// 문제 : 동전 1
// 풀이 일자 : 2025.06.13
// 설명 : https://www.acmicpc.net/problem/2293

import java.util.*;
import java.io.*;

public class No_2293 {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] coins = new int[n];
        for(int i=0; i<n; i++) {
            coins[i] = Integer.parseInt(br.readLine());
        }

        long[][] dp = new long[n][k+1]; // dp[i][j] 는 i+1 종류의 코인을 가지고 j를 만드는 경우의 수
        for(int y=0; y<n; y++) {
            int coin = coins[y];
            for(int x=1; x<=k; x++) {
                if(x - coin > 0) {
                    dp[y][x] += dp[y][x-coin];
                }else if(x == coin) {
                    dp[y][x] += 1;
                }
                
                if(y > 0) {
                    dp[y][x] += dp[y-1][x];
                }
            }
        }
        
        System.out.println(dp[n-1][k]);
    }   
}