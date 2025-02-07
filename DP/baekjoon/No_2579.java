package DP.baekjoon;

// 문제 : 계단 오르기
// 풀이 일자 : 2025.02.07, 35분 소요
// 설명 : https://www.acmicpc.net/problem/2579

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class No_2579 {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] stairs = new int[n+1];
        int[] dp = new int[n+1];
        for(int i=1; i<=n; i++) {
            stairs[i] = Integer.parseInt(br.readLine());
        }

        for(int i=1; i<=n; i++) {
            dp[i] = stairs[i];

            if(i==2) {
                dp[i] += stairs[i-1];
            } else if(i > 2) {
                dp[i] += Math.max(dp[i-2], dp[i-3] + stairs[i-1]);
            }
        }

        System.out.println(dp[n]);
    }
}
