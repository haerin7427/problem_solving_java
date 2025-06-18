package DP.baekjoon;

// 문제 : 주지수
// 풀이 일자 : 2025.06.18
// 설명 : https://www.acmicpc.net/problem/15724

import java.util.*;
import java.io.*;

public class No_15724 {
    static int n, m, k;
    static int[][] map;
    static long[][] dp;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new int[n+1][m+1];
        dp = new long[n+1][m+1];
        for(int y=1; y<=n; y++) {
            st = new StringTokenizer(br.readLine());
            for(int x=1; x<=m; x++) {
                map[y][x] = Integer.parseInt(st.nextToken());
            }
        }
        initialize_dp();

        k = Integer.parseInt(br.readLine());
        StringBuffer sb = new StringBuffer();
        for(int i=0; i<k; i++) {
            st = new StringTokenizer(br.readLine());

            int y1 = Integer.parseInt(st.nextToken());
            int x1 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());

            long value = dp[y2][x2] - ((dp[y2][x1-1] + dp[y1-1][x2]) - dp[y1-1][x1-1]);
            sb.append(value+"\n");
        }
        System.out.print(sb);
    }

    private static void initialize_dp() {
        dp[1][1] = map[1][1];
        for(int x=2; x<=m; x++) {
            dp[1][x] = dp[1][x-1] + map[1][x];
        }

        for(int y=2; y<=n; y++) {
            dp[y][1] = dp[y-1][1] + map[y][1];
        }

        for(int y=2; y<=n; y++) {
            for(int x=2; x<=m; x++) {
                dp[y][x] = map[y][x] + ( dp[y-1][x] + dp[y][x-1] ) - dp[y-1][x-1];
            }
        }
    }
    
}
