package DP.baekjoon;

// 문제 : 로또
// 풀이 일자 : 2025.07.01
// 설명 : https://www.acmicpc.net/problem/2758

import java.util.*;
import java.io.*;

public class No_2758 {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        StringBuffer answer = new StringBuffer();
        for(int i=0; i<t; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());

            long[][] dp = new long[n+1][m+1];
            for(int y=1; y<=n; y++) {
                for(int x=1; x<=m; x++) {
                    if(y == 1) {
                        dp[y][x] = x;
                    }else if (y > x) {
                        dp[y][x] = 0;
                    }else {
                        dp[y][x] = dp[y][x-1] + dp[y-1][x/2];
                    }
                }
            }
            answer.append(dp[n][m] + "\n");
        }
        System.out.print(answer);   
    }
}