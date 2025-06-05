package DP.baekjoon;

// 문제 : 다리 놓기
// 풀이 일자 : 2025.06.05
// 설명 : https://www.acmicpc.net/problem/1010

import java.util.*;
import java.io.*;

public class No_1010 {
    static int[][] dp = new int[30][30];
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        StringBuffer answer = new StringBuffer();
        StringTokenizer st;
        for(int i=0; i<t; i++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            int ans = factorial(m, n);
            answer.append(ans + "\n");
        }
        System.out.print(answer);
    }

    static int factorial(int n, int r) {

        if(dp[n][r] > 0) {
            return dp[n][r];
        }

        if(n == r || r == 0) {
            return dp[n][r] = 1;
        }

        return dp[n][r] = factorial(n-1, r-1) + factorial(n-1, r);
    }
}
