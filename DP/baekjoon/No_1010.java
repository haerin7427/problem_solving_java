package DP.baekjoon;

// 문제 : 다리 놓기
// 풀이 일자 : 2025.06.11(2)
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

            answer.append(combi(m, n) + "\n");
        }
        System.out.print(answer);
    }

    private static int combi(int n, int k) {

        if(dp[n][k] > 0) {
            return dp[n][k];
        }else if(n == k || k == 0) {
            return dp[n][k] = 1;
        }else{
            return dp[n][k] = combi(n-1, k-1) + combi(n-1, k);
        }
    }

    
}
