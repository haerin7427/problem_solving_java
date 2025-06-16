package DP.baekjoon;

// 문제 : 퇴사 2
// 풀이 일자 : 2025.06.16
// 설명 : https://www.acmicpc.net/problem/15486

import java.util.*;
import java.io.*;

public class No_15486 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] info = new int[n+1][2];

        StringTokenizer st;
        for(int i=1; i<=n; i++) {
            st = new StringTokenizer(br.readLine());
            info[i][0] = Integer.parseInt(st.nextToken()); // time
            info[i][1] = Integer.parseInt(st.nextToken()); // money
        }

        int max_money = 0; // 현재 최대로 벌 수 있는 돈
        int[] dp = new int[n+1]; // 1일부터 i일까지 최대로 벌 수 있는 돈
        for(int i=1; i<=n; i++) {

            int end_day = i + info[i][0] - 1;
            if(end_day <= n) {
                dp[end_day] = Math.max(dp[end_day], max_money+info[i][1]);
            }

            if(max_money < dp[i]) {
                max_money = dp[i];
            }else {
                dp[i] = max_money;
            }
        }
        System.out.println(dp[n]);
    }
}