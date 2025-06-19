package DP.baekjoon;

// 문제 : 최대 페이지 수
// 풀이 일자 : 2025.06.19
// 설명 : https://www.acmicpc.net/problem/16493

import java.util.*;
import java.io.*;

public class No_16493 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] dp = new int[m+1][n+1];  // dp[i][j] = i번째 챕터까지 고려했을 때 j일 이내에 읽을 수 있는 최대 페이지 수
        for(int i=1; i<=m; i++) {
            st = new StringTokenizer(br.readLine());
            int day = Integer.parseInt(st.nextToken());
            int pages = Integer.parseInt(st.nextToken());

            for(int j=1; j<=n; j++) {
                if(j >= day) {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i-1][j-day] + pages);
                }else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        System.out.println(dp[m][n]);
    }
}