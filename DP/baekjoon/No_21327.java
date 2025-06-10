package DP.baekjoon;

// 문제 : 징검다리 건너기
// 풀이 일자 : 2025.06.10
// 설명 : https://www.acmicpc.net/problem/21317

import java.util.*;
import java.io.*;

public class No_21327 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[][] rocks = new int[n+1][2];
        StringTokenizer st;
        for(int i=1; i<n; i++) {
            st = new StringTokenizer(br.readLine());
            rocks[i][0] = Integer.parseInt(st.nextToken());
            rocks[i][1] = Integer.parseInt(st.nextToken());
        }
        int k = Integer.parseInt(br.readLine());

        int[][] dp = new int[n+1][2];
        dp[1][0] = 0;
        dp[1][1] = 1000001;
        if(n>=2) {
            dp[2][0] = rocks[1][0];
            dp[2][1] = 1000001;
        }
        if(n>=3) {
            dp[3][0] = Math.min(dp[2][0] + rocks[2][0], dp[1][0] + rocks[1][1]);
            dp[3][1] = 1000001;
        }
        for(int i=4; i<=n; i++) {
            dp[i][0] = Math.min(dp[i-2][0] + rocks[i-2][1], dp[i-1][0] + rocks[i-1][0]);
            dp[i][1] = Math.min(dp[i-3][0] + k, Math.min(dp[i-2][1] + rocks[i-2][1], dp[i-1][1] + rocks[i-1][0]));
        }

        System.out.println(Math.min(dp[n][0], dp[n][1]));
    }
    
}
