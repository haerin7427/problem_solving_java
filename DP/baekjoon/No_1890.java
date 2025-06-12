package DP.baekjoon;

// 문제 : 점프
// 풀이 일자 : 2025.06.12
// 설명 : https://www.acmicpc.net/problem/1890

import java.util.*;
import java.io.*;

public class No_1890 {
    static int[][] board;
    static long[][] dp;
    static int n;
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        board = new int[n][n];
        dp = new long[n][n];

        StringTokenizer st;
        for(int y=0; y<n; y++) {
            st = new StringTokenizer(br.readLine());
            for(int x=0; x<n; x++) {
                board[y][x] = Integer.parseInt(st.nextToken());
            }
        }

        for(int y=0; y<n; y++) {
            for(int x=0; x<n; x++) {
                if(y == 0 && x == 0) {
                    dp[y][x] = 1;
                }
                if(dp[y][x] == 0 || (y == n-1 && x == n-1)) {
                    continue;
                }

                int new_x = x + board[y][x];
                int new_y = y + board[y][x];
                if(new_x < n) {
                    dp[y][new_x] += dp[y][x];
                }
                if(new_y < n) {
                    dp[new_y][x] += dp[y][x];
                }
            }
        }
        System.out.println(dp[n-1][n-1]);
    }
}
