package DP.baekjoon;

// 문제 : 평범한 배낭
// 풀이 일자 : 2025.06.19(2)
// 설명 : https://www.acmicpc.net/problem/12865

import java.io.*;
import java.util.*;

public class No_12865 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[][] dp = new int[n+1][k+1]; // dp[i][w] = i번째 물건까지 고려했을 때 'w'kg이하로 만들수 있는 최대 가치
        for(int i=1; i<=n; i++) {
            st = new StringTokenizer(br.readLine());
            int weight = Integer.parseInt(st.nextToken());
            int value = Integer.parseInt(st.nextToken());

            for(int w=1; w<=k; w++) {
                if(weight > w) {
                    dp[i][w] = dp[i-1][w];
                }else {
                    dp[i][w] = Math.max(dp[i-1][w], dp[i-1][w-weight] + value);
                }
            }
        }
        System.out.println(dp[n][k]);
    }
}