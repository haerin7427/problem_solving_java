package DP.baekjoon;

// 문제 : 우유 도시
// 풀이 일자 : 2025.06.17
// 설명 : https://www.acmicpc.net/problem/14722

import java.util.*;
import java.io.*;

public class No_14722 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[][] map = new int[n][n];
        StringTokenizer st;
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            for(int j=0; j<n; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int[][] dp = new int[n][n];
        int[][] next = new int[n][n];
        int[][] move = new int[][]{{-1,0}, {0,-1}};
        dp[0][0] = map[0][0] == 0 ? 1 : 0;
        next[0][0] = map[0][0] == 0 ? 1 : 0;
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++) {
                for(int[] m : move) {
                    int ny = i + m[0];
                    int nx = j + m[1];

                    if(ny < 0 || nx < 0) continue;

                    if(next[ny][nx] == map[i][j]) {
                        if(dp[ny][nx] + 1 > dp[i][j]) {
                            dp[i][j] = dp[ny][nx] + 1;
                            next[i][j] = (map[i][j] + 1) % 3;
                        }
                    }else if(dp[ny][nx] > dp[i][j]) {
                        dp[i][j] = dp[ny][nx];
                        next[i][j] = next[ny][nx];
                    }
                }
            }
        }

        System.out.println(dp[n-1][n-1]);
    }
}