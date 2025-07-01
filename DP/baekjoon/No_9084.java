package DP.baekjoon;

// 문제 : 동전
// 풀이 일자 : 2025.07.01
// 설명 : https://www.acmicpc.net/problem/9084

import java.util.*;
import java.io.*;

public class No_9084 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        StringBuffer answer = new StringBuffer();
        for(int i=0; i<t; i++) {
            int n = Integer.parseInt(br.readLine());
            int[] coins = new int[n];
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++) {
                coins[j] = Integer.parseInt(st.nextToken());
            }

            int m = Integer.parseInt(br.readLine());
            long[] dp = new long[m+1];
            for(int coin : coins) {
                for(int h=1; h<=m; h++) {
                    if(coin > h) {
                        continue;
                    }else if(coin == h) {
                        dp[h] += 1;
                    }else {
                        dp[h] += dp[h-coin];
                    }
                }
            }
            answer.append(dp[m]+"\n");
        }
        System.out.print(answer);
    }
    
}
