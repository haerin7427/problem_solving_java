package DP.baekjoon;

// 문제 : 동전 2
// 풀이 일자 : 2025.06.16
// 설명 : https://www.acmicpc.net/problem/2294

import java.util.*;
import java.io.*;

public class No_2294 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] coins = new int[n];
        for(int i=0; i<n; i++) {
            coins[i] = Integer.parseInt(br.readLine());
        }
        
        int[] dp = new int[k+1];
        for(int i=0; i<dp.length; i++) {
            int min = i+1;
            for(int coin : coins) {
                if(coin > i) {
                    continue;
                }else if(coin == i) {
                    min = 1;
                }else if(min > dp[i-coin] + 1) {
                    if(dp[i-coin] != -1) {
                        min = dp[i-coin] + 1;
                    }
                }
            }
            if(min < i+1) {
                dp[i] = min;
            }else {
                dp[i] = -1;
            }
        }
        
        System.out.println(dp[k]);
    }
}